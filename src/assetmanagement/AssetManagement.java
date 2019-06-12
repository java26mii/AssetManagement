/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assetmanagement;

import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author erik
 */
public class AssetManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
              SessionFactory factory = HibernateUtil.getSessionFactory();
        System.out.println(factory);
    }
    
}
