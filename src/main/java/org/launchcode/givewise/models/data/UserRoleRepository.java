package org.launchcode.givewise.models.data;

import org.launchcode.givewise.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
