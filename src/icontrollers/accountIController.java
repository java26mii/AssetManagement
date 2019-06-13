/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;
import java.util.List;
import models.Account;
/**
 *
 * @author erik
 */
public interface accountIController {
    public boolean Validasi(Object keyword,boolean isId);
    
    public String register (String id, String username, String password);
    
    public String login(String username, String password);
}
