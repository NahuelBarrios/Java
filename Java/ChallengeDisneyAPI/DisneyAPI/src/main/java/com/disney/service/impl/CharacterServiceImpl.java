package com.disney.service.impl;

import com.disney.dao.ICharacterDao;
import com.disney.entities.Characters;
import com.disney.service.ICharacterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements ICharacterService{

    @Autowired
    private ICharacterDao characterDao;
    
    @Override
    public void save(Characters character) {
        characterDao.save(character);
    }
    
    @Override
     public List<Characters> listCharacters()
     {
         return (List<Characters>) characterDao.findAll();
     }

    @Override
    public void delete(Characters character) {
        characterDao.delete(character);
    }

    @Override
    public Characters encontrarCharacter(Characters character) {
        return characterDao.findById(character.getIdCharacter()).orElse(null);
    }
    
}
