package io.takima.demo;

import com.CGO.myawesomeCV.Link;import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkDAO extends CrudRepository<Link, Long> {
    
}
