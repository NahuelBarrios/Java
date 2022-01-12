package com.disney.entities;

import javax.persistence.*;

@Entity
@Table(name = "characters")
public class Characters {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCharacter;
    
    private String imageCharacter;
    
    private String nameCharacter;
    
    private Integer ageCharacter;
    
    private Double weightCharacter;
    
    private String historyCharacter;
    
    @ManyToOne(fetch = FetchType.LAZY) // Muchos Personajes en una pelicula
    private Movie movie;

    public Characters() {
    }

    public Characters(Long idCharacter, String imageCharacter, String nameCharacter, Integer ageCharacter, Double weightCharacter, String historyCharacter, Movie movie) {
        this.idCharacter = idCharacter;
        this.imageCharacter = imageCharacter;
        this.nameCharacter = nameCharacter;
        this.ageCharacter = ageCharacter;
        this.weightCharacter = weightCharacter;
        this.historyCharacter = historyCharacter;
        this.movie = movie;
    }

    
    public Long getIdCharacter() {
        return idCharacter;
    }

    public String getImageCharacter() {
        return imageCharacter;
    }

    public void setImageCharacter(String imageCharacter) {
        this.imageCharacter = imageCharacter;
    }

    public String getNameCharacter() {
        return nameCharacter;
    }

    public void setNameCharacter(String nameCharacter) {
        this.nameCharacter = nameCharacter;
    }

    public Integer getAgeCharacter() {
        return ageCharacter;
    }

    public void setAgeCharacter(Integer ageCharacter) {
        this.ageCharacter = ageCharacter;
    }

    public Double getWeightCharacter() {
        return weightCharacter;
    }

    public void setWeightCharacter(Double weightCharacter) {
        this.weightCharacter = weightCharacter;
    }

    public String getHistoryCharacter() {
        return historyCharacter;
    }

    public void setHistoryCharacter(String historyCharacter) {
        this.historyCharacter = historyCharacter;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    
    
    
    
}
