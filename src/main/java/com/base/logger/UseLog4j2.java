package com.base.logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** 使用Log4j2 */
public class UseLog4j2 {
    private static final Log logger = LogFactory.getLog(UseLog4j2.class);
    private static final Logger logger2 = LogManager.getLogger(UseLog4j2.class);

    // 子类可以直接使用(见UseLog4j2Sub)
    protected final Log logger3 = LogFactory.getLog(getClass());

    /** log4j2支持占位符，jcl不支持 */
    public static void placeholder() {
        logger2.info("{}", "placeholder");
    }
    /** 打印异常栈 */
    public static void logWithException() {
        try {
            Integer.parseInt("s");
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    public static void main(String[] args) {
        placeholder();
        logWithException();
        logger.error("jcl+log4j");
        logger.info("jcl+log4j");
        logger2.info("log4j");
    }
}
