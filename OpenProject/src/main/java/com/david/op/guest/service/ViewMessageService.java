package com.david.op.guest.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.david.op.guest.dao.MessageDAO;
import com.david.op.guest.model.Message;

@Component
public class ViewMessageService {

	@Autowired
	MessageDAO messageDAO;
	
	@Transactional
	public Message getMessage(int messageId) throws SQLException {
		Message message=null;
		try {
			message=messageDAO.select(messageId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return message;
	}
	
}
