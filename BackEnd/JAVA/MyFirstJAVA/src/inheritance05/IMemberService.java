package inheritance05;

public interface IMemberService {
	public void insert(String email, String name, String mobile);
	public void selectEmail(String email);
	public void selectAll();
	public void update(String email, String name, String mobile);
	public void delete(String email);
}
