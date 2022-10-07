package sdi.cms.dto;

import lombok.Builder;
import lombok.Data;
import sdi.cms.model.participant.User;

import java.util.List;

@Data
@Builder
public class ProposalDto {

    private Integer id;

    private String name;

    private String keywords;

    private String topics;

    private PaperDto paper;

    private List<UserBasicDto> authors;

    private List<ReviewDto> reviews;

}
