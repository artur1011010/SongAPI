package pl.arturzaczek.song.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arturzaczek.song.model.SongDTO;
import pl.arturzaczek.song.service.SongService;

import java.util.Set;

@RestController
public class SongController {

    SongService songService;

    public SongController(SongService songService){
        this.songService = songService;
    }

    @GetMapping("/song")
    public Set<SongDTO> getAllSongs(){
        return songService.getAllSongs();
    }
}
