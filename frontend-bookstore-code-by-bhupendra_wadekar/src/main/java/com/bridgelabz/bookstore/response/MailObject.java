/**
 * 
 */
package com.bridgelabz.bookstore.response;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class MailObject implements Serializable {
	private static final long serialVersionUID = 1L;
	private String email;
	private String subject;
	private String message;
}