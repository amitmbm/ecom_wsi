package com.wsi.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfigurationAnnotationEx {

	@Bean
	public CategoryServices beanEx()
	{
		return new BeanEx();
	}
}
