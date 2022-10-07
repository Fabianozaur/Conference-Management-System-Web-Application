package sdi.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sdi.cms.model.paper.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
