package soft.com.peretto.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soft.com.peretto.projeto.dto.AuthenticationDTO;
import soft.com.peretto.projeto.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDto) {
        return ResponseEntity.ok(authService.login(authDto));
    }
}
