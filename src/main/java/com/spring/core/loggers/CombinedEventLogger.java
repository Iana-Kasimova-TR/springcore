package com.spring.core.loggers;

import com.spring.core.beans.Event;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by Iana_Kasimova on 8/22/2017.
 */
@AllArgsConstructor
public class CombinedEventLogger implements EventLogger{

    Collection<EventLogger> loggers;

    @Override
    public void logEvent(Event event) throws IOException {
        for (EventLogger logger: this.loggers) {
            logger.logEvent(event);
        }
    }
}
