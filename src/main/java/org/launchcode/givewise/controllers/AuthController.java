package org.launchcode.givewise.controllers;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/auth")
public class AuthController {
    /*@PostMapping("/loginSubmit")
    public ModelAndView loginSubmit(@RequestParam String username, @RequestParam String password) {
        ModelAndView response = new ModelAndView();
        if (!username.isEmpty() && !password.isEmpty()) {
            response.setViewName("redirect:/home"); ; // Redirect to home page after successful login
            return response;
        } else {
            response.addObject("error", true);
              response.setViewName("redirect:/login"); // Redirect to login page with an error parameter
            return response;
        }

}
*/
    @PostMapping("/home")
    public ModelAndView home() {
        ModelAndView response = new ModelAndView();
            response.setViewName("redirect:/home");
            return response;

    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView response = new ModelAndView();
        response.setViewName("/login");
        return response;
    }
}