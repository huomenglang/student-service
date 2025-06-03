package com.menglang.student.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class AuditorConfig implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        //        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || !authentication.isAuthenticated())
//            return Optional.empty();
//        return Optional.of(authentication.getName());
        return Optional.of("Anonymous");
    }
}
