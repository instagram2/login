package models.converters;

import lib.User;
import models.entities.UserEntity;

public class UserConverter {
    public static User toDto(UserEntity entity) {

        User dto = new User();
        dto.setUserId(entity.getId());
        dto.setCreated(entity.getCreated());
        dto.setUserName(entity.getUserName());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    public static UserEntity toEntity(User dto) {
        UserEntity entity = new UserEntity();
        entity.setCreated(dto.getCreated());
        entity.setId(dto.getUserId());
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());

        return entity;
    }
}
