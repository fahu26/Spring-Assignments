package com.fahim.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

@Override
protected Class<?>[] getRootConfigClasses() {
   return new Class[]{WebConfig.class};
}

@Override
protected Class<?>[] getServletConfigClasses() {
   return new Class[]{RootConfig.class};
}

@Override
protected String[] getServletMappings() {
   return new String[]{"/"};
}
}

