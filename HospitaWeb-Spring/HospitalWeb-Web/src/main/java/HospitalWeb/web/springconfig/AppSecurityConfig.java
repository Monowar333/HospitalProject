/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.web.springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
/**
 *
 * @author Жека
 */
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends  WebSecurityConfigurerAdapter{
    @Autowired
    UserDetailsService userdatailsservise;
    
        @Autowired
         public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
             DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
             provider.setPasswordEncoder(new ShaPasswordEncoder());
             provider.setUserDetailsService(userdatailsservise);
            auth.authenticationProvider(provider);
            System.out.println(provider.getUserCache());
         }
         
         @Override
	protected void configure(HttpSecurity http) throws Exception {
             System.out.println("loginnnnn");
           http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('admin')")
                .anyRequest().permitAll()
                .and();
// 
//                http.csrf().disable();
//		http.authorizeRequests()
//				.antMatchers("/*").access("hasRole('admin')")
//				.and().formLogin()
//                        .defaultSuccessUrl("/users", false);

                 http.formLogin()
                // указываем страницу с формой логина
                .loginPage("/**")
                // указываем action с формы логина
                .loginProcessingUrl("/**/j_spring_security_check")
                // указываем URL при неудачном логине
                .failureUrl("/StartPage")
                // Указываем параметры логина и пароля с формы логина
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                // даем доступ к форме логина всем
                .permitAll();
 
        http.logout()
                // разрешаем делать логаут всем
                .permitAll()
                // указываем URL логаута
                .logoutUrl("/**/logout")
                // указываем URL при удачном логауте
                .logoutSuccessUrl("/StartPage")
                // делаем не валидной текущую сессию
                .invalidateHttpSession(true);
        
        
        }
    
}

