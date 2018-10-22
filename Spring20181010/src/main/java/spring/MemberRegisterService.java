package spring;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;



public class MemberRegisterService {
	
	//@Resource(name="guestDao")
	@Autowired
	@Qualifier("memsel")
	private Dao memberDao2;
	
	//@Autowired
	/*public MemberRegisterService(MemberDao memberDao) {
	this.memberDao = memberDao;
	}*/
	
	//프로퍼티 설정을 위한 세터메서드
/*	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}*/

	
	public void regist(RegisterRequest req) {
	Member member = memberDao2.selectByEmail(req.getEmail());
	if (member != null) {
	throw new AlreadyExistingMemberException("dup email "+
	req.getEmail());
	}
	Member newMember = new Member(
	req.getEmail(), req.getPassword(), req.getName(),
	new Date());
	memberDao2.insert(newMember);
	}


	
}
