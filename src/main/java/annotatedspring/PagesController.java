package annotatedspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {
    @RequestMapping("/about/")
    public String about() {
        return "about";
    }

    @RequestMapping("/resources/")
    public String resources() {
        return "resources";
    }

}
