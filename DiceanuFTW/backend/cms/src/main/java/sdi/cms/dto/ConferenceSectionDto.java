package sdi.cms.dto;

import lombok.Builder;
import lombok.Data;
import sdi.cms.model.participant.User;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@Builder
public class ConferenceSectionDto {

    @Id
    @GeneratedValue
    private Integer id;

    private int noOfParticipants;

    private int roomNumber;

    private String sectionName;

    private User supervisor;

    private List<User> speakers;
}
