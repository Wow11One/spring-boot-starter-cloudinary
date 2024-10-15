package com.ukma.edu.spring.boot.starter.cloudinary.config;

import com.cloudinary.Cloudinary;
import com.ukma.edu.spring.boot.starter.cloudinary.service.CloudinaryService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Map;

@AutoConfiguration
@EnableConfigurationProperties(CloudinaryProperties.class)
@ConditionalOnClass(CloudinaryService.class)
public class CloudinaryStarterConfig {

    private final CloudinaryProperties cloudinaryProperties;

    public CloudinaryStarterConfig(CloudinaryProperties cloudinaryProperties) {
        this.cloudinaryProperties = cloudinaryProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public Cloudinary cloudinary() {
        return new Cloudinary(
            Map.of(
                "cloud_name", cloudinaryProperties.cloudName(),
                "api_key", cloudinaryProperties.apiKey(),
                "api_secret", cloudinaryProperties.apiSecret()
            )
        );
    }

    @Bean
    @Primary
    @ConditionalOnMissingBean
    public CloudinaryService cloudinaryService() {
        return new CloudinaryService(cloudinary());
    }

}
