package cn.cote.config;

import cn.cote.myutils.Interceptor.OneInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebConigurer implements WebMvcConfigurer{

//    添加拦截器(按顺序执行)
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
           registry.addInterceptor(new OneInterceptor()).addPathPatterns("/show2");
//           可以在add后继续添加add同时拦劫多个路由
//           测试发现，后面的路径不必包含 /demo (项目路由前缀(context-path))
    }
}
