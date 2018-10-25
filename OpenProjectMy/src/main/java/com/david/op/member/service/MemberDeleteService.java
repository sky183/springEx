package com.david.op.member.service;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.david.op.member.dao.MemberDaoInterface;

@Service
public class MemberDeleteService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private MemberDaoInterface memberDaoInterface;

	@Transactional
	public int memberDelete(String delId) throws SQLException {
			int dcnt = 0;
			memberDaoInterface=sqlSessionTemplate.getMapper(MemberDaoInterface.class);
			dcnt=memberDaoInterface.deleteMember(delId);
			return dcnt;
	}

}
