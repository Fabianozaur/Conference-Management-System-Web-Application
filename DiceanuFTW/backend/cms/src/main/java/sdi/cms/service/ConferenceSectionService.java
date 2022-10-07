package sdi.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdi.cms.model.conference.Section;
import sdi.cms.repository.ConferenceSectionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConferenceSectionService {
    @Autowired
    private ConferenceSectionRepository conferenceSectionRepository;

    public List<Section> getAllConferenceSections() {
        return conferenceSectionRepository.findAll();
    }

    public Section addConferenceSection(Section section) {
        return conferenceSectionRepository.save(section);
    }

    @Transactional
    public Section updateConferenceSection(Section section) {
        Optional<Section> oldConferenceSection = conferenceSectionRepository.findById(section.getId());
        conferenceSectionRepository.findById(section.getId())
            .ifPresent(c -> {
//                    c.setSupervisor(section.getSupervisor());
                c.setRoomNumber(section.getRoomNumber());
            });
        System.out.println(section);
        return oldConferenceSection.get();
    }
}
