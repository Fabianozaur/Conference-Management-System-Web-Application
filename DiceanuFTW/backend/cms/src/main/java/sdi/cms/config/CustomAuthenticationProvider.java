package sdi.cms.config;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sdi.cms.dto.AuthenticatedUserDto;
import sdi.cms.model.participant.Role;
import sdi.cms.model.participant.User;
import sdi.cms.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;

    public AuthenticatedUserDto doAuthenticate(final Authentication authentication) {
        authenticate(authentication);

        return AuthenticatedUserDto
            .builder()
            .email(SecurityContextHolder.getContext().getAuthentication().getName())
            .role(
                Role.valueOf(
                    SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getAuthorities()
                        .stream()
                        .map(Object::toString)
                        .findFirst()
                        .orElseThrow()
                )
            )
            .build();
    }

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        final String email = authentication.getName();
        final String password = authentication.getCredentials().toString();

        final Optional<User> user = userRepository.findByEmail(email);

        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            final List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.get().getRole().toString()));

            final Authentication auth = new UsernamePasswordAuthenticationToken(email, password, authorities);
            SecurityContextHolder.getContext().setAuthentication(auth);

            return auth;
        } else {
            throw new BadCredentialsException("Invalid credentials.");
        }
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}