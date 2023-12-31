package com.bigodebombado.backend.Controller;

import com.bigodebombado.backend.Model.User.AuthenticationDTO;
import com.bigodebombado.backend.Model.User.LoginResponseDTO;
import com.bigodebombado.backend.Model.User.RegisterDTO;
import com.bigodebombado.backend.Model.User.User;
import com.bigodebombado.backend.Repository.UserRepository;
import com.bigodebombado.backend.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var emailPassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(emailPassword);

        var token = tokenService.generateToken((User)auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (this.userRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User user = new User(data.firstName(), data.lastName(), data.email(), encryptedPassword, data.exp1(), data.empresa1(), data.period1(), data.exp2(), data.empresa2(), data.period2(), data.exp3(), data.empresa3(), data.period3(), data.acaTit1(), data.acaCon1(), data.acaTit2(), data.acaCon2(), data.lan1(), data.lanLv1(), data.lan2(), data.lanLv2(), data.hardSkl1(), data.hardSkl2(), data.hardSkl3(), data.softSkl1(), data.softSkl2(), data.softSkl3());

        this.userRepository.save(user);

        return ResponseEntity.ok().build();
    }
}
