package de.kersten.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple get Controller to print hello world (just for setup testing)
 *
 * @author Andre Kersten
 */

@RestController
public class HelloWorldController {

    @GetMapping("helloWorld")
    public String helloWorld() {
        return "Hello World";
    }
}
