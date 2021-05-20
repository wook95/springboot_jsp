package com.iu.ss1.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
public class MessageLocaleConfig implements WebMvcConfigurer{

	
	@Bean
	public LocaleResolver localResolver() {
		//session을 사용하여 설정하는 경우
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.KOREAN);
	
		
		//쿠키를 사용하여 설정
		CookieLocaleResolver cookiResolver = new CookieLocaleResolver();
		cookiResolver.setDefaultLocale(Locale.KOREAN);
		cookiResolver.setCookieName("lang");
		
		return cookiResolver;
		
		
		
	}
	
	

//	@Bean
//	public LocaleChangeInterceptor localeChangeInterceptor() {
//		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//		localeChangeInterceptor.setParamName("lang");
//		//파라미터에 따라 언어 구분
//		//url?lang=en
//		
//		
//		return localeChangeInterceptor();
//		
//		
//	}
//	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//
//		registry.addInterceptor(localeChangeInterceptor())
//				.addPathPatterns("/**");
//		
//		
//		// TODO Auto-generated method stub
//	}
	
	
	
	
	
}
