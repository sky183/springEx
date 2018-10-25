package com.david.op.guest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.david.op.guest.service.DeleteMessageService;
import com.david.op.guest.service.MessageInvalidOwnerException;
import com.david.op.guest.service.MessageNotFoundException;
import com.david.op.guest.service.ServiceException;


@Controller
@RequestMapping("/guestbook/delete")
public class GuestBookDeleteController {
	@Autowired
	private DeleteMessageService delMsg;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView deleteConfirm(
			) {
		ModelAndView modelAndView = new ModelAndView();
		boolean InvalidPassword = false;
		modelAndView.setViewName("/guestbook/deleteConfirm");
		modelAndView.addObject("InvalidPassword",InvalidPassword);
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView deleteDo(HttpSession session, int messageId) 
			throws ServiceException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/guestbook/list");
		try {
			delMsg.deleteMessage(messageId, session);
		} catch (MessageInvalidOwnerException | MessageNotFoundException e) {
			modelAndView.addObject("errorMsg", e.getMessage());
			modelAndView.setViewName("/guestbook/deleteConfirm");
		} finally {
		}
		return modelAndView;
	}
	
}
