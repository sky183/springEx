package com.david.op.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.david.op.member.service.MemberLoginService;

@Controller
@RequestMapping("/member/login")
public class MemberLoginController {
	
	@Autowired
	MemberLoginService loginService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String Login(HttpSession session) {
		session.setAttribute("loginMsg", "");
		return "/login_page";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView LoginDo(String USERID, String USERPW, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		boolean login = false;
		modelAndView.setViewName("/login_page");
		if(USERID!=null&&USERPW!=null) {
			try {
				login = loginService.login(USERID, USERPW, session);
				if(login==false) {
					System.out.println("로그인 실패");
				} else {
					System.out.println("로그인 성공");
					modelAndView.setViewName("redirect:/member/myPage");
				}
			} catch (SQLException e) {
				System.out.println("오류로인해 로그인에 실패하였습니다.");
			}
		}
		return modelAndView;
	}
	
}
