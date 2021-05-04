package com.base.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Logback的使用 */
public class UseLogback {
    private static final Logger log = LoggerFactory.getLogger(UseLogback.class);

    /** slf4j支持占位符 */
    public static void placeholder() {
        log.info("{}", "placeholder");
    }

    /** 日志级别(配置文件指定的最小级别) */
    public static void logLevel() {
        log.trace("{}", "trace");
        log.debug("{}", "debug");
        log.info("{}", "info");
        log.warn("{}", "warn");
    }

    public static void main(String[] args) {
        placeholder();
        logLevel();
    }
}
