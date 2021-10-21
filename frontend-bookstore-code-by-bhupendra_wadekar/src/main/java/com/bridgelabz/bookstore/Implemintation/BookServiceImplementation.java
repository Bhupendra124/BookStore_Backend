//package com.bridgelabz.bookstore.Implemintation;
//import com.bridgelabz.bookstore.dto.BookDto;
//import com.bridgelabz.bookstore.entity.Book;
//
//import com.bridgelabz.bookstore.entity.Users;
//
//
////import com.bridgelabz.bookstore.exception.BookAlreadyExist;
//import com.bridgelabz.bookstore.exception.BookAlreadyExist;
//import com.bridgelabz.bookstore.exception.UserException;
//import com.bridgelabz.bookstore.repository.BookImpl;
//
//import com.bridgelabz.bookstore.repository.IUserRepository;
//
//import com.bridgelabz.bookstore.response.EmailData;
//import com.bridgelabz.bookstore.service.IBookService;
//import com.bridgelabz.bookstore.util.EmailProviderService;
//import com.bridgelabz.bookstore.util.JwtGenerator;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//
//@Slf4j
//@Service
//public class BookServiceImplementation implements IBookService {
//	private Book bookinformation = new Book();
//	private ModelMapper modelMapper = new ModelMapper();
//
//	@Autowired
//	private EmailProviderService em;
//	@Autowired
//	private EmailData emailData;
//
//	@Autowired
//	private BookImpl repository;
//
//	@Autowired
//	private IUserRepository userRepository;
//
//
//	@Autowired
//	private JwtGenerator generate;
//
//
//
//
//	@Override
//	public List<Book> getBookInfo(String token) {
//		return null;
//	}
//
//
//	public boolean addBooks(String imageName,BookDto information,String token)
//	{
//		Long id;
//
//		id = (long) generate.parseJWT(token);
//		Users userInfo = userRepository.getUserById(id);
//		if(userInfo != null)
//		{
//			String userRole = userInfo.getRole();
//			System.out.println("actual Role is " + userRole);
//			String fetchRole = userRole;
//			if (fetchRole.equals("seller") )
//			{
//				Book book=repository.fetchbyBookName(information.getBookName());
//				System.out.println("Book name "+information.getBookName());
//				if(book ==null)
//				{
//					bookinformation = modelMapper.map(information, Book.class);
//					bookinformation.setBookName(information.getBookName());
//					bookinformation.setAuthorName(information.getAuthorName());
//					bookinformation.setPrice(information.getPrice());
//					bookinformation.setImage(imageName);
//					bookinformation.setStatus("OnHold");
//					bookinformation.setNoOfBooks(information.getNoOfBooks());
//					bookinformation.setCreatedDateAndTime(LocalDateTime.now());
//					bookinformation.setUserId(id);
//					repository.save(bookinformation);
//					return true;
//				}
//				else
//				{
//					throw new BookAlreadyExist("Book is already exist Exception..");
//
//				}
//			}
//			else
//			{
//				throw new UserException("Your are not Authorized User");
//			}
//
//		} else {
//			throw new UserException("User doesn't exist");
//		}
//	}
//}
