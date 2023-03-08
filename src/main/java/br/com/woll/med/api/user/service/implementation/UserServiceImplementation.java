package br.com.woll.med.api.user.service.implementation;

import br.com.woll.med.api.configuration.JWTService;
import br.com.woll.med.api.user.dto.JWTTokenDto;
import br.com.woll.med.api.user.dto.UserLoginDto;
import br.com.woll.med.api.user.model.User;
import br.com.woll.med.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
  private final AuthenticationManager authenticationManager;
  private final JWTService jwtTokenService;

  @Override
  public JWTTokenDto login(UserLoginDto userLoginDto) {
    UsernamePasswordAuthenticationToken authenticationToken =
        new UsernamePasswordAuthenticationToken(userLoginDto.getUsername(), userLoginDto.getPassword());

    Authentication authentication = authenticationManager.authenticate(authenticationToken);

    String jwtToken = jwtTokenService.generateToken((User) authentication.getPrincipal());

    return new JWTTokenDto(jwtToken);
  }
}
