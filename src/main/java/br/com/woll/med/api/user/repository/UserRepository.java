package br.com.woll.med.api.user.repository;

import br.com.woll.med.api.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
  UserDetails findByUsername(String username);
}
