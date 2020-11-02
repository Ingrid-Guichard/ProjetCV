package io.takima.demo;

import io.takima.demo.storage.StorageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.nio.file.Files;
import java.util.NoSuchElementException;


@RequestMapping("/")
@Controller
public class LibraryController {

    private final UserDAO userDAO;
    private final LinkDAO linkDAO;
    private final StorageService storageService;

    public LibraryController(UserDAO userDAO, LinkDAO linkDAO, StorageService storageService) {
        this.userDAO = userDAO;
        this.linkDAO = linkDAO;
        this.storageService = storageService;
    }

    @GetMapping("/index/{id}")
    public String homePage(@PathVariable(value = "id") Long id, Model m) {
        User user = this.userDAO.findById(id).orElseThrow(() -> new NoSuchElementException());

        Link link1 = this.linkDAO.findLinkByTitleAndUserId("LinkedIn",user);
        Link link2 = this.linkDAO.findLinkByTitleAndUserId("GitHub",user);
        Link link3 = this.linkDAO.findLinkByTitleAndUserId("Twitter",user);
        Link link4 = this.linkDAO.findLinkByTitleAndUserId("Facebook",user);
        m.addAttribute("user", user);
        m.addAttribute("languages", user.getLanguages());
        m.addAttribute("links", user.getLinks());
        m.addAttribute("link1",link1.getLink());
        m.addAttribute("link2",link2.getLink());
        m.addAttribute("link3",link3.getLink());
        m.addAttribute("link4",link4.getLink());
        m.addAttribute("skills", user.getSkills());
        m.addAttribute("educations", user.getEducations());
        m.addAttribute("projects", user.getProjects());
        m.addAttribute("experiences", user.getExperiences());
        return "index";
    }

    @RequestMapping("/images/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {
        return Files.readAllBytes(storageService.load(imageName));
    }


    @GetMapping("/edit/{id}")
    public String displayUserPage(@PathVariable(value = "id") Long id, Model m) {
        User user = this.userDAO.findById(id).orElseThrow(() -> new NoSuchElementException());

        m.addAttribute("user", user);
        m.addAttribute("languages", user.getLanguages());
        m.addAttribute("skills", user.getSkills());
        m.addAttribute("educations", user.getEducations());
        m.addAttribute("projects", user.getProjects());
        m.addAttribute("experiences", user.getExperiences());
        return "user";
    }

    @PostMapping("/edit/{id}")
    public RedirectView editUser(@ModelAttribute User user, @RequestParam("picture") MultipartFile picture) {
        user.setPhoto(this.storageService.store(picture));
        userDAO.save(user);
        return new RedirectView("/edit/" + user.getId());
    }

    @GetMapping("/edit/education/{id}")
    public String displayEducationPage(@PathVariable(value = "id") Long id, Model m) {
        User user = this.userDAO.findById(id).orElseThrow(() -> new NoSuchElementException());

        m.addAttribute("user", user);
        m.addAttribute("languages", user.getLanguages());
        m.addAttribute("skills", user.getSkills());
        m.addAttribute("educations", user.getEducations());
        m.addAttribute("edu", new Education());
        m.addAttribute("projects", user.getProjects());
        m.addAttribute("experiences", user.getExperiences());
        return "education";
    }

    @PostMapping("/edit/education/{id}")
    public RedirectView newEducation(@PathVariable(value = "id") Long id, @ModelAttribute Education edu) {
        User user = this.userDAO.findById(id).orElseThrow(() -> new NoSuchElementException());
        edu.setUserId(user);
        user.getEducations().add(edu);
        userDAO.save(user);
        return new RedirectView("/edit/education/" + user.getId());
    }

    @PutMapping("/edit/education/{id}")
    public RedirectView editEducation(@ModelAttribute User user) {
        userDAO.save(user);
        return new RedirectView("/edit/education/" + user.getId());
    }

    @GetMapping("/edit/experience/{id}")
    public String displayExperiencePage(@PathVariable(value = "id") Long id, Model m) {
        User user = this.userDAO.findById(id).orElseThrow(() -> new NoSuchElementException());

        m.addAttribute("user", user);
        m.addAttribute("languages", user.getLanguages());
        m.addAttribute("skills", user.getSkills());
        m.addAttribute("educations", user.getEducations());
        m.addAttribute("projects", user.getProjects());
        m.addAttribute("experiences", user.getExperiences());
        m.addAttribute("exp", new Experience());
        return "experience";
    }

    @PostMapping("/edit/experience/{id}")
    public RedirectView newExperience(@PathVariable(value = "id") Long id, @ModelAttribute Experience exp) {
        User user = this.userDAO.findById(id).orElseThrow(() -> new NoSuchElementException());
        user.getExperiences().add(exp);
        return new RedirectView("/edit/experience/" + user.getId());
    }

    @PutMapping("/edit/experience/{id}")
    public RedirectView editExperience(@ModelAttribute User user) {
        userDAO.save(user);
        return new RedirectView("/edit/experience/" + user.getId());
    }

    @GetMapping("/edit/language/{id}")
    public String displayLanguagePage(@PathVariable(value = "id") Long id, Model m) {
        User user = this.userDAO.findById(id).orElseThrow(() -> new NoSuchElementException());

        m.addAttribute("user", user);
        m.addAttribute("languages", user.getLanguages());
        m.addAttribute("lang", new Language());
        m.addAttribute("skills", user.getSkills());
        m.addAttribute("educations", user.getEducations());
        m.addAttribute("projects", user.getProjects());
        m.addAttribute("experiences", user.getExperiences());
        return "language";
    }

    @PostMapping("/edit/language/{id}")
    public RedirectView newLanguage(@PathVariable(value = "id") Long id, @ModelAttribute Language lang) {
        User user = this.userDAO.findById(id).orElseThrow(() -> new NoSuchElementException());
        user.getLanguages().add(lang);
        return new RedirectView("/edit/language/" + user.getId());
    }

    @PutMapping("/edit/language/{id}")
    public RedirectView editLanguage(@ModelAttribute User user) {
        userDAO.save(user);
        return new RedirectView("/edit/language/" + user.getId());
    }

    @GetMapping("/edit/link/{id}")
    public String displayLinkPage(@PathVariable(value = "id") Long id, Model m) {
        User user = this.userDAO.findById(id).orElseThrow(() -> new NoSuchElementException());

        m.addAttribute("user", user);
        m.addAttribute("languages", user.getLanguages());
        m.addAttribute("skills", user.getSkills());
        m.addAttribute("educations", user.getEducations());
        m.addAttribute("links", user.getLinks());
        m.addAttribute("projects", user.getProjects());
        m.addAttribute("experiences", user.getExperiences());
        return "link";
    }

    @PutMapping("/edit/link/{id}")
    public RedirectView editLink(@ModelAttribute User user) {
        userDAO.save(user);
        return new RedirectView("/edit/link/" + user.getId());
    }

    @GetMapping("/edit/project/{id}")
    public String displayProjectPage(@PathVariable(value = "id") Long id, Model m) {
        User user = this.userDAO.findById(id).orElseThrow(() -> new NoSuchElementException());

        m.addAttribute("user", user);
        m.addAttribute("languages", user.getLanguages());
        m.addAttribute("skills", user.getSkills());
        m.addAttribute("educations", user.getEducations());
        m.addAttribute("projects", user.getProjects());
        m.addAttribute("proj", new Project());
        m.addAttribute("experiences", user.getExperiences());
        return "project";
    }

    @PostMapping("/edit/project/{id}")
    public RedirectView newProject(@PathVariable(value = "id") Long id, @ModelAttribute Project proj) {
        User user = this.userDAO.findById(id).orElseThrow(() -> new NoSuchElementException());
        user.getProjects().add(proj);
        return new RedirectView("/edit/project/" + user.getId());
    }

    @PutMapping("/edit/project/{id}")
    public RedirectView editProject(@ModelAttribute User user) {
        userDAO.save(user);
        return new RedirectView("/edit/project/" + user.getId());
    }

    @GetMapping("/edit/skill/{id}")
    public String displaySkillPage(@PathVariable(value = "id") Long id, Model m) {
        User user = this.userDAO.findById(id).orElseThrow(() -> new NoSuchElementException());

        m.addAttribute("user", user);
        m.addAttribute("languages", user.getLanguages());
        m.addAttribute("skills", user.getSkills());
        m.addAttribute("sk", new Skill());
        m.addAttribute("educations", user.getEducations());
        m.addAttribute("projects", user.getProjects());
        m.addAttribute("experiences", user.getExperiences());
        return "skill";
    }

    @PostMapping("/edit/skill/{id}")
    public RedirectView newSkill(@PathVariable(value = "id") Long id, @ModelAttribute Skill sk) {
        User user = this.userDAO.findById(id).orElseThrow(() -> new NoSuchElementException());
        user.getSkills().add(sk);
        return new RedirectView("/edit/skill/" + user.getId());
    }

    @PutMapping("/edit/skill/{id}")
    public RedirectView editSkill(@ModelAttribute User user) {
        userDAO.save(user);
        return new RedirectView("/edit/skill/" + user.getId());
    }

}
