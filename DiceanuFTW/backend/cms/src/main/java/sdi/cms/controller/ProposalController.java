package sdi.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sdi.cms.dto.ProposalDto;
import sdi.cms.converter.ProposalConverter;
import sdi.cms.service.ProposalService;

import java.util.List;

@RestController
public class ProposalController {

    @Autowired
    private ProposalService proposalService;

    @GetMapping("/proposal")
    public ResponseEntity<?> getAll() {
        List<ProposalDto> proposalDtos = proposalService.getAllDtos();
        return new ResponseEntity<>(proposalDtos, HttpStatus.OK);
    }

    @PostMapping("/proposal")
    public ResponseEntity<?> addProposal(@RequestBody ProposalDto proposal) {
        ProposalDto proposalDto = proposalService.addProposalDto(proposal);
        return new ResponseEntity<>(proposalDto, HttpStatus.CREATED);
    }

    @PutMapping("/proposal")
    public ResponseEntity<?> updateProposal(@RequestBody ProposalDto proposal) {
        ProposalDto proposalDto = proposalService.updateProposalDto(proposal);
        return new ResponseEntity<>(proposalDto, HttpStatus.OK);
    }
}
