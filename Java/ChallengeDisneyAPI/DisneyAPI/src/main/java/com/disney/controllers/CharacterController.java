package com.disney.controllers;

import com.disney.entities.Characters;
import com.disney.service.IMovieService;
import com.disney.service.impl.CharacterServiceImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterServiceImpl characterService;
    
    @Autowired
    private IMovieService movieService;
    
    
    //************************* PARTE DEL USUARIO **************************
    @GetMapping("/list-all")
    public String characterListAll(Model model)
    {
        var listCharacter = characterService.listCharacters();
        model.addAttribute("listCharacter", listCharacter);
        return "characterlistall";
    }

    
    
    //************************* PARTE DEL ADMIN **************************
    
    @GetMapping("/list")
    public String characterList(Model model)
    {
        var characterList = characterService.listCharacters();
        var movieList = movieService.listMovies();
        model.addAttribute("characterList", characterList);
        model.addAttribute("movieList", movieList);
        
        return "admin/characterlist";
    }
    
    
    @GetMapping("/character-form")
    public String formCharacter(Characters character, Model model) {
        model.addAttribute("character", new Characters());
        var moviesAux = movieService.listMovies();
        model.addAttribute("movielist", moviesAux);
        return "admin/characterform";
    }

    @PostMapping("/savecharacter")
    public String saveCharacter(Characters character, RedirectAttributes redirect, Model model, @RequestParam("file") MultipartFile imagen) {

        if (!imagen.isEmpty()) {
            Path directorioImagenes = Paths.get("src//main//resources//static/images");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                character.setImageCharacter(imagen.getOriginalFilename());

                
                redirect.addFlashAttribute("characterSave", "personaje guardado");
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
            
            characterService.save(character);
        }
        else
        {
            redirect.addFlashAttribute("characteSave", "personaje NO se guardo");
        }
        return "redirect:/admin/panel-admin";
    }

    @GetMapping("/edit-character/{idCharacter}")
    public String editCharacter(Characters character,Model model)
    {
        character = characterService.encontrarCharacter(character);
        model.addAttribute("characters", character);
        
        return "admin/characteredit";
    }
    
}
