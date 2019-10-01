/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static org.apache.tomcat.jni.User.username;

/**
 *
 * @author 798125
 */
public class AccountServices {
    
    public User login(String username,String password){
    
        return new User(username,password);
    }
}
