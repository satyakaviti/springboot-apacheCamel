package com.satyacode.components;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component //enables springboot to scan initiate and inject them
public class SimpleTimer extends RouteBuilder {
    /**
     * referred documentatin :https://camel.apache.org/components/4.10.x/timer-component.html
     *
     * @throws Exception
     */
    @Override
    public void configure() throws Exception {
        from("timer:simpletimer?period=2000")  //period is frequency with 2sec
                .routeId("simpleTimerId")
                .setBody(constant("Hello world")) //dsl language format sets only message (it takes the body from message and print the message)
                .log(LoggingLevel.INFO, "${body}");

//                .to()
    }
}
