package com.tarma.auth.config;

public enum UserAuthorities {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("sudent:write"),
    COURSE_WRITE("course:write"),
    COURSE_READ("course:read");

    private final String permission;

    UserAuthorities(String permission) {
        this.permission = permission;
    }

    public String getAuthority() {
        return permission;
    }
}
