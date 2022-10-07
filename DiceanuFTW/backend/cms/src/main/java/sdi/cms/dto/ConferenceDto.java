package sdi.cms.dto;

import lombok.Builder;
import lombok.Data;
import sdi.cms.model.paper.Proposal;
import sdi.cms.model.participant.User;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ConferenceDto {

    @Id
    @GeneratedValue
    protected Integer ID;

    private String Name;

    private LocalDate StartDate;

    private LocalDate EndDate;

    private LocalDate DeadlineAbstract;

    private LocalDate DeadlineProposal;

    private List<User> pcCommittee;

    private List<ConferenceSectionDto> sections;

    private List<Proposal> proposals;
}
