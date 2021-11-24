package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;


@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    //need a controller method to show the initial form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
    	return "helloworld";
    }

    // add a controller method to read from form data
    //add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        //read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        //convert the data to all CAPS
        theName = theName.toUpperCase();

        //create the message
        String result = "Yo! " + theName;

        //add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){

        //convert the data to all CAPS
        theName = theName.toUpperCase();

        //create the message
        String result = "Hey My Friend from V3! " + theName;

        //add message to the model
        model.addAttribute("message", result);

        return "helloworld";

    }

}
