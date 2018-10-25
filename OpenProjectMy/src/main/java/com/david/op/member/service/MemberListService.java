package com.david.op.member.service;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.david.op.member.dao.MemberDaoInterface;
import com.david.op.member.model.Memberinfo;

@Service
public class MemberListService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private MemberDaoInterface memberDao;
	
	@Transactional
	public List<Memberinfo> memberListView() throws SQLException{
		memberDao=sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		List<Memberinfo> members=null;
		members = memberDao.selectAllMembers();
		return members;
	}
	
}
