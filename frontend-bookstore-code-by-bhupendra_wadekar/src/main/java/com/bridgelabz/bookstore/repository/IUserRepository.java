/**
 * 
 */
package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.entity.Users;
import com.bridgelabz.bookstore.request.PasswordUpdate;

import java.util.List;

/**
 * @author HP
 *
 */
public interface IUserRepository {
	Users save(Users users);

	Users getUser(String email);

	boolean verify(Long id);

	boolean upDate(PasswordUpdate information, Long token);

	Users getUserById(Long id );

	List<Users> getUsers();

}
