package com.bionic.edu.proc;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan(basePackages = "com.bionic.edu.web")
public class ApplicationContextConfig extends WebMvcConfigurationSupport {
	@Bean(name = "viewResolver")
	public UrlBasedViewResolver getViewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	@Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource getMessageSource() {
	ReloadableResourceBundleMessageSource messageSource = 		new ReloadableResourceBundleMessageSource();
	messageSource.setBasename("classpath:mess/messages");
	messageSource.setDefaultEncoding("UTF-8");
	return messageSource;
    }
	@Bean(name = "localeResolver")
    public CookieLocaleResolver getLocaleResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver(); 
         localeResolver.setDefaultLocale(new Locale("en"));
         localeResolver.setCookieName("myAppLocaleCookie");
         localeResolver.setCookieMaxAge(3600);
         return localeResolver;
     }
	@Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor interceptor = new 	LocaleChangeInterceptor();
        interceptor.setParamName("locale");
        return interceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }


}
