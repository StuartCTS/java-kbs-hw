
package cloudcode.helloworld.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Defines a controller to handle HTTP requests.
 */
@Controller
public final class HelloWorldController {

@Autowired
private Environment environment;

    /**
     * Create an endpoint for the landing page
     * @return the index view template with a simple message
     */
    @GetMapping("/")
    public String helloWorld(Model model) {
        String javamessage = "Hello from Spring Boot!";
        String msg2 = environment.getProperty("welcome.msg");
        String toolOptions = environment.getProperty("java.tool.options");

        System.out.println("MSG from env property: " + msg2);
        System.out.println("java tool options: " + toolOptions);
        
        model.addAttribute("message", msg2);
        model.addAttribute("javamessage", javamessage);
        return "index";
    }
}
