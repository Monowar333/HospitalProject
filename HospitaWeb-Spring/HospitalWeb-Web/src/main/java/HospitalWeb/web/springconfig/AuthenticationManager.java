/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.web.springconfig;


import HospitalWeb.domain.Users;
import HospitalWeb.service.ODEException;
import HospitalWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 *
 * @author Жека
 */
@Service("userDetailsService")
public class AuthenticationManager implements UserDetailsService {
     @Autowired
    private UserService usersService;



    // this class is used by spring controller to authenticate and authorize user
    @Override
    public UserDetails loadUserByUsername(String login)
                                          throws UsernameNotFoundException {
        System.err.println("auth with username "+login);
        Users user = null;
        System.out.println("service " + usersService);
        try{
            user = usersService.getByLogin(login);
            if(user == null){
                throw new IllegalStateException("user is null");
            }
            System.out.println("user - "+user);
        }catch(ODEException ex){
            throw new BadCredentialsException("such user not found");
        }
        return user;
    }
}
