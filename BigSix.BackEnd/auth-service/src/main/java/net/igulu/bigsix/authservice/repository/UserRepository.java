package net.igulu.bigsix.authservice.repository;

import net.igulu.bigsix.authservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);

//    public User findById(String id);

}
