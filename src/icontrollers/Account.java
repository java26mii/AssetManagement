/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;
import models.Account;

/**
 *
 * @author erik
 */
public interface Account {
    public String save(String Id, String username, String password);
   
    
    public String delete(String id);
}
