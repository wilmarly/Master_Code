package com.example.mastercode.services;

import com.example.mastercode.entities.User;
import com.example.mastercode.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private UserRepository userReposiory;

    public UserService(UserRepository userReposiory) {
        this.userReposiory = userReposiory;
    }
    public User createUser(User newUser) {
        return this.userReposiory.save(newUser);
    }

    public User findUserByEmail (String email){
        return this.userReposiory.findByEmail(email);
    }
    public User getOrCreateUser(Map<String,Object> userData){

        String email= (String) userData.get("email");

        User user = findUserByEmail(email);

        if(user==null) {
            String name = (String) userData.get("name");
            String image = (String) userData.get("picture");
            String auth0Id = (String) userData.get("sub");

            User newUser = new User(email = email, image = image, auth0Id = auth0Id);

            return createUser(newUser);
        }
        return user;
    }

}
