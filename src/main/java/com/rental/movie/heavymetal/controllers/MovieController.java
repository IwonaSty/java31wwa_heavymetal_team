package com.rental.movie.heavymetal.controllers;

import com.rental.movie.heavymetal.model.Genre;
import com.rental.movie.heavymetal.model.Movie;
import com.rental.movie.heavymetal.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.LinkedList;

@Slf4j
@Controller
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping({"/movies"})
    public String getMovieIndex(Model model) {
        model.addAttribute("movies", service.getAll());
        return "movies/index";
    }

    @GetMapping({"/movies/action"})
    public String getAction(Model model) {
        model.addAttribute("genre", Genre.ACTION);
        model.addAttribute("movies", service.findAllByGenre(Genre.ACTION));
        return "movies/action";
    }


    @RequestMapping(value="/movies/action/delete")
    public String deleteMovie(@RequestParam Long id , Model model) {

        service.delete(id);
        return "redirect:/movies/action";

    }
    @GetMapping({"/movies/horror"})
    public String getHorror(Model model) {
        model.addAttribute("genre", Genre.HORROR);
        model.addAttribute("movies", service.findAllByGenre(Genre.HORROR));
        return "movies/horror";
    }


    @RequestMapping(value="/movies/horror/delete")
    public String deleteHorror(@RequestParam Long id , Model model) {

        service.delete(id);
        return "redirect:/movies/horror";

    }
    @GetMapping({"/movies/documentary"})
    public String getDocumentary(Model model) {
        model.addAttribute("genre", Genre.DOCUMENTARY);
        model.addAttribute("movies", service.findAllByGenre(Genre.DOCUMENTARY));
        return "movies/documentary";
    }


    @RequestMapping(value="/movies/documentary/delete")
    public String deleteDocumentary(@RequestParam Long id , Model model) {

        service.delete(id);
        return "redirect:/movies/documentary";

    }
    @GetMapping({"/movies/scifi"})
    public String getSciFi(Model model) {
        model.addAttribute("genre", Genre.SCI_FI);
        model.addAttribute("movies", service.findAllByGenre(Genre.SCI_FI));
        return "movies/scifi";
    }


    @RequestMapping(value="/movies/scifi/delete")
    public String deleteSciFi(@RequestParam Long id , Model model) {

        service.delete(id);
        return "redirect:/movies/scifi";

    }
    @GetMapping({"/movies/fantasy"})
    public String getFantasy(Model model) {
        model.addAttribute("genre", Genre.FANTASY);
        model.addAttribute("movies", service.findAllByGenre(Genre.FANTASY));
        return "movies/scifi";
    }


    @RequestMapping(value="/movies/fantasy/delete")
    public String deleteFantasy(@RequestParam Long id , Model model) {

        service.delete(id);
        return "redirect:/movies/fantasy";

    }
    @GetMapping({"/movies/cartoon"})
    public String getCartoon(Model model) {
        model.addAttribute("genre", Genre.CARTOON);
        model.addAttribute("movies", service.findAllByGenre(Genre.CARTOON));
        return "movies/cartoon";
    }


    @RequestMapping(value="/movies/cartoon/delete")
    public String deleteCartoon(@RequestParam Long id , Model model) {

        service.delete(id);
        return "redirect:/movies/cartoon";

    }
    @GetMapping({"/movies/comedy"})
    public String getComedy(Model model) {
        model.addAttribute("genre", Genre.COMEDY);
        model.addAttribute("movies", service.findAllByGenre(Genre.COMEDY));
        return "movies/cartoon";
    }


    @RequestMapping(value="/movies/comedy/delete")
    public String deleteComedy(@RequestParam Long id , Model model) {

        service.delete(id);
        return "redirect:/movies/comedy";

    }
    @GetMapping({"/movies/drama"})
    public String getDrama(Model model) {
        model.addAttribute("genre", Genre.DRAMA);
        model.addAttribute("movies", service.findAllByGenre(Genre.DRAMA));
        return "movies/drama";
    }


    @RequestMapping(value="/movies/drama/delete")
    public String deleteDrama(@RequestParam Long id , Model model) {

        service.delete(id);
        return "redirect:/movies/drama";

    }
    @GetMapping({"/movies/western"})
    public String getWestern(Model model) {
        model.addAttribute("genre", Genre.WESTERN);
        model.addAttribute("movies", service.findAllByGenre(Genre.WESTERN));
        return "movies/western";
    }


    @RequestMapping(value="/movies/western/delete")
    public String deleteWestern(@RequestParam Long id , Model model) {

        service.delete(id);
        return "redirect:/movies/western";

    }
    @GetMapping({"/movies/adventure"})
    public String getAdventure(Model model) {
        model.addAttribute("genre", Genre.ADVENTURE);
        model.addAttribute("movies", service.findAllByGenre(Genre.ADVENTURE));
        return "movies/adventure";
    }


    @RequestMapping(value="/movies/adventure/delete")
    public String deleteAdventure(@RequestParam Long id , Model model) {

        service.delete(id);
        return "redirect:/movies/adventure";

    }


    @GetMapping("/movie")
    public String getOneWorker(@RequestParam Long id, Model model) {

        model.addAttribute("movie",service.getById(id));

        return "movies/movie";

    }

    @GetMapping("/add-movie")
    public String newMovie(Model model) {
        model.addAttribute("genre", new LinkedList<Genre>(Arrays.asList(Genre.values())));
        model.addAttribute("movie", new Movie());
        return "movies/add-movie";
    }

    @PostMapping("/save-movie")
    public String saveMovie(@ModelAttribute Movie movie) {
        service.save(movie);
        log.info("Added movie: " + movie);

        return "redirect:/movies";
    }

}
