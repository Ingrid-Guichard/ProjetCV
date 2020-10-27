package io.takima.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationDAO extends CrudRepository<Education, Long> {
    List<Education> findEducationsByUserId(long id);
}
