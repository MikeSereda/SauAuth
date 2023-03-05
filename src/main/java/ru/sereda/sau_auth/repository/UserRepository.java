package ru.sereda.sau_auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sereda.sau_auth.security.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByLogin(String login);
}
