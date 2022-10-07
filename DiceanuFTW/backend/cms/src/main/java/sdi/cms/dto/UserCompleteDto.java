package sdi.cms.dto;

import lombok.Builder;
import lombok.Data;
import sdi.cms.model.participant.Role;

@Builder
@Data
public class UserCompleteDto {
    protected Long id;
    private Role role;
    private String name;
    private String affiliation;
    private String email;
    private String webPage;
}
