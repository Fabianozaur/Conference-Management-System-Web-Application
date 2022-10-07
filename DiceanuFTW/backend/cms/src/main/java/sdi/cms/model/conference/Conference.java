package sdi.cms.model.conference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sdi.cms.model.paper.Proposal;
import sdi.cms.model.participant.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Conference {

    @Id
    @GeneratedValue
    protected Integer ID;

    private String Name;

    private LocalDate StartDate;

    private LocalDate EndDate;

    private LocalDate DeadlineAbstract;

    private LocalDate DeadlineProposal;

    @OneToMany
    private List<User> ProgramCommittee;

//    @OneToMany
//    private List<User> steeringCommittee;

    @OneToMany
    private List<Section> sections;

    @OneToMany
    private List<Proposal> proposals;

//    @OneToMany
//    private List<Proposal> acceptedProposals;

}
