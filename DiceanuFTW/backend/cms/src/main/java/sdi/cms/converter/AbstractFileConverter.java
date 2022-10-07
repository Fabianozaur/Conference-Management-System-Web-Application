package sdi.cms.converter;

import org.springframework.stereotype.Component;
import sdi.cms.dto.AbstractFileDto;
import sdi.cms.dto.ReviewDto;
import sdi.cms.model.paper.AbstractFile;
import sdi.cms.model.paper.Review;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AbstractFileConverter {

    public AbstractFile DtoToModel(AbstractFileDto dto) {
        AbstractFile abstractFile = new AbstractFile();
        abstractFile.setId(dto.getId());
        abstractFile.setFile(dto.getFile());
        return abstractFile;
    }

    public AbstractFileDto ModelToDto(AbstractFile abstractFile) {
        return AbstractFileDto.builder().id(abstractFile.getId()).file(abstractFile.getFile()).build();

    }

    public List<AbstractFileDto> modelsToDtos(List<AbstractFile> models) {
        return models.stream()
                .map(this::ModelToDto)
                .collect(Collectors.toList());
    }

    public List<AbstractFile> dtosToModels(List<AbstractFileDto> dtos) {
        return dtos.stream()
                .map(this::DtoToModel)
                .collect(Collectors.toList());
    }

}
