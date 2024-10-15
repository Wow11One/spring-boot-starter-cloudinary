package com.ukma.edu.spring.boot.starter.cloudinary.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties("spring.cloudinary")
public record CloudinaryProperties(
    @DefaultValue("cloud")
    String cloudName,
    String apiKey,
    String apiSecret
) {}
