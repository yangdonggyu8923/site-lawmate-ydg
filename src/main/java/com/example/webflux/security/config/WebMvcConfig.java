//package com.example.webflux.security.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
//public class WebMvcConfig implements WebMvcConfigurer{
//   @Override
//    public void addFormatters( FormatterRegistry registry) {
//        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
//        registrar.setUseIsoFormat(true);
//        registrar.registerFormatters(registry);
//    }
//}
//
