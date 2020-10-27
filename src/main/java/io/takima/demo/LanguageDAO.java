package io.takima.demo;

import com.CGO.myawesomeCV.Language;import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageDAO extends CrudRepository<Language, Long> {
    List<Language> findLanguagesByUser_id(long id);
}
