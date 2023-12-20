package com.devgps.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devgps.mvc.model.Anime;
import com.devgps.mvc.repository.AnimeRepository;

import java.util.List;

@Controller
@RequestMapping("/animes")
public class AnimeController {

    @Autowired
    private AnimeRepository animeRepository;

    @GetMapping
    public String listAnimes(Model model) {
        List<Anime> animes = animeRepository.findAll();
        model.addAttribute("animes", animes);
        return "animes/list";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("anime", new Anime());
        return "animes/form";
    }

    @PostMapping("/form")
    public String submitForm(@ModelAttribute Anime anime) {
        animeRepository.save(anime);
        return "redirect:/animes";
    }

    @GetMapping("edit/{id}")
    public String editAnime(@PathVariable Long id, Model model) {
        Anime anime = animeRepository.findById(id).orElse(null);
        model.addAttribute("anime", anime);
        return "animes/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteAnime(@PathVariable Long id) {
        animeRepository.deleteById(id);
        return "redirect:/animes";
    }
}