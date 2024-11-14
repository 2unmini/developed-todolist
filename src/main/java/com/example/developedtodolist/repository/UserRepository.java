package com.example.developedtodolist.repository;

import com.example.developedtodolist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    default User findByIdOrElseThrow(Long id) {

        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    default User findUserByEmail(String email) {
        List<User> usersList = findAll();
        return usersList.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }

}
