package org.launchcode.givewise.models.data;

import org.launchcode.givewise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmailIgnoreCase(String email);
}
