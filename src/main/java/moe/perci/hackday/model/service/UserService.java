package moe.perci.hackday.model.service;

import moe.perci.hackday.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService extends JpaRepository<User, Long> {
    User findUserByUsernameAndStatus(String _username, int _status);
    User findUserById(int _id);
}
