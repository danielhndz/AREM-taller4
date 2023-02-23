package edu.escuelaing.arem.microspring;

public class Controllers {

    @RequestMapping("/greeting")
    public static String greeting() {
        return "Greetings from Micro Spring Boot!";
    }
}
