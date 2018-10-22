package com.david.op.guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.op.guest.dao.MessageDAO;
import com.david.op.jdbc.ConnectionProvider;
import com.david.op.jdbc.JdbcUtil;
import com.david.op.member.model.Logininfo;
import com.david.op.guest.model.Message;

@Component
public class DeleteMessageService {
	@Autowired
	private MessageDAO messageDAO;

	public void deleteMessage(int messageId,HttpSession session)
			throws ServiceException, MessageNotFoundException, MessageInvalidOwnerException {

		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			Logininfo loginfo = (Logininfo)session.getAttribute("loginfo");
			Message message = messageDAO.select(conn, messageId);
			if (message == null) {
				throw new MessageNotFoundException("메시지가 없습니다:" + messageId);
			} else if (!loginfo.getUSERID().equals(message.getUSERID())) {
				throw new MessageInvalidOwnerException("본인의 메세지만 삭제가 가능합니다.");
			}
			messageDAO.delete(conn, messageId);
			conn.commit();
		} catch (SQLException ex) {
			JdbcUtil.rollback(conn);
			throw new ServiceException("삭제 처리 중 에러가 발생했습니다:" + ex.getMessage(), ex);
		} catch (MessageNotFoundException ex) {
			JdbcUtil.rollback(conn);
			throw ex;
		} finally {
			if (conn != null) {
				JdbcUtil.close(conn);
			}
		}

	}

}