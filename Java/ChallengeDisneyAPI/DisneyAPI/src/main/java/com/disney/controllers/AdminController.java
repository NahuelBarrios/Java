package com.disney.controllers;

import com.disney.entities.Characters;
import com.disney.entities.Movie;
import com.disney.service.IMovieService;
import com.disney.service.impl.CharacterServiceImpl;
import java.io.IOException;
import java.nio.file.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private IMovieService movieService;
    
    @Autowired
    private CharacterServiceImpl characterService;
    
    
    //Panel Main
    @GetMapping("/panel-admin")
    public String panelAdmin()
    {
        return "admin/paneladmin";
    }
    //Movie
    @GetMapping("/movie-form")
    public String movieForm(Model model)
    {
        model.addAttribute("movie",new Movie());
        return "admin/movieform";
    }
    
    @PostMapping("/savemovie")
    public String saveMovie(Movie movie,@RequestParam("file") MultipartFile imagen,RedirectAttributes redirect)
    {
        if(!imagen.isEmpty())
        {
            Path directorioImagenes = Paths.get("src//main//resources//static/images");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
            
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta,bytesImg);
                movie.setImageMovie(imagen.getOriginalFilename());
                movieService.save(movie);
                
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return "redirect:admin/panel-admin";
    }
    
}
