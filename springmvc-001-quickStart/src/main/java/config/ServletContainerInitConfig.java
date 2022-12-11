package config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;

//servlet容器启动的配置类，目的是让tomcat服务器读取springmvc的配置类
public class ServletContainerInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        //加载spring容器
        return new Class[]{};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        //加载springmvc的配置
        return new Class[]{SpringMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        //设置哪些请求归springmvc处理
        return new String[]{"/"};
    }

    //处理乱码问题
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter=new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[] {filter};
    }
}

////servlet容器启动的配置类，目的是让tomcat服务器读取springmvc的配置类
//public class ServletContainerInitConfig extends AbstractDispatcherServletInitializer {
//    //加载springmvc的配置
//    @Override
//    protected WebApplicationContext createServletApplicationContext() {
//        AnnotationConfigWebApplicationContext app=new AnnotationConfigWebApplicationContext();
//        app.register(SpringMvcConfig.class);
//        return app;
//    }
//
//    //设置哪些请求归springmvc处理
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
//    //加载spring容器
//    @Override
//    protected WebApplicationContext createRootApplicationContext() {
//        return null;
//    }
//}

