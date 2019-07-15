package wnderful.yummy.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Configuration
@Component
public class FilterConfiguration {


    private final LoginFilter filter;

    @Autowired
    public FilterConfiguration(LoginFilter filter) {
        this.filter = filter;
    }

    @Bean
    @Order(1)
    public FilterRegistrationBean loginFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(filter);
        ArrayList<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/service/*");// 设置匹配的url
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }
}
