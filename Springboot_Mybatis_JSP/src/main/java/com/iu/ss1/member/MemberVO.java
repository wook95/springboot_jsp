package com.iu.ss1.member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberVO {
	@NotBlank(message = "빈칸이 올 수 없습니다!")
	@Size(min=4)
	private String id;
	@Length(min=4,max=10)
	private String pw;
	@NotEmpty(message = "필수 항목 입니다")
	private String name;
	@Email
	private String email;
	private String phone;
	
}
