package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartServiceDTO;
import com.bridgelabz.bookstore.entity.BookData;
import com.bridgelabz.bookstore.entity.Cart;
import com.bridgelabz.bookstore.entity.Users;
import com.bridgelabz.bookstore.repository.CartRepository;
import com.bridgelabz.bookstore.util.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {

    @Autowired
    CartRepository cartRepo;

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    JwtGenerator myToken;

    @Override
    public Cart addCart(CartServiceDTO carServiceDTO) {
        Long userId = myToken.parseJWT(carServiceDTO.userId);
        Optional<Users> user = userService.getUserById(userId);
        if(user.isPresent()) {
            BookData book = bookService.getBookById(carServiceDTO.bookId);
            Cart cart = new Cart(user.get(), book, carServiceDTO.quantity);
            return cartRepo.save(cart);

        }
        return null;
    }

    @Override
    public void removeFromCart(Long cart_id) {
        System.out.println("deleted");
        cartRepo.deleteById(cart_id);
    }

    @Override
    public void removeAllCarts(String token) {
        Long userId = myToken.parseJWT(token);
        Optional<Users> user = userService.getUserById(userId);
        if(user.isPresent()) {
            List<Cart> carts = cartRepo.findAllCartsByUserId(userId);
            cartRepo.deleteAll(carts);
        }
    }

    @Override
    public void updateQuantity(String token, Long cart_id, Long quantity) {
        Long id = myToken.parseJWT(token);
        Optional<Users> user = userService.getUserById(id);
        if(user.isPresent()) {
            Cart cart = cartRepo.getById(cart_id);
            cart.setQuantity(quantity);
            cartRepo.save(cart);
        }
    }

    @Override
    public List<Cart> findAllCarts(String token) {
        Long user_id = myToken.parseJWT(token);
        Optional<Users> user = userService.getUserById(user_id);
        if(user.isPresent()) {
            List<Cart> carts = cartRepo.findAllCartsByUserId(user_id);
            return carts;
        }
        return null;
    }
}
