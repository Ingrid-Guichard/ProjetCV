package io.takima.demo;

import org.springframework.stereotype.Controller;
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

    @GetMapping("/index/{id}")
    public String homePage(@PathVariable(value = "id") Long id, Model m) {
        Optional<User> user = this.userDAO.findById(id);
        if(user.isPresent()) {
            m.addAttribute("user", user.get());
            m.addAttribute("languages", user.get().getLanguages());
            m.addAttribute("skills", user.get().getSkills());
            m.addAttribute("educations", user.get().getEducations());
            m.addAttribute("projects", user.get().getProjects());
            m.addAttribute("experiences", user.get().getExperiences());
            return "index";
        } else
        {
            return "";
        }
    }

    @GetMapping("/edit/{id}")
    public String displayUserPage(@PathVariable(value = "id") Long id, Model m) {
        Optional<User> user = this.userDAO.findById(id);
        if(user.isPresent()) {
            m.addAttribute("user", user.get());
            m.addAttribute("languages", user.get().getLanguages());
            m.addAttribute("skills", user.get().getSkills());
            m.addAttribute("educations", user.get().getEducations());
            m.addAttribute("projects", user.get().getProjects());
            m.addAttribute("experiences", user.get().getExperiences());
            return "user";
        } else
        {
            return "";
        }
    }

    @PostMapping("/edit/{id}")
    public RedirectView editUser(@ModelAttribute User user) {
        userDAO.save(user);
        return new RedirectView("/edit/" + user.getId());
    }



}
