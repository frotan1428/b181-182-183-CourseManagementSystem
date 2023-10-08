package com.tpe;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class webAppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {



    //db and hibernate Config
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                RootContextConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebMvcConfig.class
        };
    }

    @Override// which URL will associated with servlet
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
