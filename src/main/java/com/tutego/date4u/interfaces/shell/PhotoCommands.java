package com.tutego.date4u.interfaces.shell;

import com.tutego.date4u.core.photo.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@ShellComponent
public class PhotoCommands {
    private final PhotoService photoService;

    public PhotoCommands(PhotoService photoService) {
        this.photoService = photoService;
    }

@ShellMethod("Show photo")   //show-photo
String showPhoto(String name){
    return photoService.download(name)
            .map(bytes -> {
                try {
                    var  image = ImageIO.read(new ByteArrayInputStream(bytes));
                    return "width: " + image.getWidth()+ ", height: " + image.getHeight();
                } catch (IOException e) {
                    return "Unable to read image dimensions";
                }
            }).orElse("Image not found");
    }
}
