package com.example.filesearch;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileServer {
    List<FilePost> filesFromTheList = new ArrayList<>();

    public List<FilePost> getFilesFromTheList() {
        return filesFromTheList;
    }

    public void putTheFilePathInTheList(String filePath) {
        File directoryPath = new File(filePath);

        if (directoryPath.isDirectory()) {
            File[] filesList = directoryPath.listFiles();
            if (filesList != null) {
                for (File file : filesList) {
                    processFile(file);
                }
            }
        }
    }

    private void processFile(File file) {
        if (file.isFile()) {
            FilePost newFile = new FilePost(file.getName(), file.getPath());
            updateOrInsertFile(newFile);
        } else {
            putTheFilePathInTheList(file.getPath());
        }
    }

    private void updateOrInsertFile(FilePost newFile) {
        FilePost existingFile = findFileByName(newFile.getFileName());

        if (existingFile != null) {
            existingFile.setFilePath(newFile.getFilePath());
        } else {
            filesFromTheList.add(newFile);
        }
    }

    private FilePost findFileByName(String filename) {
        return filesFromTheList.stream()
                .filter(file -> file.getFileName().equals(filename))
                .findFirst()
                .orElse(null);
    }
}
