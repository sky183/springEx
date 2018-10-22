package com.david.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.david.op.member.model.Memberinfo;
import com.david.op.member.service.MemberRegService;

@Controller
@RequestMapping("/member/modify")
public class MemberModifyController {
	
	@Autowired
	@Qualifier("memReg")
	private MemberRegService memberModifyService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String memberModify(String mkey, Model model) {
		model.addAttribute("mkey", mkey);
		return "memberModify_page";
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView memberModifyDo(HttpServletRequest request,
			Memberinfo memberinfo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member_page");
		try {
			memberModifyService.memberRegDo(request, memberinfo);
		} catch (Exception e) {
			String errorMsg = "회원정보 수정에 실패하였습니다";
			modelAndView.setViewName("memberModify_page?mkey="+memberinfo.getUSERID());
			modelAndView.addObject("errorMsg",errorMsg);
			e.printStackTrace();
		}
		return modelAndView;
	}
}
