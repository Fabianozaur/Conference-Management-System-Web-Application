package sdi.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;
import sdi.cms.converter.ProposalConverter;
import sdi.cms.dto.ProposalDto;
import sdi.cms.model.paper.Proposal;
import sdi.cms.repository.ProposalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProposalService {

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private ProposalConverter converter;

    public List<Proposal> getAll() {
        return proposalRepository.findAll();
    }

    public List<ProposalDto> getAllDtos() {
        return converter.modelsToDtos(getAll());
    }

    public Proposal addProposal(Proposal proposal) {
        return proposalRepository.save(proposal);
    }

    public ProposalDto addProposalDto(ProposalDto proposal) {
        return converter.ModelToDto(addProposal(converter.DtoToModel(proposal)));
    }

    public Proposal updateProposal(Proposal proposal) {
        proposalRepository.findById(proposal.getId())
                .ifPresent(e -> proposalRepository.save(proposal));
        return proposal;
    }

    public ProposalDto updateProposalDto(ProposalDto proposal) {
        return converter.ModelToDto(updateProposal(converter.DtoToModel(proposal)));
    }
}
