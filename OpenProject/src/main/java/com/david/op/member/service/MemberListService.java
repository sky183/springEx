package com.david.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.david.op.jdbc.ConnectionProvider;
import com.david.op.jdbc.JdbcUtil;
import com.david.op.member.dao.MemDAO;
import com.david.op.member.model.Memberinfo;

@Component
public class MemberListService {
	
	public List<Memberinfo> memberListView(ModelAndView modelAndView, MemDAO memDao) throws SQLException{
		List<Memberinfo> members=null;
		Connection conn=null;;
		try {
			conn = ConnectionProvider.getConnection();
			members = memDao.selectAllUsers(conn);
		} finally {
			JdbcUtil.close(conn);
		}
		return members;
	}
	
}