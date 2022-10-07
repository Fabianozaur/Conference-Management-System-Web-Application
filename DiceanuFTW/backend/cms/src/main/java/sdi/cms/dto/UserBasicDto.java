package sdi.cms.dto;


import lombok.Builder;
import lombok.Data;
import sdi.cms.model.participant.Role;

@Data
@Builder
public class UserBasicDto {
    private Long id;
    private String email;
    private String name;
    private Role role;
}
