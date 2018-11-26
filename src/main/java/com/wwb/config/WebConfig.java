package com.wwb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("com.wwb.controller")
public class WebConfig extends WebMvcConfigurerAdapter{

    //配置视图解析器
    @Bean
    public ViewResolver viewResolver(){
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        //设置默认视图解析器
        List<View> dList = new ArrayList<>();
        dList.add(new MappingJackson2JsonView());
        resolver.setDefaultViews(dList);

        InternalResourceViewResolver resourceView = new InternalResourceViewResolver();
        resourceView.setPrefix("/WEB-INF/views/");
        resourceView.setSuffix(".jsp");
        resourceView.setExposeContextBeansAsAttributes(true);
        List<ViewResolver> rList = new ArrayList<>();
        rList.add(resolver);
        resolver.setViewResolvers(rList);
        return resolver;
    }

    /**
     * multipart的解析器  依赖于Servlet 3.0对multipart请求的支持（始于Spring 3.1）。
     * @return
     * @throws IOException
     */
    @Bean
    public MultipartResolver multipartResolver() throws IOException{
        return new StandardServletMultipartResolver();
    }

    /*
   //使用Jakarta Commons FileUpload解析multipart请求；
   @Bean
   public MultipartResolver multipartResolver() throws IOException {
       CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
       multipartResolver.setUploadTempDir(new FileSystemResource("/tmp/spittr/uploads"));//默认临时文件路径是Servlet容器的临时目录
       multipartResolver.setMaxUploadSize(2097152);//整个multipart请求的最大容量（以字节为单位），默认是没有限制的。
       multipartResolver.setMaxInMemorySize(0);//最大的内存大小设置为0字节，所有上传的文件都会写入到磁盘上
       return multipartResolver;
    }
    */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //配置静态文件处理
        configurer.enable();
    }




}
