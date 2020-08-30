package com.eobrazovanje.university.security;

import com.eobrazovanje.university.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

public class UserPrincipal implements UserDetails {

    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    private GrantedAuthority authority;

    private Boolean deleted;

    public UserPrincipal() {
    }

    public UserPrincipal(Long id, String username, String password, GrantedAuthority authority, Boolean deleted) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.deleted = deleted;
    }

    public static UserPrincipal create(User user) {

        String role = user.getRole().toString();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);

        return new UserPrincipal(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                simpleGrantedAuthority,
                user.getDeleted()
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public GrantedAuthority getAuthority() {
        return authority;
    }

    public Long getId(){
        return id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
