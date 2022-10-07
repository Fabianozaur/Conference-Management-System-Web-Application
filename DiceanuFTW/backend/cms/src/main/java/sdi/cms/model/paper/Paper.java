package sdi.cms.model.paper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Paper {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;
    private String paperFile;

    @OneToOne
    private AbstractFile abstractFile;

}