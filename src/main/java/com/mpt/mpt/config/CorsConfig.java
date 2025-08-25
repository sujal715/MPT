package com.mpt.mpt.config;

<<<<<<< HEAD
import org.springframework.context.annotation.Configuration;
=======
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
>>>>>>> fdcf6fbd346bf74cc21f14886fa500b7f9407bbd
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
<<<<<<< HEAD
                .allowedOriginPatterns("*")  // Use patterns instead of origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(false)  // Set to false to avoid the error
                .maxAge(3600);
    }
=======
                .allowedOrigins(
                    "http://localhost:3000",  // React development server
                    "http://localhost:3001",  // Alternative React port
                    "http://192.168.1.4:3000",  // Your friend's React app on same network
                    "http://192.168.1.4:3001",  // Alternative port on same network
                    "https://brown-rivers-show.loca.lt",  // Public tunnel URL - your friend can use this!
                    "https://*.onrender.com",  // Render deployment URLs
                    "https://*.railway.app",   // Railway deployment URLs
                    "https://your-react-app.netlify.app",  // Your production React app
                    "https://your-react-app.vercel.app"    // Alternative production domain
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList(
            "http://localhost:*",
            "https://*.netlify.app",
            "https://*.vercel.app"
        ));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", configuration);
        return source;
    }
>>>>>>> fdcf6fbd346bf74cc21f14886fa500b7f9407bbd
}
