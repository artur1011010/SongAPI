package pl.arturzaczek.song.model;

import org.mapstruct.Mapper;


@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface SongDTOMapper {

    Song songMapper(SongDTO source);
    SongDTO songDTOMapper(Song source);
}
