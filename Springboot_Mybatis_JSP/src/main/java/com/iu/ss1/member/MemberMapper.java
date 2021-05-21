package com.iu.ss1.member;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface MemberMapper {

	
	public int setJoin(MemberVO memberVO)throws Exception;
	
	public MemberVO getLogin(MemberVO memberVO)throws Exception;
	
	public int setUpdate(MemberVO memberVO)throws Exception;
	public int setDelete(MemberVO memberVO)throws Exception;
	
	
}
