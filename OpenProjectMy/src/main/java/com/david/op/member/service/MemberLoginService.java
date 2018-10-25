package com.david.op.member.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.op.member.dao.MemberDaoInterface;
import com.david.op.member.model.Logininfo;
import com.david.op.member.model.Memberinfo;

@Service
public class MemberLoginService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private MemberDaoInterface memberDao;
	
	public boolean login(String id,String pw, HttpSession session) throws SQLException{
		memberDao=sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		boolean result = false;
		Logininfo loginfo = new Logininfo();
		Memberinfo memberinfo = memberDao.selectMember(id);
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
		
		return result;
	}
}
