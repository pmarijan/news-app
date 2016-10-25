package si.primoz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;

/**
 * Created by pmarijan on 24.10.2016.
 */
//@Configuration
//@EnableWebSecurity
public class WebSecurityConfiguration {// extends WebSecurityConfigurerAdapter {

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//            .antMatchers("/resources/**");
//    }
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests().antMatchers("/webjars/**").permitAll();
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/api/news**", "/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .httpBasic();
//        http.csrf().disable();
//        
//        super.configure(http);
//    }
    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("admin").roles("ADMIN");
//    }
}
