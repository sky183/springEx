package com.david.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.op.jdbc.ConnectionProvider;
import com.david.op.jdbc.JdbcUtil;
import com.david.op.member.dao.JdbcTemplateMemberDao;
import com.david.op.member.model.Memberinfo;

@Component
public class MemberListService {
	
	@Autowired
	JdbcTemplateMemberDao jdbcTemplateMemberDao;
	
	public List<Memberinfo> memberListView() throws SQLException{
		List<Memberinfo> members=null;
		Connection conn=null;;
		try {
			conn = ConnectionProvider.getConnection();
			members = jdbcTemplateMemberDao.selectAllUsers();
		} finally {
			JdbcUtil.close(conn);
		}
		return members;
	}
	
}
