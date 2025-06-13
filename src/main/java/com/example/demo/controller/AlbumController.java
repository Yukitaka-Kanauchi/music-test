package com.example.demo.controller;

import com.example.demo.entity.Album;
import com.example.demo.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import com.example.demo.form.AlbumForm;
import org.springframework.web.bind.annotation.PostMapping;
//giglgiggliu
import com.example.demo.entity.Music;
import com.example.demo.service.MusicService;

import com.example.demo.form.MusicForm;


@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;
    private final MusicService musicService;

    public AlbumController(AlbumService albumService, MusicService musicService){
        this.albumService = albumService;
        this.musicService = musicService;
    }

    @GetMapping
    public String albums(Model model){
        List<Album> albums = albumService.getAllAlbums();
        model.addAttribute("albums", albums);
        //return "album/album-list";
        //return "album/album-first";
        return "menu/first";
    }
    @GetMapping("/list")
    public String albumlist(Model model){
        List<Album> albumstest = albumService.getAllAlbums();
        model.addAttribute("albums", albumstest);
        //return "album/album-list";
        //return "album/album-first";
        return "menu/manage";
    }

    @GetMapping("/suggest")
    public String disheslist(Model model){
        List<Album> disheslist = albumService.getAllAlbums();
        model.addAttribute("albums", disheslist);
        //return "album/album-list";
        //return "album/album-first";
        return "menu/suggest";
    }

    @GetMapping("/new")
    public String albumForm(Model model) {
        AlbumForm albumForm = new AlbumForm();
        model.addAttribute("albumForm", albumForm);
        return "album/album-form";
    }

    @GetMapping("/add")
    public String albumadd(Model model){
        AlbumForm albumForm_2 = new AlbumForm();
        model.addAttribute("albumForm", albumForm_2);
        return "menu/add";
    }

    @PostMapping("/add")
    public String createadd(AlbumForm albumForm) {
        albumService.createAlbum(albumForm);
        return "redirect:/albums/list";
    }

    /*
    @PostMapping("/new")
    public String createAlbum(AlbumForm albumForm, Model model) {
        albumService.createAlbum(albumForm);
        List<Album> albums = albumService.getAllAlbums();
        model.addAttribute("albums", albums);
        return "album/album-list";
     */
    @PostMapping("/new")
    public String createAlbum(AlbumForm albumForm) {
        albumService.createAlbum(albumForm);
        return "redirect:/albums";
    }
    @PostMapping("/list")
    public String createAlbumtest(AlbumForm albumForm) {
        albumService.createAlbum(albumForm);
        return "redirect:/albums/list";
    }

    @GetMapping("/{albumId}")
    public String album(@PathVariable long albumId, Model model) {
        Album album = albumService.getAlbumById(albumId);
        List<Music> musics = musicService.getMusicsByAlbumId(albumId);
        model.addAttribute("album", album);
        model.addAttribute("musics", musics);
        return "album/album-detail";
    }

    @PostMapping("/{albumId}/delete")
    public String deleteAlbum(@PathVariable long albumId) {
        albumService.deleteAlbum(albumId);
        return "redirect:/albums/list";
    }

    @GetMapping("/{albumId}/edit")
    public String editAlbum(@PathVariable long albumId, Model model) {
        Album album = albumService.getAlbumById(albumId);
        model.addAttribute("album", album);
        return "album/album-edit";
    }
    @PostMapping("/{albumId}/edit")
    public String updateAlbum(@PathVariable long albumId, Album album) {
        albumService.updateAlbum(albumId, album);
        return "redirect:/albums";
    }
    @GetMapping("/{albumId}/musics/new")
    public String createMusicForm(@PathVariable long albumId, Model model) {
        MusicForm musicForm = new MusicForm();
        musicForm.setAlbumId(albumId);
        model.addAttribute("musicForm", musicForm);
        return "music/music-form";
    }
    @PostMapping("/{albumId}/musics/new")
    public String createMusic(@PathVariable long albumId, MusicForm musicForm) {
        musicService.createMusic(musicForm);
        return "redirect:/albums/" + albumId;
    }
    @PostMapping("/{albumId}/musics/{musicId}/delete")
    public String deleteMusic(@PathVariable long albumId, @PathVariable long musicId) {
        musicService.deleteMusic(musicId);
        return "redirect:/albums/" + albumId;
    }

    @GetMapping("/{albumId}/musics/{musicId}/edit")
    public String editMusic(@PathVariable long albumId, @PathVariable long musicId, Model model) {
        Music music = musicService.getMusicById(musicId);
        model.addAttribute("music", music);
        return "music/music-edit";
    }

    @PostMapping("/{albumId}/musics/{musicId}/edit")
    public String updateMusic(@PathVariable long albumId, @PathVariable long musicId, Music music) {
        musicService.updateMusic(musicId, music);
        return "redirect:/albums/" + albumId;
    }
    
}
