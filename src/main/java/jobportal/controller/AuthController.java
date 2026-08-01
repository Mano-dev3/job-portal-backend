package jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jobportal.dto.LoginDTO;
import jobportal.dto.UserDTO;
import jobportal.entity.User;
import jobportal.service.UserService;

@RestController
@CrossOrigin(origins = "*")  
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User register(@RequestBody UserDTO dto) {
        return service.register(dto);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) {
        return service.login(dto);
    }
}