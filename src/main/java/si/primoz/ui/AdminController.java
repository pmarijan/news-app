package si.primoz.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pmarijan
 */
//@Controller
public class AdminController {
    
//    @RequestMapping("/admin")
    String index() {
        return "index";
    }
}
