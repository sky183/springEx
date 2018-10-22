package com.david.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.op.jdbc.ConnectionProvider;
import com.david.op.jdbc.JdbcUtil;
import com.david.op.member.dao.MemDAO;
import com.david.op.member.model.Memberinfo;

@Component
public class MemberValidCheckService {
	
	@Autowired
	MemDAO memDAO;
	
	public String idValidCheck(String userId) throws SQLException {
		String msg="사용 가능한 아이디입니다.";
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			Memberinfo memberinfo = memDAO.selectUser(conn, userId);
			if(userId=="") {
				msg = "아이디는 필수 입력값입니다.";
			}
			if(memberinfo!=null && memberinfo.getUSERID()!=null) {
				System.out.println(memberinfo.getUSERID());
				msg = "이미 존재하는 아이디입니다.";
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
		return msg;
	}
	
}
