package com.spring.core.loggers;

import com.spring.core.beans.Event;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * Created by Iana_Kasimova on 8/21/2017.
 */
@Component
@PropertySource(value={"client.properties"})
public class FileEventLogger implements EventLogger {

    @Value("${filename}")
    private String fileName;

    protected File file;
    @Override
    public void logEvent(Event event) throws IOException {
        FileUtils.writeStringToFile(this.file, event.getMsg());
    }

    //public FileEventLogger(String fn){
     //   this.fileName = fn;
   // }

    @PostConstruct
   public void init() throws IOException{
        this.file = new File(fileName);
   }
}
