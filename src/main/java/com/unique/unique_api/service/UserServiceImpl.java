package com.unique.unique_api.service;


import com.unique.unique_api.controllers.dto.UserDTO;
import com.unique.unique_api.repositories.UserRepository;
import com.unique.unique_api.repositories.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){ this.userRepository = userRepository; }



    @Override
    public User save(UserDTO userDTO) {
        User user = new User(userDTO);
        return userRepository.save(user);
    }

    @Override
    public User update(UserDTO userDTO, Integer userId) {
        //        find the user to update
        User userFromDb = findById(userId);

        //        update the user information
        if(userDTO.getUsername() == null){
            userFromDb.setUsername(userFromDb.getUsername());
        } else if(userDTO.getUsername().isEmpty()) {
            userFromDb.setUsername(userFromDb.getUsername());
        } else {
            userFromDb.setUsername(userDTO.getUsername());
        }

//        userFromDb.setUsername(userDTO.getUsername() != null ? userDTO.getUsername() : userFromDb.getUsername());
        userFromDb.setEmail(userDTO.getEmail() != null ? userDTO.getEmail() : userFromDb.getEmail());
        userFromDb.setPassword(userDTO.getPassword() != null ? userDTO.getPassword() : userFromDb.getPassword());
        return userRepository.save(userFromDb);}

    @Override
    public void delete(Integer userId) {
        Optional<User> playerToDelete = userRepository.findById(userId);

        if(playerToDelete.isPresent()){
            userRepository.deleteById(userId);
            throw new ResponseStatusException(HttpStatus.OK, "The user has been successfully deleted.");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The user was not found.");
        }
    }


    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            return null;
        }
        return optionalUser.get();
    }

    //        @Override
//        public User findByName(String username){
//            return userRepository.findByName(username);
//        }
    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }


}