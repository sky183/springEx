package com.david.op.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.david.op.member.model.Memberinfo;


public class MemberDaoEx {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String mapperPath="com.david.op.mapper.mybatis.MemberMapper";

	public List<Memberinfo> selectAllUsers() throws SQLException {
			String sql = "select * from MEMBER order by IDX desc"; // sql 쿼리
			List<Memberinfo> result = jdbcTemplate.query(sql, new RowMapper<Memberinfo>() {
				@Override
				public Memberinfo mapRow(ResultSet rs, int rowNum) throws SQLException {
					Memberinfo memberinfo = new Memberinfo();
					memberinfo.setUSERID(rs.getString("USERID"));
					memberinfo.setUSERPW(rs.getString("USERPW"));
					memberinfo.setUSERNAME(rs.getString("USERNAME"));
					memberinfo.setUSERFILE(rs.getString("USERFILE"));
					memberinfo.setREGDATE(rs.getString("REGDATE"));
					return memberinfo;
				}
			}); // 임시리스트 생성
			System.out.println("레코드를 선택했습니다."); // 성공시 메시지 출력
			return result.isEmpty() ? null : result;
	}// end selectAllusers()

	public Memberinfo selectUser(String userId) throws SQLException {
		String sql = "select * from MEMBER where USERID=?"; // sql 쿼리
		List<Memberinfo> result = jdbcTemplate.query(sql, new RowMapper<Memberinfo>() {
			@Override
			public Memberinfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				Memberinfo memberinfo = new Memberinfo();
				memberinfo.setUSERID(rs.getString("USERID"));
				memberinfo.setUSERPW(rs.getString("USERPW"));
				memberinfo.setUSERNAME(rs.getString("USERNAME"));
				memberinfo.setUSERFILE(rs.getString("USERFILE"));
				memberinfo.setREGDATE(rs.getString("REGDATE"));
				return memberinfo;
			}
		},userId); // 임시리스트 생성
		System.out.println("레코드를 선택했습니다."+userId); // 성공시 메시지 출력
			return result.isEmpty() ? null : result.get(0);
	}// end selectUser()

	public int deleteUser(String userId) throws SQLException {
			int dcnt = 0;
			String sql = "delete from MEMBER where USERID=?"; // sql 쿼리
			dcnt = jdbcTemplate.update(sql,userId);
			System.out.println("레코드를 삭제했습니다." + dcnt + "줄"); // 성공시 메시지 출력
			return dcnt;
	}// end deleteUser

	public int updateUser(Memberinfo memberinfo) throws SQLException {
			int ucnt = 0;
			String sql = "update MEMBER set USERID=?,USERPW=?,USERNAME=?,USERFILE=? where USERID=?"; // sql쿼리
			ucnt = jdbcTemplate.update(sql,
					memberinfo.getUSERID(),
					memberinfo.getUSERPW(),
					memberinfo.getUSERNAME(),
					memberinfo.getUSERFILE(),
					memberinfo.getUSERID()
					);
			System.out.println("레코드를 변경했습니다." + ucnt + "줄"); // 성공시 메시지 출력
			return ucnt; // 성공한 쿼리수 리턴
	}// end updateUser

	public int insertUser(Memberinfo u) throws SQLException {
		int icnt = 0;
		icnt = sqlSessionTemplate.update(mapperPath+".insertMember",u);
		System.out.println("레코드를 추가했습니다." + icnt + "줄"); 
		return icnt;
	}

}