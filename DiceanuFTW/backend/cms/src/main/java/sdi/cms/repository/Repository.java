package sdi.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface Repository<ID extends Serializable, T> extends JpaRepository<T, ID> {
}
