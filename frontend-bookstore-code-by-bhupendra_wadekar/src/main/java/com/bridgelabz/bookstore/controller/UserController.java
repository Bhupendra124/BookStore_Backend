package com.bridgelabz.bookstore.controller;


import com.bridgelabz.bookstore.dto.UserDto;
import com.bridgelabz.bookstore.entity.Users;
import com.bridgelabz.bookstore.exception.UserException;
import com.bridgelabz.bookstore.request.LoginInformation;
import com.bridgelabz.bookstore.response.Response;
import com.bridgelabz.bookstore.response.UsersDetailRes;
import com.bridgelabz.bookstore.service.UserService;
import com.bridgelabz.bookstore.util.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController()
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtGenerator generate;

    @PostMapping("/registration")
    @ResponseBody
    public ResponseEntity<Response> registration(@RequestBody UserDto information) {
        System.out.println("user info" + information.toString());
        boolean result = service.register(information);
        if (result) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new Response("registration successfull", 200, information));
        } else {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
                    .body(new Response("User Already Exist", 400, information));
        }
    }

    @PostMapping("/user/login")
    public ResponseEntity<UsersDetailRes> login(@RequestBody LoginInformation information) {

        Users users = service.login(information);
        if (users != null) {
            String token = generate.jwtToken(users.getUserId());
            return ResponseEntity.status(HttpStatus.ACCEPTED).header("Successfully login", information.getEmail())
                    .body(new UsersDetailRes(token, 200, users));
        } else {
            throw new UserException(" Invalide credentials");
        }
    }

    /**
     * This is for the user verify.......
     * @param token
     * @return response as success and fail
     * @throws Exception
     */
    @GetMapping("/user/verify/{token}")
    public ResponseEntity<Response> userVerification(@PathVariable("token") String token) throws Exception {
        System.out.println("token for verification" + token);
        boolean update = service.verify(token);
        if (update)
        {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("verified", 200));
        }
        else
        {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("not verified", 400));
        }
    }


    @GetMapping("user/getOneUser")
    public ResponseEntity<Response> getOneUsers(@RequestHeader("token") String token){
        Users user=service.getSingleUser(token);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new Response("user is", 200, user));
    }
}
