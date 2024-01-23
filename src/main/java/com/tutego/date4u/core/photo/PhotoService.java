package com.tutego.date4u.core.photo;

import com.tutego.date4u.core.FileSystem;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PhotoService {

private final FileSystem fs;

    public PhotoService(FileSystem fs) {
        this.fs = fs;
    }

    public Optional<byte[]>download(String imageName){
        try {
            return Optional.ofNullable(fs.load(imageName + ".jpg"));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
