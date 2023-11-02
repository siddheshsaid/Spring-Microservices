package com.user.controller;

import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired

    private RestTemplate restTemplate;
    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId")Long userId){
        User user= this.userService.getUser(userId);
        //url to fetch contact details:-http://CONTACT-SERVICE/contact/user/13111
      List contacts=this.restTemplate.getForObject("http://CONTACT-SERVICE/contact/user/"+user.getUserId(), List.class);//same user is we get after hitting same userId in url
        user.setContacts(contacts);

        return user;
//        Response deserialization: RestTemplate can automatically deserialize HTTP response data into Java objects, making it easy to work with the data received from the server.
//                Now, regarding your question about deserialization:
//
//        Deserialization is the process of converting data that has been serialized (i.e., converted into a specific format like JSON or XML) back into its original data
//        structure. In the context of consuming RESTful APIs, deserialization typically involves converting the JSON or XML data received in the HTTP response into Java objects
//        or data structures that you can work with in your Java code.


    }

}
