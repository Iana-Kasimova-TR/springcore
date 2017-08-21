package com.spring.core.loggers;

import com.spring.core.beans.Event;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Iana_Kasimova on 8/21/2017.
 */
public class FileEventLogger implements EventLogger {

    private String fileName;
    protected File file;
    @Override
    public void logEvent(Event event) throws IOException {
        FileUtils.writeStringToFile(this.file, event.getMsg());
    }

    public FileEventLogger(String fn){
        this.fileName = fn;
    }

   public void init() throws IOException{
        this.file = new File(fileName);
   }
}
