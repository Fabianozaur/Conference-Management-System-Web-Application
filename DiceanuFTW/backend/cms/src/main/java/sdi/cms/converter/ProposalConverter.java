package sdi.cms.converter;

import org.springframework.stereotype.Component;
import sdi.cms.dto.ProposalDto;
import sdi.cms.model.paper.Proposal;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProposalConverter {

    private final ReviewConverter reviewConverter = new ReviewConverter();
    private final PaperConverter paperConverter = new PaperConverter();
    private final UserBasicConverter authorConverter = new UserBasicConverter();

    public Proposal DtoToModel(ProposalDto dto) {
        Proposal proposal = new Proposal();
        proposal.setId(dto.getId());
        proposal.setName(dto.getName());
        proposal.setKeywords(dto.getKeywords());
        proposal.setTopics(dto.getTopics());
        proposal.setPaper(paperConverter.DtoToModel(dto.getPaper()));
        proposal.setReviews(reviewConverter.dtosToModels(dto.getReviews()));
        proposal.setAuthors(authorConverter.convertDtosToModels(dto.getAuthors()));
        return proposal;
    }

    public ProposalDto ModelToDto(Proposal proposal) {
        return ProposalDto.builder().id(proposal.getId()).name(proposal.getName()).keywords(proposal.getKeywords()).topics(proposal.getTopics()).paper(paperConverter.ModelToDto(proposal.getPaper())).reviews(reviewConverter.modelsToDtos(proposal.getReviews())).authors(authorConverter.convertModelsToDtos(proposal.getAuthors())).build();

    }

    public List<ProposalDto> modelsToDtos(List<Proposal> models) {
        return models.stream()
                .map(this::ModelToDto)
                .collect(Collectors.toList());
    }

    public List<Proposal> dtosToModels(List<ProposalDto> dtos) {
        return dtos.stream()
                .map(this::DtoToModel)
                .collect(Collectors.toList());
    }

}
