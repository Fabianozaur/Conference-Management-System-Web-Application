package sdi.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sdi.cms.converter.ConferenceConverter;
import sdi.cms.dto.ConferenceDto;
import sdi.cms.service.ConferenceService;

import java.util.List;

@RestController
public class ConferenceController {
    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private ConferenceConverter conferenceConverter;

    @RequestMapping(value = "/conferences", method = RequestMethod.GET)
    public List<ConferenceDto> getAllConferences() {
        return conferenceConverter.convertModelsToDtos(conferenceService.getAllConferences());
    }

    @RequestMapping(value = "/conferences", method = RequestMethod.POST)
    public ConferenceDto addConference(@RequestBody final ConferenceDto conference) {
        return conferenceConverter.convertModelToDto(conferenceService.addConference(conferenceConverter.convertDtoToModel(conference)));
    }

    @RequestMapping(value = "/conferences", method = RequestMethod.PUT)
    public ConferenceDto updateConference(@RequestBody final ConferenceDto conference) {
        return conferenceConverter.convertModelToDto(conferenceService.updateConference(conferenceConverter.convertDtoToModel(conference)));
    }
}
