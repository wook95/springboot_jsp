package com.iu.ss1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends  WebSecurityConfigurerAdapter{

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}//인터페이스라 바로 객체 못 만들고 구현된 객체 사용
	
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {

		//security를 무시(제외)
		web.ignoring()
		.antMatchers("/resources/**")
		.antMatchers("/images/**")
		.antMatchers("/css/**")
		.antMatchers("/js/**")
		.antMatchers("/vendor/**")
		.antMatchers("/favicon/**")
		;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.exceptionHandling()
				//사용하지 않으면 기본 제공 에러 처리 방법 사용 403.html
				.accessDeniedPage("/member/error")	//url주소로 보내는 방법
				//accessDeniedHandler(new SecurityException()) //전문 처리 객체 만드느법
				.and()
			.cors().and()
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/notice/list","/notice/select").permitAll()
			.antMatchers("/notice/**").hasRole("ADMIN")
			.antMatchers("/qna/list").permitAll()
			.antMatchers("qna/**").hasAnyRole("ADMIN","MEMBER")		
			.antMatchers("/member/join").permitAll()
			.antMatchers("/member/**").hasAnyRole("ADMIN","MEMBER")
			.anyRequest().authenticated()
			.and()
		.formLogin()
			//로그인 페이지 따로 안 만들어도 기본 폼으로 이동하는데
			//내가 만든 폼으로 이동하고 싶으면 이렇게 !
			//어서라이즈 리퀘스트 한덩어리,, 폼 로그인은 다르 덩어리
			//and 쓰기 싫으면 http. 쓰면 된다
			//usernameParameter(null) --> 유저네임을 다른 이름으로 쓰고 싶을 때
			//passwordParameter(null) --> password대신 다른 이름 쓰고 싶을때 
			.loginPage("/member/login")
			.defaultSuccessUrl("/member/memberLoginResult")
			//로그인 실패시 처리 - 안해도 되지만 할수있어!~! / 에러 파라미터는 컨트롤러에서 조정
			//.failureUrl("/member/loginFail?error")		
			//failureHandler(null)
			.permitAll()
			.and()
		.logout()
			.logoutUrl("/member/logout")	 //로그아웃
			.logoutSuccessUrl("/")			//로그아웃 후 가는 주소
			.invalidateHttpSession(true)	//세션 삭제, 밑은 쿠키 삭제
			.deleteCookies("JSESSIONID")
			.permitAll()
			.and()
		.exceptionHandling()
			.accessDeniedPage(null) 		//권한 에러 발생(403)
			.accessDeniedHandler(null) 		//에러 처리 클래스선언 - 우리가 만들어야됨
			;
		

	}
	
}
