package org.launchcode.givewise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;


@Getter
@Setter
@Table(name="users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "password")
    private String password;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserRole role;


    @PostPersist
    public void afterUserPersist() {
        // Create a new UserRole and associate it with the user
        UserRole role = new UserRole();
        role.setUser(this);
        role.setUserRole("USER");

        // Set the UserRole in the User entity
        this.setRole(role);
    }

}