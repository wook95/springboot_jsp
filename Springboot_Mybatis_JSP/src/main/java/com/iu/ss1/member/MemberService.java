package com.iu.ss1.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;




@Service
public class MemberService implements UserDetailsService {

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private PasswordEncoder passwordEncoder; //config에서 bean으로 만들어줘서 auto가능
												//패스워드 암호화 클래스

	
	
	
	@Transactional(rollbackFor = Exception.class)
	public int setJoin(MemberVO memberVO)throws Exception{
		
		//0. 사전작업 
			//패스워드 암호화
		System.out.println(memberVO.getPassword());
		
		memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
			//사용자 계정 활성화
		memberVO.setEnabled(true);
		
		
		
		//member table 저장
		int result = memberMapper.setJoin(memberVO);
		//role 테이블 저장
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", memberVO.getUsername());
		map.put("roleName", "ROLE_MEMBER");
		result = memberMapper.setMemberRole(map);
		
		//hdd에 파일 저장
		//memberFiles 테이블 저장
		
	
		

	
		
		
		return result;
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
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println(username);
		
		//스프링 시큐리티에서 알아서 로그인 처리해줌
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername(username);
		memberVO=memberMapper.getLogin(memberVO);
		
		
		
		
		return memberVO;
	}
	
	
}
