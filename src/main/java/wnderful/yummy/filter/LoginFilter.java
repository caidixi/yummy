package wnderful.yummy.filter;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wnderful.yummy.dataServiceImpl.ManagerDataServiceImpl;
import wnderful.yummy.dataServiceImpl.MemberDataServiceImpl;
import wnderful.yummy.dataServiceImpl.RestaurantDataServiceImpl;
import wnderful.yummy.response.GlobalResponse;
import wnderful.yummy.responseCode.GlobalRepCode;
import wnderful.yummy.util.JWTHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

@Component
@WebFilter(urlPatterns = "/service/*",filterName = "LoginFilter")
public class LoginFilter implements Filter {
    private  JWTHelper jwtHelper;
    private MemberDataServiceImpl memberDataService;
    private RestaurantDataServiceImpl restaurantDataService;
    private ManagerDataServiceImpl managerDataService;

    @Autowired
    public LoginFilter(JWTHelper jwtHelper, MemberDataServiceImpl memberDataService, RestaurantDataServiceImpl restaurantDataService, ManagerDataServiceImpl managerDataService) {
        this.jwtHelper = jwtHelper;
        this.memberDataService = memberDataService;
        this.restaurantDataService = restaurantDataService;
        this.managerDataService = managerDataService;
    }

    @Override
    public void init(FilterConfig arg) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        boolean loginSuccess = false;

        String token = "";
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            //System.out.println("has cookies");
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("token")){
                    token = cookie.getValue();
                    break;
                }
            }
        }
        //System.out.println("token: "+token);

        String[] names = request.getRequestURI().split("/");
        String type = names[2];
        //System.out.println(type);

        try{
            String[] tokenInfo = jwtHelper.verifyToken(token);
            String username = tokenInfo[0];
            String myType = tokenInfo[1];
            if(type.equals(myType)){
                if(type.equals("member")){
                    loginSuccess = memberDataService.memberPhoneExist(username);
                }
                if(type.equals("restaurant")){
                    loginSuccess = restaurantDataService.restaurantRidExist(username);
                }
                if(type.equals("manager")){
                    loginSuccess = managerDataService.managerEmailExist(username);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        if(loginSuccess){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            try{
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(response.getOutputStream(),"UTF-8");
                PrintWriter writer = new PrintWriter(outputStreamWriter);
                GlobalResponse globalResponse = new GlobalResponse(GlobalRepCode.TOKENERROR);
                writer.write(JSON.toJSONString(globalResponse));
                writer.flush();
                writer.close();
                outputStreamWriter.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void destroy(){

    }
}
