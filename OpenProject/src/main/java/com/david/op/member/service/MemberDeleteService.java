package com.david.op.member.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.david.op.member.dao.JdbcTemplateMemberDao;

@Component
public class MemberDeleteService {
	
	@Autowired
	JdbcTemplateMemberDao jdbcTemplateMemberDao;

	@Transactional
	public void memberDelete(String dkey) throws SQLException {
		try {
			jdbcTemplateMemberDao.deleteUser(dkey);
		} catch (SQLException e) {
			throw e;
		}

	}

}
