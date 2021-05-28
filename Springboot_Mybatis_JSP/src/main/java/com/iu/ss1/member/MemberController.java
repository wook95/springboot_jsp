package com.iu.ss1.member;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	

	@GetMapping("join")
	public void memberJoin(Model model) throws Exception{
		
		model.addAttribute("memberVO", new MemberVO());
	}
	
	//벨리드 뒤에 바로 바인딩리절트 와야함 순서 바꾸면 안됨
	@PostMapping("join")
	public String setJoin(@Valid MemberVO memberVO,Errors bindingResult)throws Exception{
		
		if(bindingResult.hasErrors()) {
		return "member/join";	
		}		
		
		int result= memberService.setJoin(memberVO);
		return "redirect:../";
	}
	
	@GetMapping("login")
	public String getLogin()throws Exception{

		return "member/login";
	}
//	@PostMapping("login")
//	public String getLogin(MemberVO memberVO,HttpSession session)throws Exception{
//
//		System.out.println(memberVO.getUsername());
//		System.out.println(memberVO.getPassword());
//		memberVO=memberService.getLogin(memberVO); 
//		
//		if(memberVO != null) {
//		session.setAttribute("member", memberVO);
//		}
//		
//		return "redirect:/";
//	}
	
	@GetMapping("memberLoginResult")
	public String memberLoginResult(HttpSession session,Authentication auth2)throws Exception{
		
		
		//세션의 속성명들 꺼내옴
		Enumeration<String> en= session.getAttributeNames();
		
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
		Object obj = session.getAttribute("SPRING_SECURITY_CONTEXT");
		System.out.println(obj);
		
		//로그인 시 session의 속성명 : SPRING_SECURITY_CONTEXT
				//SecurityContextImpl [Authentication=UsernamePasswordAuthenticationToken 
				//	[Principal=com.iu.ss1.member.MemberVO@4c9e4d43, Credentials=[PROTECTED], Authenticated=true,
				//Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=33ED207732D3A185979F79058A68DED1],
				//Granted Authorities=[ROLE_MEMBER]]]
		//세션, 리퀘스트에 뭐가 들어갔는지 모를때 이렇게찾아봐라!
		SecurityContextImpl sc = (SecurityContextImpl)obj;
		Authentication auth = sc.getAuthentication();
		System.out.println("auth name :"+auth.getName());
		System.out.println("auth detail :"+auth.getDetails());
		System.out.println("principal : "+auth.getPrincipal());
		System.out.println("authorities :"+auth.getAuthorities());
		System.out.println("====================");
		
		System.out.println("auth name2 :"+auth2.getName());
		System.out.println("auth detail2 :"+auth2.getDetails());
		System.out.println("principal2 : "+auth2.getPrincipal());
		System.out.println("authorities2 :"+auth2.getAuthorities());
	
		System.out.println("login success");
		return "redirect:/";
	}
	
}
