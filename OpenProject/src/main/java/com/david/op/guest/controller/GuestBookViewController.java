package com.david.op.guest.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.david.op.guest.model.Message;
import com.david.op.guest.service.ViewMessageService;

@Controller
public class GuestBookViewController {

	@Autowired
	ViewMessageService service;
	
	@RequestMapping("/guestbook/view/{id}")
	public String getView(@PathVariable("id") int id, Model model) {
		Message message=null;
		try {
			message = service.getMessage(id);
		} catch (SQLException e) {
			System.out.println("메세지 로딩에 실패하였습니다.");
		}
		model.addAttribute("message",message);
		return "/guestbook/view";
	}
	
}
