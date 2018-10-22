package com.david.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.op.jdbc.ConnectionProvider;
import com.david.op.jdbc.JdbcUtil;
import com.david.op.member.dao.MemDAO;

@Component
public class MemberDeleteService {

	@Autowired
	MemDAO memDAO;

	public void memberDelete(String dkey) throws SQLException {
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			memDAO.deleteUser(conn, dkey);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			if (conn != null) {
				JdbcUtil.close(conn);
			}
		}

	}

}
