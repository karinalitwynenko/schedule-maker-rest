package com.schedulemaker.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@Data
@Builder
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String username;
    private String password;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Schedule> scheduleSet;

    public User() { }

    @JsonCreator
    User(@JsonProperty("id") final long id,
         @JsonProperty("username") final String username,
         @JsonProperty("password") final String password,
         Set<Schedule> scheduleSet) {
        super();
        this.id = id;
        this.username = requireNonNull(username);
        this.password = requireNonNull(password);
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return password;
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
}
