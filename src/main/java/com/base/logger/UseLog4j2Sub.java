package com.base.logger;

public class UseLog4j2Sub extends UseLog4j2 {
    public static void main(String[] args) {
        UseLog4j2Sub sub = new UseLog4j2Sub();
        sub.logger3.info("子类直接使用");
    }
}
