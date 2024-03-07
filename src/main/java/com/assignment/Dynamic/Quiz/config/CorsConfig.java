// package com.assignment.Dynamic.Quiz.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// import jakarta.servlet.http.HttpServletRequest;

// @Configuration
// public class CorsConfig implements CorsConfigurationSource{

//     @Bean
//     public CorsConfigurationSource corsConfigurationSource() {
//         CorsConfiguration configuration = new CorsConfiguration();
//         configuration.setAllowCredentials(true);
//         configuration.addAllowedOrigin("*");  // You might want to specify your frontend URL instead of "*"
//         configuration.addAllowedHeader("*");
//         configuration.addAllowedMethod("*");

//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         source.registerCorsConfiguration("/**", configuration);

//         return source;
//     }

//     @Override
//     public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//       
//         throw new UnsupportedOperationException("Unimplemented method 'getCorsConfiguration'");
//     }
// }
