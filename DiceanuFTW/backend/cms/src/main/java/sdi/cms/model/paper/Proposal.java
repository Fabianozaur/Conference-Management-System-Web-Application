package sdi.cms.model.paper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sdi.cms.model.participant.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Proposal {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String keywords;
    private String topics;

    @OneToOne
    private Paper paper;

    @OneToMany
    private List<User> authors;

    @OneToMany
    private List<Review> reviews;

}
