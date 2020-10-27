package io.takima.demo;

import com.CGO.myawesomeCV.Project;import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDAO extends CrudRepository<Project, Long> {
    List<Project> findProjectsByUser_id(long id);
}
