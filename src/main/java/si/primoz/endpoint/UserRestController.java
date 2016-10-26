package si.primoz.endpoint;

import java.security.Principal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pmarijan
 */
@RestController
public class UserRestController {
    
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
