package com.spring.core.loggers;

import com.spring.core.beans.Event;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.*;

/**
 * Created by Iana_Kasimova on 8/21/2017.
 */
public class CacheFileEventLogger extends FileEventLogger {

    int cacheSize;
    List<Event> cache;

    public CacheFileEventLogger(String filename, String ch){
        super(filename);
        this.cacheSize = Integer.parseInt(ch);
        this.cache = new ArrayList<Event>();

    }

    public void logEvent(Event event){
        this.cache.add(event);
        if(this.cache.size() == cacheSize){
            this.cache.clear();
        }
    }

    @PreDestroy
    public void destroy() throws IOException {
        if(!this.cache.isEmpty()){
            writeEventsFromCache();
        }
    }


    private void writeEventsFromCache() throws IOException {
        for (Event event : this.cache) {
            FileUtils.writeStringToFile(this.file, event.getMsg(), true);
        }
    }

}
