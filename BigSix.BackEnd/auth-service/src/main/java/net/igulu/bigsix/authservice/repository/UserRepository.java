package net.igulu.bigsix.authservice.repository;

import net.igulu.bigsix.authservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findUserByUsername(String username);

    User findUserById(String id);


}
