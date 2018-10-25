package com.david.op.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.david.op.member.dao.MemberDaoInterface;
import com.david.op.member.model.Memberinfo;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

@Service
@Qualifier("memReg")
public class MemberRegService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private MemberDaoInterface memberDao;
	
	@Transactional
	public int memberRegDo(HttpServletRequest request, Memberinfo memberinfo) 
			throws IOException, SQLException {
		memberDao=sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		String newFileName = "";
		String dir = "";
		int icnt = 0;
		try {
			if (!memberinfo.getPHOTOFILE().isEmpty()) {
				String fileName = memberinfo.getPHOTOFILE().getOriginalFilename();
				newFileName = System.currentTimeMillis() + "_" + fileName;
				String uploadUri = "/file";
				dir = request.getSession().getServletContext().getRealPath(uploadUri);
				String di = request.getContextPath() + "/file/" + newFileName;
				System.out.println(dir);
				memberinfo.getPHOTOFILE().transferTo(new File(dir, newFileName));
				memberinfo.setUSERFILE(di);
			}

			if (request.getParameter("mkey") != null) {
				icnt = memberDao.updateMember(memberinfo);
			} else {
				icnt = memberDao.insertMember(memberinfo);
			}
		} catch (IOException e) {
			throw e;
		}
		return icnt;
	}
}
