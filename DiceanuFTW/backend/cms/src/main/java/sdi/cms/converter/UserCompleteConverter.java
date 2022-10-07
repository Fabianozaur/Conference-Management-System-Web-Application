package sdi.cms.converter;

import org.springframework.stereotype.Component;
import sdi.cms.dto.UserCompleteDto;
import sdi.cms.model.participant.User;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class UserCompleteConverter {

    public User convertDtoToModel(UserCompleteDto dto) {
        return User.builder()
            .id(dto.getId())
            .role(dto.getRole())
            .name(dto.getName())
            .affiliation(dto.getAffiliation())
            .email(dto.getEmail())
            .webPage(dto.getWebPage())
            .build();
    }

    public UserCompleteDto convertModelToDto(User user) {
        return UserCompleteDto.builder()
            .id(user.getId())
            .role(user.getRole())
            .name(user.getName())
            .affiliation(user.getAffiliation())
            .email(user.getEmail())
            .webPage(user.getWebPage())
            .build();
    }

    public List<User> convertDtosToModels(List<UserCompleteDto> dtos) {
        return dtos
            .stream()
            .map(this::convertDtoToModel)
            .collect(Collectors.toList());
    }

    public List<UserCompleteDto> convertModelsToDtos(List<User> users) {
        return users
            .stream()
            .map(this::convertModelToDto)
            .collect(Collectors.toList());
    }
}
