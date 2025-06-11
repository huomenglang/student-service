package com.menglang.student.config;

import com.menglang.student.model.audit.AuditAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AuditorConfig  {

    @Bean
    public AuditorAware<String> AuditAwareBean(){
        return new AuditAwareImpl();
    }
}
