package com.base.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** slf4j与logback集成 */
public class SLF4JBinding {
    /** 这句话意思是绑定日志实现的入口 */
    private static final Logger log = LoggerFactory.getLogger(SLF4JBinding.class);

    public static void main(String[] args) {
        if (log.isInfoEnabled()) {
            log.info("slf4j binding logback");
        }
    }
}
