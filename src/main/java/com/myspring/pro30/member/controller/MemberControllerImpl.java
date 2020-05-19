package com.myspring.pro30.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.myspring.pro30.member.service.MemberService;
import com.myspring.pro30.member.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl implements MemberController{
	
	@Autowired
	private MemberService memberService;
	@Autowired
	MemberVO memberVO;
	
	

}
