/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IAccount;
import java.util.List;
import models.Account;
import models.Employee;
import org.hibernate.SessionFactory;
import tools.BCrypt;


/**
 *
 * @author erik
 */
public class AccountController implements IAccount{

    private GeneralDAO<Account> dAO;
    
    public AccountController(SessionFactory factory) {
        dAO = new GeneralDAO(factory, Account.class);
    }

    @Override
    public List<Account> getAll() {
        return dAO.getData("");
    }

    @Override
    public Account getById(String id) {
        return dAO.getById(new Long(id));
    }

    @Override
    public List<Account> search(Object keyword) {
        return dAO.getData(keyword);
    }
    
    @Override
    public String save(String id, String username, String password) {
        String result = "Failed";
        String pass = this.hash(password);
        Account account = new Account(new Long(id), username, pass, new Character('1'));
        if (dAO.saveOrDelete(account, false)) {
            result = "Success";
        }

        return result;
    }
    

    @Override
    public String delete(String id) {
        String result = "Failed";
        Account account = new Account(new Long(id));
        if (dAO.saveOrDelete(account, true)) {
            result = "Success";
        }

        return result;
    }
    
    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public String login(String acc, String password) {
        String result = "NO such account";
        String hashed = "";
        if (!acc.contains("@")) {
            Account account = dAO.getAccount(acc);
            if (account != null) {
                
                hashed = String.valueOf(account.getPassword());

                boolean cekPassword = BCrypt.checkpw(password, hashed);

                if (cekPassword) {
                    result = "Login Success";
                } else {
                    result = "Wrong Password";
                }

            } else {
                result = "Username is wrong";
            }

        } else {
            Employee employee = dAO.getEmployee(acc);
            if (employee != null) {
                Account account = dAO.getById(employee.getId());
                hashed = String.valueOf(account.getPassword());

                boolean cekPassword = BCrypt.checkpw(password, hashed);

                if (cekPassword) {
                    result = "Login Success";
                } else {
                    result = "Wrong Password";
                }

            } else {
                result = "Email is wrong";
            }

        }

        return result;
    }

    @Override
    public Account getAccount(String username) {
        return dAO.getAccount(username);
    }

    @Override
    public Employee getEmployee(String email) {
        return dAO.getEmployee(email);
    }
    
   

    
}
