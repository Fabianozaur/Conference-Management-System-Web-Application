package sdi.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sdi.cms.dto.AbstractFileDto;
import sdi.cms.converter.AbstractFileConverter;
import sdi.cms.service.AbstractFileService;

import java.util.List;

@RestController
public class AbstractFileController {

    @Autowired
    private AbstractFileService abstractFileService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<AbstractFileDto> abstractFileDtos = abstractFileService.getAllDtos();
        return new ResponseEntity<>(abstractFileDtos, HttpStatus.OK);
    }

    @PostMapping("/placeholder")
    public ResponseEntity<?> addAbstractFile(@RequestBody AbstractFileDto abstractFile) {
        AbstractFileDto abstractFileDto = abstractFileService.addAbstractFileDto(abstractFile);
        return new ResponseEntity<>(abstractFileDto, HttpStatus.CREATED);
    }
}
