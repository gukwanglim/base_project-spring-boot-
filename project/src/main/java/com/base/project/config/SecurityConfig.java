package com.base.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration            // bean 등록(IoC 관리)
@EnableWebSecurity        // 시큐리티 필터 등록 = 스프링 시큐리티가 활성화 되었는데 어떤 설정을 해당 파일에서 하겠다.
@EnableGlobalMethodSecurity(prePostEnabled = true)  // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다
public class SecurityConfig {

    // 회원가입 시 password를 해쉬로 변경
    @Bean   // 함수가 return 하는 값을 spring이 관리(IoC)
    public BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()        // csrf 토큰 비활성화(테스트 시 걸어두는게 좋음)
            .authorizeRequests()     // request가 들어오면
                .antMatchers("/auth/**", "/js/**", "/css/**", "/image/**")   // 그것이 /auth/**의 경로를 가지고 있을 경우
                .permitAll()             // 접근을 허용한다
                .anyRequest()            // 이것이 아닌 다른 요청의 경우는
                .authenticated()         // 인증(로그인)이 되어야 한다
            .and()
                .formLogin()
                .loginPage("/auth/loginForm")                      // 인증이 필요하다면 이곳으로 간다.
                .loginProcessingUrl("/auth/loginProc")    // 스프링 시큐리티가 해당 주소로 요청오는 login을 가로채서 대신 로그인해준다.
                .defaultSuccessUrl("/");                    // 스프링 시큐리티가 login을 끝내고 해당 주소로 이동
//				.failureUrl("/fail");     // login이 실패하게 되면 해당 주소로 이동

        return http.build();
    }
    
}
