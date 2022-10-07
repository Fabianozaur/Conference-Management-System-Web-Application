package sdi.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdi.cms.converter.AbstractFileConverter;
import sdi.cms.dto.AbstractFileDto;
import sdi.cms.model.paper.AbstractFile;
import sdi.cms.repository.AbstractFileRepository;

import java.util.List;

@Service
public class AbstractFileService {

    @Autowired
    private AbstractFileRepository abstractFileRepository;

    @Autowired
    private AbstractFileConverter converter;

    public List<AbstractFile> getAll() {
        return abstractFileRepository.findAll();
    }

    public List<AbstractFileDto> getAllDtos() {
        return converter.modelsToDtos(getAll());
    }

    public AbstractFile addAbstractFile(AbstractFile abstractFile) {
        return abstractFileRepository.save(abstractFile);
    }

    public AbstractFileDto addAbstractFileDto(AbstractFileDto abstractFile) {
        return converter.ModelToDto(addAbstractFile(converter.DtoToModel(abstractFile)));
    }
}
