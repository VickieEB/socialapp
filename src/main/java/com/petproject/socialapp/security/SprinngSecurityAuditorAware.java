package com.petproject.socialapp.security;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class SprinngSecurityAuditorAware implements AuditorAware<String> {


    @Override
    public Optional getCurrentAuditor() {

        // TODO:
        //Implement login, use username
        return Optional.ofNullable("VickieEB").filter(s -> !s.isEmpty());
    }
}
