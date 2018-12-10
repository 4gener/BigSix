package net.igulu.bigsix.authservice.service;

import net.igulu.bigsix.authservice.model.User;
import net.igulu.bigsix.authservice.serializer.SignInResponseSerializer;

public interface AuthService {

    User save(User user);

    User findByUsername(String username);

    SignInResponseSerializer signIn(String username, String password);

}
