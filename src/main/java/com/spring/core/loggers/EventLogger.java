package com.spring.core.loggers;

import com.spring.core.beans.Event;

import java.io.IOException;

/**
 * Created by Iana_Kasimova on 8/21/2017.
 */
public interface EventLogger {

    void logEvent(Event event) throws IOException;
}
