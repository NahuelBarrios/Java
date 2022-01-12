package com.disney.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="movies")
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovie;
    
    private String imageMovie;
    
    private String titleMovie;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    private Date creationDate;

    private Integer calification;
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "movie")
    private List<Characters> characters;
    
    
    public Movie(Long idMovie,String imageMovie,String titleMovie,Date creationDate,Integer calification,List<Characters> characters)
    {
        this.idMovie = idMovie;
        this.imageMovie = imageMovie;
        this.titleMovie = titleMovie;
        this.creationDate = creationDate;
        this.calification = calification;
        this.characters = characters;
    }
    
    public Movie()
    {
        
    }

    public Long getIdMovie() {
        return idMovie;
    }

    public String getImageMovie() {
        return imageMovie;
    }

    public void setImageMovie(String imageMovie) {
        this.imageMovie = imageMovie;
    }

    public String getTitleMovie() {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getCalification() {
        return calification;
    }

    public void setCalification(Integer calification) {
        this.calification = calification;
    }

    
    
    public List<Characters> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Characters> characters) {
        this.characters = characters;
    }

    
    public void addCharacters(Characters character)
    {
        characters.add(character);
    }

}
