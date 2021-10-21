package com.bridgelabz.bookstore.entity;

import lombok.Data;
import lombok.ToString;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@ToString
@Data
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String name;
    private String email;
    private String password;
    private Long mobileNumber;
    private LocalDateTime createdDate;
    private boolean isVerified;
    private String role;


}
