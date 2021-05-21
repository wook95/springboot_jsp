package com.iu.ss1.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
}
