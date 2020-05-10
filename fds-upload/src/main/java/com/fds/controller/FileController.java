package com.fds.controller;

import com.fds.service.FileSerivce;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {
    @Autowired
    private FileSerivce fileService;

    @PostMapping("/upload")
    public String upload(MultipartFile file) {
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        try {
            return fileService.upload(file.getInputStream(), file.getSize(), ext);
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
