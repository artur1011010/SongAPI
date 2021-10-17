package pl.arturzaczek.song.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<Set<SongDTO>> getAllSongs(){
        return ResponseEntity.ok(songService.getAllSongs());
    }

    @GetMapping("/song/{id}")
    public ResponseEntity<SongDTO> getSongById(Long id){
        return ResponseEntity.ok(songService.getSongById(id));
    }


    @PostMapping("/song")
    public ResponseEntity<Boolean> addSong(@RequestBody SongDTO songDTO){
        songService.postSong(songDTO);
        return ResponseEntity.ok(Boolean.TRUE);
    }

}
