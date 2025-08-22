package com.ecommerce.fashion_store.controller;


import com.ecommerce.fashion_store.service.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/files")
public class FileUploadController {


    private final FileStorageService fileStorageService;

    @Value("${server.port}")
    private int serverPort;

    public FileUploadController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("product") MultipartFile file) {

        System.out.println("===========================");
        try {
            String filename = fileStorageService.saveFile(file);
            String fileUrl = "http://localhost:" + serverPort + "/images/" + filename;

            Map<String, Object> response = new HashMap<>();
            response.put("success", 1);
            response.put("image_url", fileUrl);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("success", 0, "message", e.getMessage()));
        }
    }
}
