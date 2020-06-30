package com.example.demo.business.application.user;

import com.example.demo.business.entity.user.ApplicationUser;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface ApplicationUserMapper {
    UserDto applicationUserToUserDto(ApplicationUser applicationUser);
}
