package com.example.statisticsapi.repository;

import com.example.statisticsapi.document.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRoleName(Role.RoleName roleName);
}
