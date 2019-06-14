/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import idaos.IGeneralDAO;
import models.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.BCrypt;
import tools.HibernateUtil;

/**
 *
 * @author erik
 */
public class AccountregisterloginController {
    private IGeneralDAO<Account> igdao;
    private Session session;
    
    private Transaction transaction;
    SessionFactory factory = HibernateUtil.getSessionFactory();

    public AccountregisterloginController(SessionFactory factory) {
        igdao = new GeneralDAO(factory, Account.class);
    }

    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String register(String id, String username, String password) {
        String result = "";
        String pass = hash(password);
        Account account = new Account(Integer.parseInt(id), username, pass);
        if (igdao.saveOrDelete(account, false)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

    public String login(String username, String password) {
        String result = "";
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT password FROM Account WHERE username ='"+username+"'");
        String hashed = (String) query.uniqueResult();
        
        boolean cekpassword = BCrypt.checkpw(password, hashed);
        if (!Validasi(username, false) || !Validasi(username, true) ) {
            if (cekpassword) {
                result = "Login Successfull";
            } else {
                result = "Login Unsuccessfull, Password Wrong";
            }
        } else {
            result = "Login Unsuccessfull, Username Wrong";
        }
        return result;
    }

    public boolean Validasi(Object keyword, boolean isId) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        String hql = "SELECT COUNT(*) FROM Account WHERE ";
        if (isId) {
            hql += "id = " + keyword;
        } else {
            hql += "username = '" + keyword + "'";
        }
        try {
            Query query = session.createQuery(hql);
            Long count = (Long) query.uniqueResult();
//            System.out.println(count);
            if (count != 1) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return result;
    }

}
