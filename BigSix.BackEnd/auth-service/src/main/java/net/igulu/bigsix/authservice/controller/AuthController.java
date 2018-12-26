package net.igulu.bigsix.authservice.controller;

import com.google.gson.Gson;
import net.igulu.bigsix.authservice.model.User;
import net.igulu.bigsix.authservice.serializer.AuthSerializer;
import net.igulu.bigsix.authservice.serializer.SignInResponseSerializer;
import net.igulu.bigsix.authservice.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController()
public class AuthController {

    private final AuthService service;

    AuthController(AuthService service) {
        this.service = service;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public SignInResponseSerializer signIn(HttpSession session,
                                           @RequestBody String body) {
        Gson g = new Gson();
        AuthSerializer requestSerializer = g.fromJson(body, AuthSerializer.class);
        SignInResponseSerializer serializer = service.signIn(requestSerializer.getUsername(), requestSerializer.getPassword());
        if (serializer.isOk()) {
            User user = service.findByUsername(requestSerializer.getUsername());
            session.setAttribute("user_id", user.getId());
        }
        return serializer;
    }

    @RequestMapping(value = "/print", method = RequestMethod.GET)
    public ResponseEntity print(HttpSession session) {
        System.out.println(session.getAttribute("user_id"));
        return new ResponseEntity(session.getAttribute("user_id"), HttpStatus.OK);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User signUp(@RequestBody String body) {
        Gson g = new Gson();
        AuthSerializer requestSerializer = g.fromJson(body, AuthSerializer.class);
        User user = new User(requestSerializer.getUsername(), requestSerializer.getPassword());
        service.save(user);
        return user;
    }

}
