package com.example.statisticsapi.config;

import com.example.statisticsapi.document.Role;
import com.example.statisticsapi.repository.RoleRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class DatabaseChangelog {
    @ChangeSet(order = "001", id = "seedDatabase", author = "Vadym Hurnik")
    public void seedDatabase(RoleRepository roleRepository) {
        List<Role> roleList = new ArrayList<>();

        Role user = new Role();
        user.setRoleName(Role.RoleName.USER);
        roleList.add(user);

        Role admin = new Role();
        admin.setRoleName(Role.RoleName.ADMIN);
        roleList.add(admin);

        roleRepository.insert(roleList);
    }
}
