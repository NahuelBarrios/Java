package com.disney.service;

import com.disney.entities.Characters;
import java.util.List;

public interface ICharacterService {
    
    public void save(Characters character);
    
    public List<Characters> listCharacters();
    
    public void delete(Characters character);
    
    public Characters encontrarCharacter(Characters character);
}
