package com.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory{

	 private static final Logger logger = LogManager.getLogger(CustomThreadFactory.class);
	    private final ThreadFactory defaultFactory = Thread.ofVirtual().factory();

	    @Override
	    public Thread newThread(Runnable r) {
	        Thread thread = defaultFactory.newThread(r);
	        thread.setUncaughtExceptionHandler((t, e) -> {
	            // Handle uncaught exceptions here
	            logger.error("Uncaught exception in thread " + t.getName(), e);
	        });
	        return thread;
	    }
}
