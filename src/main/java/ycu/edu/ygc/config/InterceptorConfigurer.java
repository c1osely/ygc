package ycu.edu.ygc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ycu.edu.ygc.web.UserLoginInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/5 11:35
 */
@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer {

    //重写方法，注册拦截器（InterceptorRegistry）

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建拦截器类
        UserLoginInterceptor userLoginInterceptor = new UserLoginInterceptor();

        //设置白名单
        List<String> patterns=new ArrayList<>();
        patterns.add("/user/logon");
        patterns.add("/user/login");

        //todo 前端请求文件的白名单待添加
//        patterns.add("/web/logon.html");
//        patterns.add("/web/login.html");
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        //注册拦截器类，添加黑名单(addPathPatterns("/**")),‘/*’只拦截一个层级，'/**'拦截全部
        // 和白名单(excludePathPatterns("List类型参数"))，将不必拦截的路径添加到List列表中
        registry.addInterceptor(userLoginInterceptor).addPathPatterns("/**").excludePathPatterns(patterns);
    }
}
