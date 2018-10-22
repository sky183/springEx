package com.david.op.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.david.op.guest.model.Message;
import com.david.op.guest.service.ServiceException;
import com.david.op.guest.service.WriteMessageService;


@Controller
public class GuestBookWriteController {
	
	@Autowired
	WriteMessageService writeMsg;
	
	@RequestMapping("/guestbook/write")
	public ModelAndView writeDo(Message msg) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/guestbook/list");
		try {
			writeMsg.write(msg);
		} catch (ServiceException e) {
			modelAndView.addObject("errorMsg",e);
			modelAndView.setViewName("/guestbook/writeFailed");
		} finally {
			
		}
		return modelAndView;
	}
	
}
