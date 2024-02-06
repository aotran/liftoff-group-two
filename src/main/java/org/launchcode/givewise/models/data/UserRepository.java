package org.launchcode.givewise.models.data;

import org.launchcode.givewise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmailIgnoreCase(String email);
}
