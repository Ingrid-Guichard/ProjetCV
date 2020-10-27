package io.takima.demo;

import com.CGO.myawesomeCV.*;import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@RequestMapping("/")
@Controller
public class LibraryController {

    private final UserDAO userDAO;
    private final EducationDAO educationDAO;
    private final ExperienceDAO experienceDAO;
    private final LanguageDAO languageDAO;
    private final LinkDAO linkDAO;
    private final ProjectDAO projectDAO;
    private final SkillDAO skillDAO;

    public LibraryController(UserDAO userDAO, EducationDAO educationDAO, ExperienceDAO experienceDAO, LanguageDAO languageDAO, LinkDAO linkDAO, ProjectDAO projectDAO, SkillDAO skillDAO) {
        this.userDAO = userDAO;
        this.educationDAO = educationDAO;
        this.experienceDAO = experienceDAO;
        this.languageDAO = languageDAO;
        this.linkDAO = linkDAO;
        this.projectDAO = projectDAO;
        this.skillDAO = skillDAO;
    }

    @GetMapping("/edit/{id}")
    public String addUserPage(@PathVariable(value = "id") Long id, Model m) {
        Optional<User> user = this.userDAO.findById(id);
        if(user.isPresent()) {
            m.addAttribute("user", user.get());
            m.addAttribute("languages", this.languageDAO.findLanguagesByUser_id(id));
            m.addAttribute("skills", this.skillDAO.findSkillsByUser_id(id));
            m.addAttribute("educations",this.educationDAO.findEducationsByUser_id(id));
            m.addAttribute("projects",this.projectDAO.findProjectsByUser_id(id));
            m.addAttribute("experiences",this.experienceDAO.findExperiencesByUser_id(id));
            return "affichageDroite";
        } else
        {
            return "";
        }
    }

    @PostMapping("/edit/{id}")
    public RedirectView createNewUser(@ModelAttribute User user, RedirectAttributes attrs) {
        attrs.addFlashAttribute("message", "Vos modifications ont bien été ajoutées.");
        userDAO.save(user);
        return new RedirectView("/edit/{id}");
    }

}
