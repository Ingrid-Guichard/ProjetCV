package io.takima.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageDAO extends CrudRepository<Language, Long> {
    List<Language> findLanguagesByUserId(long id);
}
