/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IEmployeeJob;
import java.util.List;
import models.Employee;
import models.EmployeeJob;
import org.hibernate.SessionFactory;

/**
 *
 * @author erik
 */
public class employeeJob implements IEmployeeJob{
    private GeneralDAO<EmployeeJob> dAO;
    
    public employeeJob(SessionFactory factory) {
        dAO = new GeneralDAO(factory, EmployeeJob.class);
    }

    @Override
    public List<EmployeeJob> getAll() {
        return dAO.getData("");
    }

    @Override
    public EmployeeJob getById(String id) {
        return dAO.getById(id);
    }

    @Override
    public List<EmployeeJob> search(Object keyword) {
        return dAO.getData(keyword);
    }

    @Override
    public String save(String Id, String first_name, String last_name, String email, String phone_number, String manager, String is_delete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
