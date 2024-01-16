package com.example.filesearch;

import jakarta.persistence.*;

@Entity
public class FilePost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column (name = "file-name")
    private String fileName;
    @Column (name = "file-path")
    private String filePath;

    public FilePost(){}
    public FilePost(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public int getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
