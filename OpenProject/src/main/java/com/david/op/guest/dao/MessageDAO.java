package com.david.op.guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.david.op.jdbc.JdbcUtil;
import com.david.op.guest.model.Message;


@Component
public class MessageDAO {
	
	private MessageDAO() {
	}
	
	public int insert(Connection conn, Message message) throws SQLException {
		PreparedStatement pstmt= null;
		try {
			pstmt = conn.prepareStatement("insert into GUEST_MSG(message_id,USERID,USERNAME,message)"+ 
					"values(ms_seq.NEXTVAL,?,?,?)");
			pstmt.setString(1,message.getUSERID());
			pstmt.setString(2,message.getUSERNAME());
			pstmt.setString(3,message.getMessage());
			return pstmt.executeUpdate();
		}
		finally{
			JdbcUtil.close(pstmt);
		}
		
	}
	
	public void delete(Connection conn, int messageId) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("delete from GUEST_MSG where message_id = ?");
			pstmt.setInt(1, messageId);
			pstmt.executeUpdate();
		} finally {		
			JdbcUtil.close(pstmt);
		}

	}

	
	public Message select(Connection conn, int messageId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			pstmt = conn.prepareStatement("select * from GUEST_MSG where message_id=?");
			pstmt.setInt(1,messageId);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				return makeMessageFromResultSet(rs);
			}else {
				return null;
			}
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
	}
	
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select count(*) from GUEST_MSG";
			stmt = conn.createStatement();
			rs= stmt.executeQuery(sql);
			rs.next();
			return rs.getInt(1);
			
		}finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}
	}
	
	public List<Message> selectList(Connection conn, int firstRow, int endRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Message> messageList = new ArrayList<Message>();
		try {
			pstmt = conn.prepareStatement("select message_id, USERID, USERNAME, message from ( "
					+ " select rownum rnum, message_id, USERID, USERNAME, message from ( "
					+ " select * from GUEST_MSG m order by m.message_id desc " + " ) where rownum <= ? "
					+ ") where rnum >= ?");
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, firstRow);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					messageList.add(makeMessageFromResultSet(rs));
				} while (rs.next());
				// return messageList;
			} else {
				// return Collections.emptyList();
				messageList = Collections.emptyList();
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return messageList;
	}
	
	private Message makeMessageFromResultSet(ResultSet rs) throws SQLException {
		Message message = new Message();
		message.setId(rs.getInt("message_id"));
		message.setUSERID(rs.getString("USERID"));
		message.setUSERNAME(rs.getString("USERNAME"));
		message.setMessage(rs.getString("message"));
		return message;
	}
	
}
