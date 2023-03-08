package br.com.woll.med.api.user.service;

import br.com.woll.med.api.user.dto.JWTTokenDto;
import br.com.woll.med.api.user.dto.UserLoginDto;

public interface UserService {
  JWTTokenDto login(UserLoginDto userLoginDto);
}
