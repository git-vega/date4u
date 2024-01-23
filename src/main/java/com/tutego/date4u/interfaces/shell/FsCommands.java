package com.tutego.date4u.interfaces.shell;

import com.tutego.date4u.core.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.util.unit.DataSize;

import java.util.Locale;

@ShellComponent
public class FsCommands  {
//private final FileSystem fs = new FileSystem();

    //Filesystem in FsCommands injizieren mit Constructor Injection
   private final FileSystem fs;

   public FsCommands(FileSystem fs){
       this.fs= fs;
   }

@ShellMethod("Display required free disk space")
public long minimumFreeDiskSpace(){
        return 100000;
}

@ShellMethod("Display free disk space")
public String freeDiskSpace(){
    return DataSize.ofBytes(fs.getFreeDiskSpace()).toGigabytes() + "GB";
}

}
