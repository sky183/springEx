package com.david.op.guest.service;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.david.op.guest.dao.MessageDaoInterface;
import com.david.op.member.model.Logininfo;
import com.david.op.guest.model.Message;

@Service
public class DeleteMessageService {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	MessageDaoInterface messageDao;
	
	@Transactional
	public int deleteMessage(int messageId,HttpSession session)
			throws ServiceException, MessageNotFoundException, MessageInvalidOwnerException {
			int dcnt=0;
			Logininfo loginfo = (Logininfo)session.getAttribute("loginfo");
			messageDao=sqlSessionTemplate.getMapper(MessageDaoInterface.class);
		try {
			Message message=messageDao.selectMessage(messageId);
			if (message == null) {
				throw new MessageNotFoundException("메시지가 없습니다:" + messageId);
			} else if (!loginfo.getUSERID().equals(message.getUSERID())) {
				throw new MessageInvalidOwnerException("본인의 메세지만 삭제가 가능합니다.");
			}
			dcnt=messageDao.deleteMessage(messageId);
		} catch (MessageNotFoundException ex) {
			throw ex;
		}
	return dcnt;
	}

}