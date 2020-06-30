package com.example.demo.business.entity.user;

import com.example.demo.business.commons.EntityRepository;

public interface ApplicationUserRepository extends EntityRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
