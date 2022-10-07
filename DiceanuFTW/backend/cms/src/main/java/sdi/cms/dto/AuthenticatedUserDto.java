package sdi.cms.dto;

import lombok.Builder;
import lombok.Data;
import sdi.cms.model.participant.Role;

@Data
@Builder
public class AuthenticatedUserDto {

    private String email;

    private Role role;

}