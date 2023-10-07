package spring.security.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {


//    @Bean
//            public UserDetailsService userDetailsService(){
//
//        UserDetails user1 = User.withDefaultPasswordEncoder()
//
//                .username("root")
//                .password("123")
//                .roles("IT")
//                .build();
//
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//
//
//        UserDetails user = users
//                .username("user")
//                .password("123")
//                .roles("EMPLOYEE")
//                .build();
//
//
//        UserDetails hr = users
//                .username("hr")
//                .password("123")
//                .roles("HR")
//                .build();
//
//
//        UserDetails manager = users
//                .username("manager")
//                .password("123")
//                .roles("MANAGER", "HR")
//                .build();
//
//
//        return new InMemoryUserDetailsManager(user, hr, manager, user1);
//    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((user) -> user
                .requestMatchers(new AntPathRequestMatcher("/")).hasAnyRole("HR", "MANAGER", "IT", "EMPLOYEE")
                .requestMatchers(new AntPathRequestMatcher("/manager-info/**")).hasRole("MANAGER")
                .requestMatchers(new AntPathRequestMatcher("/hr-info/**")).hasRole("HR")
                .anyRequest().authenticated()
        ).formLogin(Customizer.withDefaults());


        return http.build();
    }

}