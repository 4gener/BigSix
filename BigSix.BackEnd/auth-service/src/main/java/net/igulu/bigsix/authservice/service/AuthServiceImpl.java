package net.igulu.bigsix.authservice.service;

import net.igulu.bigsix.authservice.repository.UserRepository;
import net.igulu.bigsix.authservice.model.User;
import net.igulu.bigsix.authservice.serializer.SignInResponseSerializer;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

@Service
public class AuthServiceImpl implements AuthService {
    @Resource
    private UserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findUserByUsername(username);
    }

    @Override
    public SignInResponseSerializer signIn(String username, String password) {
        SignInResponseSerializer serializer = new SignInResponseSerializer(false);
        User user = findByUsername(username);
        if (user != null){
            if (user.checkPassword(password)){
                serializer.setOk(true);
                serializer.setMessage("login success");
                serializer.setData(user);
            }else {
                serializer.setMessage("invalid password");
            }
        }else {
            serializer.setMessage("user not found");
        }
        return serializer;
    }

    @Override
    public User findById(String id) {
        return repository.findUserById(id);
    }
}
