package com.exercises.spring.controller.files;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("files")
public class FilesThymeleafWebController {

    @GetMapping("/uploadAlbum")
    public String uploadAlbumPage(Model model) {
        return "files/uploadAlbum";
    }

}
