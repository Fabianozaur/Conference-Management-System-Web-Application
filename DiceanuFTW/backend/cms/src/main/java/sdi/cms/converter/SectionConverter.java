package sdi.cms.converter;

import org.springframework.stereotype.Component;
import sdi.cms.dto.ConferenceSectionDto;
import sdi.cms.model.conference.Section;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SectionConverter {
    public Section convertDtoToModel(ConferenceSectionDto dto) {
        return Section.builder()
            .id(dto.getId())
            .noOfParticipants(dto.getNoOfParticipants())
            .roomNumber(dto.getRoomNumber())
            .sectionName(dto.getSectionName())
            .supervisor(dto.getSupervisor())
            .build();
    }

    public ConferenceSectionDto convertModelToDto(Section section) {
        return ConferenceSectionDto.builder()
            .id(section.getId())
            .noOfParticipants(section.getNoOfParticipants())
            .roomNumber(section.getRoomNumber())
            .sectionName(section.getSectionName())
            .supervisor(section.getSupervisor())
            .build();
    }

    public List<Section> convertDtosToModels(List<ConferenceSectionDto> dtos) {
        return dtos
            .stream()
            .map(this::convertDtoToModel)
            .collect(Collectors.toList());
    }

    public List<ConferenceSectionDto> convertModelsToDtos(List<Section> sections) {
        return sections
            .stream()
            .map(this::convertModelToDto)
            .collect(Collectors.toList());
    }
}
