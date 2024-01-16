package com.example.filesearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private FileServer fileServer;
    @GetMapping("/")
    public String onIndex() {
        return "main";
    }
    @PostMapping("/aboutFolders")
    public String onTest(Model model, @RequestParam String filePath){
        fileServer.putTheFilePathInTheList(filePath);
        List<FilePost> posts = fileServer.getFilesFromTheList();
        fileRepository.saveAll(posts);
        model.addAttribute("totalFiles", posts.size());
        return "result";
    }
}
