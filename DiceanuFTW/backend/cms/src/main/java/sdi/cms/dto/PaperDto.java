package sdi.cms.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaperDto {

    private Integer id;

    private String title;

    private String paperFile;

    private AbstractFileDto abstractFile;

}
