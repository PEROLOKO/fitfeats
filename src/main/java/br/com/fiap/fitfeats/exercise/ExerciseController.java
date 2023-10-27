package br.com.fiap.fitfeats.exercise;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    ExerciseService service;

    @Autowired
    MessageSource message;

    @GetMapping
    public String index(Model model, @AuthenticationPrincipal OAuth2User user){
        model.addAttribute("avatar_url", user.getAttribute("avatar_url"));
        model.addAttribute("username", user.getAttribute("name"));
        model.addAttribute("exercises", service.findAll());
        return "exercise/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect){
        service.delete(id);
        redirect.addFlashAttribute("success", message.getMessage("exercise.delete.success", null, LocaleContextHolder.getLocale()));
        return "redirect:/exercise";
    }

    @GetMapping("new")
    public String form(Exercise exercise) {
        return  "exercise/form";
    }

    @PostMapping
    public String create(@Valid Exercise exercise, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) return "exercise/form";
        service.create(exercise);
        redirect.addFlashAttribute("success","Exercicio cadastrado com sucesso");
        return "redirect:/exercise";
    }

}