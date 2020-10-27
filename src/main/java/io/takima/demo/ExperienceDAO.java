package io.takima.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceDAO extends CrudRepository<Experience, Long> {
    List<Experience> findExperiencesByUserId(long id);
}
