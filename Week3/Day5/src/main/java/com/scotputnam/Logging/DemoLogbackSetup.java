package com.scotputnam.Logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoLogbackSetup {

    private static final Logger log = LoggerFactory.getLogger("com.scotputnam.Logging.DemoLogbackSetup");

    static void main(String[] args) {

        log.trace("trace: (this level is below root threshold)");
        log.debug("debug: configuration loaded");
        log.info("info: extra info");
        log.warn("warning: memory low");
        log.error("error: critical error");
        System.out.println("\ncheck logs/demo-logback.log in relative path to see results");

    }
}
