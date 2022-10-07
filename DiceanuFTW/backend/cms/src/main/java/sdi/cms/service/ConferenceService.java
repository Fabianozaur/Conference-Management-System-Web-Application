package sdi.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdi.cms.model.conference.Conference;
import sdi.cms.repository.ConferenceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConferenceService {
    @Autowired
    private ConferenceRepository conferenceRepository;

    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    public Conference addConference(Conference conference) {
        return conferenceRepository.save(conference);
    }

    @Transactional
    public Conference updateConference(Conference conference) {
        Optional<Conference> oldConference = conferenceRepository.findById(conference.getID());
        conferenceRepository.findById(conference.getID())
            .ifPresent(c -> {
                c.setDeadlineAbstract(conference.getDeadlineAbstract().plusDays(1));
                c.setDeadlineProposal(conference.getDeadlineProposal().plusDays(1));
            });
        return oldConference.get();
    }

}
