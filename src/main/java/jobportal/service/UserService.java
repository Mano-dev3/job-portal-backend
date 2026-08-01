package jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jobportal.dto.LoginDTO;
import jobportal.dto.UserDTO;
import jobportal.entity.Role;
import jobportal.entity.User;
import jobportal.repository.UserRepository;
import jobportal.security.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private BCryptPasswordEncoder encoder; // 🔐 inject encoder

    public User register(UserDTO dto) {

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        // 🔐 encrypt password
        user.setPassword(encoder.encode(dto.getPassword()));

        user.setRole(Role.valueOf(dto.getRole()));

        return repo.save(user);
    }

    @Autowired
    private JwtUtil jwtUtil;

    public String login(LoginDTO dto) {

        User user = repo.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // 🔐 return token instead of user
        return jwtUtil.generateToken(user.getEmail());
    }
    
}