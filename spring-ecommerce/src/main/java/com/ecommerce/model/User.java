package com.ecommerce.model;

import com.ecommerce.config.SimpleGrantedAuthority;
import com.ecommerce.constants.messages.UserExceptionMessages;
import com.ecommerce.exception.UserException;
import jakarta.persistence.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private String address;
    @Column(unique = true)
    private String phoneNumber;

    private List<SimpleGrantedAuthority> authorities;
    @Transient
    private boolean enabled;
    @Transient
    private boolean credentialsNonExpired;
    @Transient
    private boolean accountNonExpired;
    @Transient
    private boolean accountNonLocked;

    public User() {
    }

    public User(Integer id, String name, String username, String password, String email, String address,
                String phoneNumber) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id != null && id <= 0) {
            throw new UserException(UserExceptionMessages.ERROR_USER_INVALID_ID);
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new UserException(UserExceptionMessages.ERROR_USER_INVALID_NAME);
        }
        this.name = name;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null) {
            throw new UserException(UserExceptionMessages.ERROR_USER_INVALID_USERNAME);
        }
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) {
            throw new UserException(UserExceptionMessages.ERROR_USER_INVALID_PASSWORD);
        }
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) {
            throw new UserException(UserExceptionMessages.ERROR_USER_INVALID_EMAIL);
        }
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null) {
            throw new UserException(UserExceptionMessages.ERROR_USER_INVALID_ADDRESS);
        }
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new UserException(UserExceptionMessages.ERROR_USER_INVALID_PHONE_NUMBER);
        }
        this.phoneNumber = phoneNumber;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        return authorities != null ? authorities : new ArrayList<>();
    }

    public void setAuthorities(List<SimpleGrantedAuthority> authorities) {
        if (authorities == null) {
            throw new UserException(UserExceptionMessages.ERROR_USER_INVALID_AUTHORITIES);
        }
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
