package com.tarma.auth.config;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.tarma.auth.config.UserAuthorities.*;

public enum UserRole {
    STUDENT(Sets.newHashSet()), ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE));

    private final Set<UserAuthorities> permissionSet;

    UserRole(Set<UserAuthorities> permissionSet) {
        this.permissionSet = permissionSet;
    }

    public Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> permissions = permissionSet.stream()
                .map(p->new SimpleGrantedAuthority(p.getAuthority())).collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }
}
