package com.david.op.member.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.op.member.dao.JdbcTemplateMemberDao;
import com.david.op.member.model.Memberinfo;

@Component
public class MemberValidCheckService {
	
	@Autowired
	JdbcTemplateMemberDao jdbcTemplateMemberDao;
	
	public String idValidCheck(String userId) throws SQLException {
		String msg="사용 가능한 아이디입니다.";
		try {
			Memberinfo memberinfo = jdbcTemplateMemberDao.selectUser(userId);
			if(userId=="") {
				msg = "아이디는 필수 입력값입니다.";
			}
			if(memberinfo!=null && memberinfo.getUSERID()!=null) {
				System.out.println(memberinfo.getUSERID());
				msg = "이미 존재하는 아이디입니다.";
			}
		} catch (SQLException e) {
			throw e;
		}
		return msg;
	}
	
}
