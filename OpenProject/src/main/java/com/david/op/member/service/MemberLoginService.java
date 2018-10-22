package com.david.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.op.jdbc.ConnectionProvider;
import com.david.op.jdbc.JdbcUtil;
import com.david.op.member.dao.JdbcTemplateMemberDao;
import com.david.op.member.model.Logininfo;
import com.david.op.member.model.Memberinfo;

@Component
public class MemberLoginService {
	
	@Autowired
	JdbcTemplateMemberDao jdbcTemplateMemberDao;
	
	public boolean login(String id,String pw, HttpSession session) throws SQLException{
		boolean result = false;
		Connection conn = null;
		Logininfo loginfo = new Logininfo();
		
		try {
			conn=ConnectionProvider.getConnection();
			Memberinfo memberinfo = jdbcTemplateMemberDao.selectUser(id);
			
			if(memberinfo!=null && pw.equals(memberinfo.getUSERPW())) {
				loginfo.setUSERID(memberinfo.getUSERID());
				loginfo.setUSERNAME(memberinfo.getUSERNAME());
				loginfo.setUSERFILE(memberinfo.getUSERFILE());
				loginfo.setREGDATE(memberinfo.getREGDATE());
				session.setAttribute("loginfo", loginfo);
				result=true;
			} else {
				session.setAttribute("loginMsg", "아이디와 패스워드를 확인해 주세요.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
		
		return result;
	}
}
