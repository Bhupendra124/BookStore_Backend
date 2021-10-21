package com.bridgelabz.bookstore.request;


import lombok.Data;

@Data
public class LoginInformation {
    private String email;
    private String password;
//    private String role;
//    public UserRole Role;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
}
