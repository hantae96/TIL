package com.example.jdbcproject.dbConcept04.DTO;

public class MemberDTO implements IMemberDTO{

    private String Email;
    private String name;
    private String password;
    private String registerDate;

    @Override
    public String getEmail() {
        return Email;
    }

    @Override
    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getRegisterDate() {
        return registerDate;
    }

    @Override
    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }
}
