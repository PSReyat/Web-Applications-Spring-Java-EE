package com.shonamitambo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.shonamitambo.config.*;

public class MyWebAppInitialiser extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] {GameAppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] {GameWebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] { "/" };
	}

}
