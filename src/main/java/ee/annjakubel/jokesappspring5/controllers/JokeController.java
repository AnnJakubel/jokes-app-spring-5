package ee.annjakubel.jokesappspring5.controllers;

import ee.annjakubel.jokesappspring5.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private final JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    //This is meant by mapping to root - aka the homepage of the url
    //in this case "localhost:8080"
    @RequestMapping({"/", ""})
    public String showJoke(Model model) {
        //remember, model works with Thymeleaf to show the joke
        model.addAttribute("joke", jokeService.getJoke());

        return "index";
    }
}
