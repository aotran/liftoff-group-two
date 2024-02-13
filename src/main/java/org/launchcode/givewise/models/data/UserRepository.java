package org.launchcode.givewise.models.data;

import org.launchcode.givewise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmailIgnoreCase(String email);


    Optional<User> getUserByuserName(String username);
    @Query("SELECT u FROM User u WHERE u.email = :email")
    public User findByEmail(String email);

}
