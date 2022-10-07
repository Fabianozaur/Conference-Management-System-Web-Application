package sdi.cms.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sdi.cms.dto.ConferenceDto;
import sdi.cms.model.conference.Conference;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConferenceConverter {
    @Autowired
    private SectionConverter sectionConverter;

    public Conference convertDtoToModel(ConferenceDto dto) {
        return Conference.builder()
            .ID(dto.getID())
            .Name(dto.getName())
            .StartDate(dto.getStartDate())
            .EndDate(dto.getEndDate())
            .DeadlineAbstract(dto.getDeadlineAbstract())
            .DeadlineProposal(dto.getDeadlineProposal())
            .build();
    }

    public ConferenceDto convertModelToDto(Conference conference) {
        return ConferenceDto.builder()
            .ID(conference.getID())
            .Name(conference.getName())
            .StartDate(conference.getStartDate())
            .EndDate(conference.getEndDate())
            .DeadlineAbstract(conference.getDeadlineAbstract())
            .DeadlineProposal(conference.getDeadlineProposal())
            .build();
    }

    public List<Conference> convertDtosToModels(List<ConferenceDto> dtos) {
        return dtos
            .stream()
            .map(this::convertDtoToModel)
            .collect(Collectors.toList());
    }

    public List<ConferenceDto> convertModelsToDtos(List<Conference> conferences) {
        return conferences
            .stream()
            .map(this::convertModelToDto)
            .collect(Collectors.toList());
    }
}
