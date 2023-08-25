package com.example.song.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongDto implements Validator {
    private String name;
    private String singer;
    private String musicType;

    public SongDto() {
    }

    public SongDto(String name, String singer, String musicType) {
        this.name = name;
        this.singer = singer;
        this.musicType = musicType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if (songDto.getName().equals("")) {
            errors.rejectValue("name", null, "Cannot be left blank");
        } else if (!songDto.getName().matches("^[a-zA-Z0-9]{1,800}$")) {
            errors.rejectValue("name", null, "Malformed");
        }

        if (songDto.getSinger().equals("")) {
            errors.rejectValue("singer", null, "Cannot be left blank");
        } else if (!songDto.getSinger().matches("^[a-zA-Z0-9]{1,300}$")) {
            errors.rejectValue("singer", null, "Malformed");
        }
        if (songDto.getMusicType().equals("")) {
            errors.rejectValue("musicType", null, "Cannot be left blank");
        } else if (!songDto.getMusicType().matches("^[a-zA-Z0-9,]{1,1000}$")) {
            errors.rejectValue("musicType", null, "Malformed");
        }
    }
}
