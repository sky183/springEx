package com.david.op.member.service;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.op.member.dao.MemberDaoInterface;
import com.david.op.member.model.Memberinfo;

@Service
public class MemberValidCheckService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private MemberDaoInterface memberDao;
	
	public String idValidCheck(String userId) throws SQLException {
		memberDao=sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		String msg="사용 가능한 아이디입니다.";
		Memberinfo memberinfo = memberDao.selectMember(userId);
		if(userId=="") {
			msg = "아이디는 필수 입력값입니다.";
		}
		if(memberinfo!=null && memberinfo.getUSERID()!=null) {
			System.out.println(memberinfo.getUSERID());
			msg = "이미 존재하는 아이디입니다.";
		}
		return msg;
	}
	
}
