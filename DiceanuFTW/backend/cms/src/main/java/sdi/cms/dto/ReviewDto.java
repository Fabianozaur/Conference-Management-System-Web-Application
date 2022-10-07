package sdi.cms.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewDto {

    private Integer id;

    private String grade;

}
