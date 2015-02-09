package ru.hh.slf4jexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class Main {

  private static final Logger log = LoggerFactory.getLogger(Main.class);
  // you can also give custom name LoggerFactory.getLogger("ru.hh.slf4jexample.Main")

  public static void main(String[] args) {

    log.error("error message");
    log.warn("warn message");
    log.info("info message");
    log.debug("debug message");
    log.trace("trace message");

    log.info("message with parameters: parameter1 = {}, parameter2 = {}", 1, "param2");
    // SLOW: log.info(String.format("... %d ... %s", 1, param2));
    log.warn("message with simple exception: attention", new RuntimeException("exception message"));

    final RuntimeException innerException = new RuntimeException("inner exception message");
    final RuntimeException outerException = new RuntimeException("outer exception message", innerException);
    log.warn("message with nested exceptions: attention", outerException);

    log.warn("message with parameters and exception: parameter = {}", 1, new RuntimeException("exception message"));

    MDC.put("requestId", "123");
    MDC.put("userId", "456");
    log.info("message with mdc");
    log.info("another message with mdc");
    MDC.clear();  // do not forget
  }
}
