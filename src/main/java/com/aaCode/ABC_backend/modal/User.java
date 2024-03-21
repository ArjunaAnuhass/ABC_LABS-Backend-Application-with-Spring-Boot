package com.aaCode.ABC_backend.modal;

import com.aaCode.ABC_backend.dto.AuthenticationRequest;
import com.aaCode.ABC_backend.dto.RegisterRequest;
import com.aaCode.ABC_backend.dto.TestRequest;
import com.aaCode.ABC_backend.modal.enums.Role;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((role.name())));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public RegisterRequest getUserDto(){
        RegisterRequest registerRequest = new RegisterRequest();

        registerRequest.setId(id);
        registerRequest.setFirstname(firstname);
        registerRequest.setLastname(lastname);
        registerRequest.setEmail(email);
        registerRequest.setPassword(password);

        return registerRequest;
    }
}
