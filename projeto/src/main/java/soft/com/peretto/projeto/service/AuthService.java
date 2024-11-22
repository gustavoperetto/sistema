package soft.com.peretto.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import soft.com.peretto.projeto.dto.AcessDTO;
import soft.com.peretto.projeto.dto.AuthenticationDTO;
import soft.com.peretto.projeto.security.jwt.JwtUtils;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AcessDTO login(AuthenticationDTO authDto) {

        try {
            //Cria mecanismo de credencial para o Spring
            UsernamePasswordAuthenticationToken userAuth =
                    new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());

            // Prepara mecanismo para autenticação
            Authentication authentication = authenticationManager.authenticate(userAuth);

            // Busca usuario logado
            UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            AcessDTO accessDTO = new AcessDTO(token);

            return accessDTO;

        } catch (BadCredentialsException e) {

        }
        return new AcessDTO("Acesso negado");
    }
}
