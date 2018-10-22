package com.david.op.guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.op.guest.dao.MessageDAO;
import com.david.op.guest.model.Message;
import com.david.op.jdbc.ConnectionProvider;
import com.david.op.jdbc.JdbcUtil;

@Component
public class ViewMessageService {

	@Autowired
	MessageDAO messageDAO;
	
	public Message getMessage(int messageId) throws SQLException {
		Connection conn=null;
		Message message=null;
		try {
			conn=ConnectionProvider.getConnection();
			message=messageDAO.select(messageId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
		return message;
	}
	
}
