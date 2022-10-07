package sdi.cms.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AbstractFileDto {

    private Integer id;

    private String file;

}
