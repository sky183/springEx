package com.david.op.guest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.david.op.guest.model.Message;


@Component
public class MessageDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private MessageDAO() {
	}
	
	public int insert(Message message) throws SQLException {
		String sql ="insert into GUEST_MSG(message_id,USERID,USERNAME,message)"+ 
					"values(ms_seq.NEXTVAL,?,?,?)";
			int icnt = jdbcTemplate.update(sql,
					message.getUSERID(),message.getUSERNAME(),message.getMessage());
			System.out.println("메세지를 추가하였습니다. "+icnt+"줄");
			return icnt;
	}
	
	public int delete(int messageId) throws SQLException {
		String sql="delete from GUEST_MSG where message_id = ?";
		int dcnt = jdbcTemplate.update(sql,messageId);
		System.out.println("메세지를 삭제하였습니다 "+dcnt+"줄");
		return dcnt;
	}

	
	public Message select(int messageId) throws SQLException {
		String sql = "select * from GUEST_MSG where message_id=?";
		List<Message> result = jdbcTemplate.query(sql, new RowMapper<Message>() {
			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				Message message = new Message();
				message.setId(rs.getInt("message_id"));
				message.setUSERID(rs.getString("USERID"));
				message.setUSERNAME(rs.getString("USERNAME"));
				message.setMessage(rs.getString("message"));
				return message;
			}
		},messageId);
		System.out.println("메세지를 선택하였습니다.");
		return result.isEmpty() ? null : result.get(0) ;
	}
	
	public int selectCount() throws SQLException {
			String sql = "select count(*) from GUEST_MSG";
			Integer cnt = jdbcTemplate.queryForObject(sql, Integer.class);
			return cnt;
	}
	
	public List<Message> selectList(int firstRow, int endRow) throws SQLException {
		String sql = "select message_id, USERID, USERNAME, message from ( "
				+ " select rownum rnum, message_id, USERID, USERNAME, message from ( "
				+ " select * from GUEST_MSG m order by m.message_id desc " + " ) where rownum <= ? "
				+ ") where rnum >= ?";
		List<Message> messageList = jdbcTemplate.query(sql, new RowMapper<Message>() {
			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				Message message = new Message();
				message.setId(rs.getInt("message_id"));
				message.setUSERID(rs.getString("USERID"));
				message.setUSERNAME(rs.getString("USERNAME"));
				message.setMessage(rs.getString("message"));
				return message;
			}
		},endRow,firstRow);
		return messageList;
	}
}
