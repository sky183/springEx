package com.david.op.guest.dao;

import java.util.List;

import com.david.op.guest.model.Message;

public interface MessageDaoInterface {
	
	public Message selectMessage(int messageId);
	public List<Message> selectMessageList(int firstRow,int pageCnt);
	public int selectMessageCount();
	public int insertMessage(Message message);
	public int deleteMessage(int messageId);
	
}
