package com.david.op.member.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.david.op.member.model.Memberinfo;
import com.david.op.member.service.MemberListService;

@Controller
public class MemberListController {
	
	@Autowired
	MemberListService memberListService;
	
	@RequestMapping("/member/list")
	public String memListView() {
		return "member_page";
	}
	@RequestMapping("/member/viewType")
	public ModelAndView viewHTML(@RequestParam(value="type",defaultValue="HTML") String type) {
		ModelAndView modelAndView = new ModelAndView();
		switch (type) {
		case "HTML":
			modelAndView.setViewName("/member/viewTypeHTML");
			break;
		case "JSON":
			modelAndView.setViewName("/member/viewTypeJSON");
			break;
		case "XML":
			modelAndView.setViewName("/member/viewTypeXML");
			break;
		}
		
			List<Memberinfo> members = null;
			try {
				members = memberListService.memberListView();
			} catch (SQLException e) {
				System.out.println("리스트 출력에 실패하였습니다.");
			}
			modelAndView.addObject("members",members);
		
		return modelAndView;
	}
}
