package org.itstep.helloobjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//Business logic
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public Optional<User> findById(long id){
        return userRepo.findById(id);
    }

    public void save(User user){
        userRepo.save(user);
    }

    public void deleteById(long id){
        userRepo.deleteById(id);
    }
}
