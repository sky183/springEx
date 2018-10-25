package com.david.op.member.dao;

import java.util.List;

import com.david.op.member.model.Memberinfo;

public interface MemberDaoInterface {
	
	public Memberinfo selectMember(String userid);
	public List<Memberinfo> selectAllMembers();
	public int insertMember(Memberinfo memberinfo);
	public int updateMember(Memberinfo memberinfo);
	public int deleteMember(String userid);
	
}
