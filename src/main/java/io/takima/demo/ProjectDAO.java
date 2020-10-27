package io.takima.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDAO extends CrudRepository<Project, Long> {
    List<Project> findProjectsByUserId(long id);
}
