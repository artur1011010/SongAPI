package pl.arturzaczek.song.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SongDTO {
    private String artist;
    private String title;
    private Integer releaseYear;
}
