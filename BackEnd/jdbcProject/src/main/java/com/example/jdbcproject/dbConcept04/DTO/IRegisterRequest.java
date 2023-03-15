package com.example.jdbcproject.dbConcept04.DTO;

public interface IRegisterRequest {
	public String getEmail();
	public String getName() ;
	public String getPassword();
	public String getConfirmPassword();
	
	public void setPassword(String password);
	public void setEmail(String email);
	public void setName(String name);
	public void setConfirmPassword(String confirmPassword);
}
