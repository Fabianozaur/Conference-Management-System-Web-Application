package sdi.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sdi.cms.model.paper.Paper;

@Repository
public interface PaperRepository extends JpaRepository<Paper, Integer> {
}
