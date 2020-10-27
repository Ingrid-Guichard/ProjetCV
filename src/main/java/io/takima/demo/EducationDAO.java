package io.takima.demo;

import com.CGO.myawesomeCV.Education;import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationDAO extends CrudRepository<Education, Long> {
    List<Education> findEducationsByUser_id(long id);
}
