package com.david.op.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.david.op.member.model.Logininfo;

@Controller
public class MemberMyPageController {
	
	@RequestMapping("/member/myPage")
	public String viewMyPage(Logininfo lonininfo) {
		return "/my_page";
	}
}
