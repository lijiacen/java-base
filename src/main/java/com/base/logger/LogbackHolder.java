package com.base.logger;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/** 动态构造logger对象 */
public class LogbackHolder {
    /**
     * 根据名称获取logger实例
     *
     * @param name
     * @return
     */
    public static Logger getLogger(String name) {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        if (loggerContext.exists(name) == null) {
            // 自己构建logger对象
            return buildLogger(name);
        }
        return loggerContext.getLogger(name);
    }

    /**
     * 动态构造log实例
     *
     * @param name
     * @return
     */
    private static Logger buildLogger(String name) {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger logger = loggerContext.getLogger(name);

        // 配置rollingFileAppender
        RollingFileAppender rollingFileAppender = new RollingFileAppender();
        rollingFileAppender.setName(name);
        rollingFileAppender.setContext(loggerContext);

        // 配置rollingPolicy
        TimeBasedRollingPolicy rollingPolicy = new TimeBasedRollingPolicy(); // 依据时间做滚动
        rollingPolicy.setFileNamePattern("tmp/log/" + name + ".%d{yyyyMM}.log");
        rollingPolicy.setParent(rollingFileAppender);
        rollingPolicy.setContext(loggerContext);
        rollingPolicy.start();

        // 配置encoder
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setCharset(StandardCharsets.UTF_8);
        encoder.setPattern("%msg%n");
        encoder.setContext(loggerContext);
        encoder.start();

        rollingFileAppender.setRollingPolicy(rollingPolicy);
        rollingFileAppender.setEncoder(encoder);
        rollingFileAppender.start();

        logger.addAppender(rollingFileAppender);
        logger.setAdditive(false);
        logger.setLevel(Level.INFO);

        return logger;
    }

    public static void main(String[] args) {
        getLogger("li").info("log by self");
    }
}
