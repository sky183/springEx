package com.david.op.member.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.david.op.member.service.MemberValidCheckService;

@Controller
public class MemberValidCheckController {
	
	@Autowired
	MemberValidCheckService validService;
	
	@RequestMapping("/member/idValidCheck")
	public ModelAndView idValidCheck(String keyid) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member/joinValid");
		String msg = "";
		try {
			msg = validService.idValidCheck(keyid);
		} catch (SQLException e) {
			msg="데이터서버 오류";
			e.printStackTrace();
		}
		modelAndView.addObject("IdValid", msg);
		return modelAndView;
	}
}
