package sdi.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sdi.cms.model.paper.AbstractFile;

@Repository
public interface AbstractFileRepository extends JpaRepository<AbstractFile,Integer> {
}
