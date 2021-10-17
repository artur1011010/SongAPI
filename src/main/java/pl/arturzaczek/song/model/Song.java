package pl.arturzaczek.song.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "SONG")
@Data
@Builder
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     Long id;
    @Column(name = "ARTIST")
     String artist;
    @Column(name = "TITLE", nullable = false, length = 100)
     String title;
     Integer releaseYear;

    public Song() {

    }

    public Song(String artist, String title, Integer releaseYear) {
        this.artist = artist;
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public Song(Long id, String artist, String title, Integer releaseYear) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.releaseYear = releaseYear;
    }

}
