package com.david.op.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.david.op.guest.model.MessageListView;
import com.david.op.guest.service.GetMessageListService;
import com.david.op.guest.service.ServiceException;

@Controller
public class GuestBookListController {
	@Autowired
	private GetMessageListService getListService;

	@RequestMapping("/guestbook/list")
	public ModelAndView getListDo(
			@RequestParam(value = "page", defaultValue = "1", required = false) int pageNumber) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/guestMs_page");
		try {
			MessageListView listView = getListService.getMessageList(pageNumber);
			modelAndView.addObject("listView", listView);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return modelAndView;
	}
}
