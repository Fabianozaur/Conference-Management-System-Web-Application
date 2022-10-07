package sdi.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sdi.cms.converter.SectionConverter;
import sdi.cms.dto.ConferenceSectionDto;
import sdi.cms.service.ConferenceSectionService;

import java.util.List;

@RestController
public class ConferenceSectionController {
    @Autowired
    private ConferenceSectionService conferenceSectionService;

    @Autowired
    private SectionConverter sectionConverter;

    @RequestMapping(value = "/conferenceSections", method = RequestMethod.GET)
    public List<ConferenceSectionDto> getAllConferenceSections() {
        return sectionConverter.convertModelsToDtos(conferenceSectionService.getAllConferenceSections());
    }

    @RequestMapping(value = "/conferenceSections", method = RequestMethod.POST)
    public ConferenceSectionDto addConferenceSection(@RequestBody final ConferenceSectionDto section) {
        return sectionConverter.convertModelToDto(conferenceSectionService.addConferenceSection(sectionConverter.convertDtoToModel(section)));
    }

    @RequestMapping(value = "/conferenceSections", method = RequestMethod.PUT)
    public ConferenceSectionDto updateConferenceSection(@RequestBody final ConferenceSectionDto section) {
        return sectionConverter.convertModelToDto(conferenceSectionService.updateConferenceSection(sectionConverter.convertDtoToModel(section)));
    }
}
