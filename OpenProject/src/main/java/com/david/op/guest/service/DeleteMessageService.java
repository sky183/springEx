package com.david.op.guest.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.david.op.guest.dao.MessageDAO;
import com.david.op.member.model.Logininfo;
import com.david.op.guest.model.Message;

@Component
public class DeleteMessageService {
	@Autowired
	private MessageDAO messageDAO;
	
	@Transactional
	public void deleteMessage(int messageId,HttpSession session)
			throws ServiceException, MessageNotFoundException, MessageInvalidOwnerException {
		try {
			Logininfo loginfo = (Logininfo)session.getAttribute("loginfo");
			Message message = messageDAO.select(messageId);
			if (message == null) {
				throw new MessageNotFoundException("메시지가 없습니다:" + messageId);
			} else if (!loginfo.getUSERID().equals(message.getUSERID())) {
				throw new MessageInvalidOwnerException("본인의 메세지만 삭제가 가능합니다.");
			}
			messageDAO.delete(messageId);
		} catch (SQLException ex) {
			throw new ServiceException("삭제 처리 중 에러가 발생했습니다:" + ex.getMessage(), ex);
		} catch (MessageNotFoundException ex) {
			throw ex;
		}

	}

}