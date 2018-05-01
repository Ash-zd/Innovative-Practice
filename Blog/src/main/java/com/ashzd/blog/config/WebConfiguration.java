package com.ashzd.blog.config;
import com.ashzd.blog.interceptor.PassportInterceptor;
import com.ashzd.blog.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Component
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Autowired
    private PassportInterceptor passportInterceptor;

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(passportInterceptor);
        registry.addInterceptor(loginInterceptor).addPathPatterns("/create");
        //registry.addInterceptor(articleClickInterceptor).addPathPatterns("/article/*");
        super.addInterceptors(registry);
    }
}
