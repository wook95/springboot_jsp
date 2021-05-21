package com.iu.ss1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;

	
	public int setJoin(MemberVO memberVO)throws Exception{

		return memberMapper.setJoin(memberVO);
	}
	public MemberVO getLogin(MemberVO memberVO)throws Exception{
		return memberMapper.getLogin(memberVO);
	}
	
	public int setUpdate(MemberVO memberVO)throws Exception{
		return memberMapper.setUpdate(memberVO);
	}
	public int setDelete(MemberVO memberVO)throws Exception{
		return memberMapper.setDelete(memberVO);
		
	}
}
