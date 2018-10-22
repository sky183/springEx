package com.david.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.david.op.member.model.Memberinfo;
import com.david.op.member.service.MemberRegService;

@Controller
@RequestMapping("/member/join")
public class MemberRegController {
	
	@Autowired
	@Qualifier("memReg")
	private MemberRegService memberReg;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView regForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/join_page");
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView regDo(HttpServletRequest request,
			Memberinfo memberinfo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member_page");
		try {
			memberReg.memberRegDo(request, memberinfo);
		} catch (Exception e) {
			String errorMsg = "등록에 실패하였습니다";
			modelAndView.setViewName("/join_page");
			modelAndView.addObject("errorMsg",errorMsg);
			e.printStackTrace();
		}
		return modelAndView;
	}

}
