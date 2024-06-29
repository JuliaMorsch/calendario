//configura o CORS

package com.julia.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //classe de configuração do Spring 
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000/") // Permite requisições do endereço passado como parametro.
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite os metodos listados.
                .allowedHeaders("*")
                .allowCredentials(true);
    }
    
}
