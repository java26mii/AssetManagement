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
import org.hibernate.SessionFactory;


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
        String result = "Data gagal disimpan";
        if (dAO.saveOrDelete(new Account(new Long(id),username, password,new Character('1')), false)) {
            result = "Data berhasil di simpan";
        }
        return result;
    }
    

    @Override
    public String delete(String id) {
        String result = "Failed";
        if (dAO.saveOrDelete(new Account(new Long(id)), true)) {
        }
        return result="success";
    }    
    
   

    
}
