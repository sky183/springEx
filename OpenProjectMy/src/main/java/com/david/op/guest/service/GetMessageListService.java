package com.david.op.guest.service;

import java.util.Collections;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.david.op.guest.dao.MessageDaoInterface;
import com.david.op.guest.model.Message;
import com.david.op.guest.model.MessageListView;

@Service
public class GetMessageListService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	MessageDaoInterface messageDao;
	
	private static final int MESSAGE_COUNT_PER_PAGE = 3;
	
	@Transactional
	public MessageListView getMessageList(int pageNumber) throws ServiceException {
		int currentPageNumber = pageNumber;
		messageDao=sqlSessionTemplate.getMapper(MessageDaoInterface.class);
		// 전체 메시지 구하기
		int messageTotalCount = messageDao.selectMessageCount();
		List<Message> messageList = null;
		int firstRow = 0;
		int endRow = 0;
		if (messageTotalCount > 0) {
			firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE;
			endRow = firstRow + MESSAGE_COUNT_PER_PAGE;
			messageList = messageDao.selectMessageList(firstRow,MESSAGE_COUNT_PER_PAGE);
		} else {
			currentPageNumber = 0;
			messageList = Collections.emptyList();
		}
		return new MessageListView(messageList, messageTotalCount, currentPageNumber, MESSAGE_COUNT_PER_PAGE,
				firstRow, endRow);
	}
}
