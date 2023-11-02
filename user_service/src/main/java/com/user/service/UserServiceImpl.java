package com.user.service;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class UserServiceImpl implements UserService{
    //FAKE USER LIST

    List<User> list=List.of(
        new User(13111L,"Durgesh Tiwari","9869545844"),
         new User(13112L,"Ankit Tiwari","9869545856"),
            new User(13113L,"Anshika Pandey","9869543444")




    );
    @Override
    public User getUser(Long id) {

        return this.list.stream().filter(user->user.getUserId().equals(id)).findAny().orElse(null);
    }
}
