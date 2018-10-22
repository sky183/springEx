package com.david.op.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.david.op.jdbc.ConnectionProvider;
import com.david.op.jdbc.JdbcUtil;
import com.david.op.member.dao.JdbcTemplateMemberDao;
import com.david.op.member.model.Memberinfo;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

@Component
@Qualifier("memReg")
public class MemberRegService {

	@Autowired
	private JdbcTemplateMemberDao jdbcTemplateMemberDao;

	public void memberRegDo(HttpServletRequest request, Memberinfo memberinfo) throws Exception {
		Connection conn = null;
		String newFileName = "";
		String dir = "";
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
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
			conn.commit();
		} catch (IOException e) {
			throw e;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			new File(dir, newFileName).delete();
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
