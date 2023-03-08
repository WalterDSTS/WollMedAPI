package br.com.woll.med.api.user.controller;

import br.com.woll.med.api.user.dto.JWTTokenDto;
import br.com.woll.med.api.user.dto.UserLoginDto;
import br.com.woll.med.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/login")
public class AuthenticationController {
  private final UserService userService;

  @PostMapping("/user-data")
  public ResponseEntity login(@RequestBody @Valid UserLoginDto userLoginDto) {
    JWTTokenDto response = userService.login(userLoginDto);

    return ResponseEntity.ok(response);
  }
}
