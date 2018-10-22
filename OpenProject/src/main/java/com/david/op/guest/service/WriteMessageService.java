package com.david.op.guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.op.guest.dao.MessageDAO;
import com.david.op.jdbc.ConnectionProvider;
import com.david.op.jdbc.JdbcUtil;
import com.david.op.guest.model.Message;

@Component
public class WriteMessageService {
	@Autowired
	private MessageDAO messageDAO;
	
	public void write(Message msg) throws ServiceException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			messageDAO.insert(msg);
			conn.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new ServiceException("메세지 등록 실패: " + e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
}
