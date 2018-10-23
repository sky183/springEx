package com.david.op.guest.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.david.op.guest.dao.MessageDAO;
import com.david.op.guest.model.Message;

@Component
public class WriteMessageService {
	@Autowired
	private MessageDAO messageDAO;

	@Transactional
	public void write(Message msg) throws ServiceException {
		try {
			messageDAO.insert(msg);
		} catch (SQLException e) {
			throw new ServiceException("메세지 등록 실패: " + e.getMessage());
		}

	}
}
