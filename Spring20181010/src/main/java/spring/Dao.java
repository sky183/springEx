package spring;

public interface Dao {
	public Member selectByEmail(String email);

	public void insert(Member newMember);
}
