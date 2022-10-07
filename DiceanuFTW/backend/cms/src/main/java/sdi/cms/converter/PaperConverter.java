package sdi.cms.converter;

import org.springframework.stereotype.Component;
import sdi.cms.dto.PaperDto;
import sdi.cms.model.paper.Paper;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaperConverter {
    private final AbstractFileConverter abstractFileConverter = new AbstractFileConverter();

    public Paper DtoToModel(PaperDto dto) {
        Paper paper = new Paper();
        paper.setId(dto.getId());
        paper.setTitle(dto.getTitle());
        paper.setPaperFile(dto.getPaperFile());
        paper.setAbstractFile(abstractFileConverter.DtoToModel(dto.getAbstractFile()));
        return paper;
    }

    public PaperDto ModelToDto(Paper paper) {
        return PaperDto.builder().id(paper.getId()).title(paper.getTitle()).paperFile(paper.getPaperFile()).abstractFile(abstractFileConverter.ModelToDto(paper.getAbstractFile())).build();

    }

    public List<PaperDto> modelsToDtos(List<Paper> models) {
        return models.stream()
                .map(this::ModelToDto)
                .collect(Collectors.toList());
    }

    public List<Paper> dtosToModels(List<PaperDto> dtos) {
        return dtos.stream()
                .map(this::DtoToModel)
                .collect(Collectors.toList());
    }
}
