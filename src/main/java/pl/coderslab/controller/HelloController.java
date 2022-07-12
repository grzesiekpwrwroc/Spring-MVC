package pl.coderslab.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalTime;

import static java.time.LocalTime.of;

@Slf4j
@Controller
public class HelloController {

    @GetMapping("hello")
    @ResponseBody
    public String thisMethodReturnsHelloWorldStringInGetRequest() {
        return "Hello Sunday!";
    }

    @GetMapping("helloView")
    public String helloView(Model model) {
        log.info("Starting helloView generation");
        LocalTime now = LocalTime.now();
        log.debug("Right now is {}", now);
        // LocalTime now = LocalTime.of(21, 0);
        String color, backgroundColor;

        if (now.isAfter(of(8, 0)) && now.isBefore(of(20, 0))) {
            color = "black";
            backgroundColor = "white";
        } else {
            backgroundColor = "black";
            color = "white";
        }
        log.debug("Color is {}, backgroundColor is {}", color, backgroundColor);

        model.addAttribute("color", color);
        model.addAttribute("backgroundColor", backgroundColor);
        log.info("Finish helloView generation");
        return "home";
    }
}
