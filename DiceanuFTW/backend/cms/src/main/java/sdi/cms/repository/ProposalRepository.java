package sdi.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sdi.cms.model.paper.Proposal;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Integer> {
}
