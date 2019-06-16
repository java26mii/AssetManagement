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
public interface IAccount {
    public List<Account> getAll();

    public Account getById(String id);

    public String save(String id, String username, String password);
       
    public String delete(String id);
}
