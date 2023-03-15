package com.example.jdbcproject.dbConcept04.DTO;

public interface IMemberDTO {
	public void setEmail(String email);
	public void setPassword(String password);
	public void setName(String name);
	public void setRegisterDate(String registerDate);

	public String getEmail();
	public String getPassword();
	public String getName();
	public String getRegisterDate();
}
