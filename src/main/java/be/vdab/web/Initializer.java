package be.vdab.web;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import be.vdab.datasource.DataSourceConfig;
import be.vdab.repositories.RepositoriesConfig;
import be.vdab.services.ServicesConfig;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { DataSourceConfig.class, RepositoriesConfig.class, ServicesConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { ControllersConfig.class };
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new CharacterEncodingFilter("UTF-8") };
	}
}
