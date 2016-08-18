/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.Validate;

import HospitalWeb.domain.Users;
import java.io.Serializable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Жека
 */
public class UsersValidateDate extends Users implements Serializable{
    private String confirmPassword;
    private Integer idspecializationInt;

    public UsersValidateDate() {
    }

    public Integer getIdspecializationInt() {
        return idspecializationInt;
    }

    public void setIdspecializationInt(Integer idspecializationInt) {
        this.idspecializationInt = idspecializationInt;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
