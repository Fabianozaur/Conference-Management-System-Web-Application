package sdi.cms.model.conference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sdi.cms.model.participant.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Section {

    @Id
    @GeneratedValue
    private Integer id;

    private int noOfParticipants;

    private int roomNumber;

    //private LocalDate startTime;

    //private LocalDate endTime;

    private String sectionName;

    @ManyToOne
    private User supervisor;

    @OneToMany
    private List<User> speakers;

//    @OneToMany
//    private List<User> listeners;

}
