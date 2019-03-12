package wnderful.yummy.memberServiceTests;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import wnderful.yummy.blserviceImpl.BaseServiceImpl;
import wnderful.yummy.response.BaseResponse.MemberSignUpRes;
import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.baseResponseCode.MemberSignUpCode;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MemberSignUpTest {
    @Autowired
    BaseServiceImpl baseService;


	@Test
	public void test1() {
        Response response = baseService.memberSignUp("","","","");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new MemberSignUpRes(MemberSignUpCode.EMPTY));
        assertEquals(repStr,hopeRepStr);
	}

    @Test
    public void test2() {
        Response response = baseService.memberSignUp("蔡頔希","caidixi@163.com","123456","");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new MemberSignUpRes(MemberSignUpCode.EMPTY));
        assertEquals(repStr,hopeRepStr);
    }

    @Test
    public void test3() {
        Response response = baseService.memberSignUp("蔡頔希","caidixi@163.com","123456","南京市鼓楼区南京大学陶园二舍");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new MemberSignUpRes(MemberSignUpCode.SUCCESS));
        assertEquals(repStr,hopeRepStr);
    }

    @Test
    public void test4() {
        Response response = baseService.memberSignUp("蔡頔希","caidixi@163.com","123456","南京市鼓楼区南京大学陶园二舍");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new MemberSignUpRes(MemberSignUpCode.EXIST));
        assertEquals(repStr,hopeRepStr);
    }
}

