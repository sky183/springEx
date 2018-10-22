package com.david.op.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.david.op.member.service.MemberDeleteService;


@Controller
public class MemberButtonController {
	
	@Autowired
	MemberDeleteService delService;

	@RequestMapping("/member/logout")
	public String logout(HttpSession session) {
		session.setAttribute("loginfo", null);
		return "redirect:/member/login";
	}
	
	@RequestMapping("/member/delete")
	public String memberDelete(String dkey) {
		try {
			delService.memberDelete(dkey);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/member/list";
	}
	
}
