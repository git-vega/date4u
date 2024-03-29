package com.tutego.date4u.core;


import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileSystem {

    private final Path root = Paths.get(System.getProperty("user.home")).resolve("fs");  // Der gegebene Codeausschnitt erstellt ein Objekt der Klasse Path, das auf ein Verzeichnis im Dateisystem zeigt. Hier ist eine schrittweise Erklärung:
    public FileSystem(){
        if(!Files.isDirectory(root)) {
            try {
                Files.createDirectory(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public long getFreeDiskSpace() {

        return root.toFile().getFreeSpace();
    }

    public byte[] load(String filename){

        try {
            return Files.readAllBytes(root.resolve(filename));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public void store(String filename,byte[] bytes){

        try {
            Files.write(root.resolve(filename),bytes);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
