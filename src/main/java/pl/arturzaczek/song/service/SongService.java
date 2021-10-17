package pl.arturzaczek.song.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.arturzaczek.song.model.Song;
import pl.arturzaczek.song.model.SongDTO;
import pl.arturzaczek.song.model.SongDTOMapper;
import pl.arturzaczek.song.model.SongRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Slf4j
public class SongService {

    SongRepository songRepository;
    SongDTOMapper songDTOMapper;

    public SongService(SongRepository songRepository, SongDTOMapper songDTOMapper){
        this.songRepository = songRepository;
        this.songDTOMapper = songDTOMapper;
    }

    @PostConstruct
    public void init(){
        List<Song> list = new ArrayList<>();
        list.add(Song.builder().title("Hotline Bling").artist("Drake").releaseYear(2015).build());
        list.add(Song.builder().title("Physical").artist("Dua Lipa").releaseYear(2020).build());
        list.add(Song.builder().title("Feel It Still").artist("Portugal. The Man").releaseYear(2017).build());
        list.add(Song.builder().title("James Bond").artist("Iggy Pop").releaseYear(2019).build());
        list.add(Song.builder().title("Disparate Youth").artist("Santigold").releaseYear(2012).build());
        list.add(Song.builder().title("Hideaway").artist("Kiesza").releaseYear(2014).build());
        list.add(Song.builder().title("Gold").artist("Chet Faker").releaseYear(2013).build());
        list.add(Song.builder().title("What’s Your Pleasure?").artist("Jessie Ware").releaseYear(2020).build());
        list.add(Song.builder().title("Waiting All Night").artist("Rudimental").releaseYear(2013).build());
        list.add(Song.builder().title("Lonely Boy").artist("The Black Keys").releaseYear(2011).build());
        songRepository.saveAllAndFlush(list);
    }

    public Set<SongDTO> getAllSongs(){
        SongDTO songDTO = songDTOMapper.songDTOMapper(songRepository.findById(1L).get());
        log.info("getAllSongs() {}", songDTO);
        return songRepository
                .findAll()
                .stream()
                .map(songDTOMapper::songDTOMapper)
                .collect(Collectors.toSet());
    }
}
