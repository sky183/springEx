package com.david.op.guest.service;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.david.op.guest.dao.MessageDaoInterface;
import com.david.op.guest.model.Message;

@Service
public class ViewMessageService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	MessageDaoInterface messageDao;
	
	@Transactional
	public Message getMessage(int messageId) throws SQLException {
		Message message=null;
		messageDao=sqlSessionTemplate.getMapper(MessageDaoInterface.class);
		message=messageDao.selectMessage(messageId);
		return message;
	}
	
}
