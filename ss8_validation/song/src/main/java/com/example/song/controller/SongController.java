package com.example.song.controller;

import com.example.song.model.Song;
import com.example.song.dto.SongDto;
import com.example.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("song")
public class SongController {
    @Autowired
    ISongService service;

    @GetMapping("")
    public String showLis(Model model) {
        List<Song> list = service.findAll();
        model.addAttribute("songs", list);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes redirect) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        service.addSong(song);
        redirect.addFlashAttribute("success", "thêm mới thành công");
        return "redirect:/song";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("song", service.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute SongDto song, BindingResult bindingResult, RedirectAttributes redirect) {
        new SongDto().validate(song, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Song song1 = new Song();
        BeanUtils.copyProperties(song, song1);
        service.update(song1);
        redirect.addFlashAttribute("message", "Update successful!");
        return "redirect:/song";
    }
}
