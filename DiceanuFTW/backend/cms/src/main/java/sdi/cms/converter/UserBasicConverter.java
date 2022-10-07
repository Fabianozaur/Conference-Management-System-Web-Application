package sdi.cms.converter;


import org.springframework.stereotype.Component;
import sdi.cms.dto.UserBasicDto;
import sdi.cms.model.participant.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserBasicConverter {
    public User convertDtoToModel(UserBasicDto dto) {
        return User.builder()
            .id(dto.getId())
            .email(dto.getEmail())
            .role(dto.getRole())
            .name(dto.getName())
            .build();
    }

    public UserBasicDto convertModelToDto(User user) {
        return UserBasicDto.builder()
            .id(user.getId())
            .email(user.getEmail())
            .role(user.getRole())
            .name(user.getName())
            .build();
    }

    public List<User> convertDtosToModels(List<UserBasicDto> dtos) {
        return dtos
            .stream()
            .map(this::convertDtoToModel)
            .collect(Collectors.toList());
    }

    public List<UserBasicDto> convertModelsToDtos(List<User> users) {
        return users
            .stream()
            .map(this::convertModelToDto)
            .collect(Collectors.toList());
    }
}
