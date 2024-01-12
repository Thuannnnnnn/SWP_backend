package com.swp391.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class CustomOAuth2User implements OAuth2User {

    private final Map<String, Object> attributes;
    private final Collection<? extends GrantedAuthority> authorities;
    private final String name;
    private final String email;
    private final String pictureUrl;

    public CustomOAuth2User(Map<String, Object> attributes, Collection<? extends GrantedAuthority> authorities) {
        this.attributes = attributes;
        this.authorities = authorities;
        this.name = (String) attributes.get("name");
        this.email = (String) attributes.get("email");
        this.pictureUrl = (String) attributes.get("picture");
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getName() {
        return name;
    }

    // Các getter khác nếu cần

    public String getEmail() {
        return email;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }
}
