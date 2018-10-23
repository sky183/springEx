package com.david.op.member.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.david.op.member.dao.JdbcTemplateMemberDao;
import com.david.op.member.model.Memberinfo;

@Component
public class MemberListService {
	
	@Autowired
	JdbcTemplateMemberDao jdbcTemplateMemberDao;
	
	@Transactional
	public List<Memberinfo> memberListView() throws SQLException{
		List<Memberinfo> members=null;
		try {
			members = jdbcTemplateMemberDao.selectAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
			new SQLException(e);
		}
		return members;
	}
	
}
