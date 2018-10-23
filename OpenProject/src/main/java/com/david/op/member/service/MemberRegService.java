package com.david.op.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.david.op.member.dao.JdbcTemplateMemberDao;
import com.david.op.member.model.Memberinfo;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

@Component
@Qualifier("memReg")
public class MemberRegService {

	@Autowired
	private JdbcTemplateMemberDao jdbcTemplateMemberDao;
	
	@Transactional
	public void memberRegDo(HttpServletRequest request, Memberinfo memberinfo) throws Exception {
		String newFileName = "";
		String dir = "";
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
				jdbcTemplateMemberDao.updateUser(memberinfo);
			} else {
				jdbcTemplateMemberDao.insertUser(memberinfo);
			}
		} catch (IOException e) {
			throw e;
		} catch (SQLException e) {
			new File(dir, newFileName).delete();
			throw e;
		}
	}
}
