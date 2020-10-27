package io.takima.demo;

import com.CGO.myawesomeCV.Skill;import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillDAO extends CrudRepository<Skill, Long> {
    List<Skill> findSkillsByUser_id(long id);
}
