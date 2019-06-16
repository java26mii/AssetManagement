/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IEmployeeRole;
import java.util.List;
import models.Employee;
import models.EmployeeRole;
import models.Role;
import org.hibernate.SessionFactory;

/**
 *
 * @author erik
 */
public class EmployeeRoleController implements IEmployeeRole{
    private GeneralDAO<EmployeeRole> dAO;
    
    public EmployeeRoleController(SessionFactory factory) {
        dAO = new GeneralDAO(factory, EmployeeRole.class);
    }

    @Override
    public List<EmployeeRole> getAll() {
        return dAO.getData("");
    }

    @Override
    public EmployeeRole getById(String id) {
        return dAO.getById(id);
    }

    @Override
    public List<EmployeeRole> search(Object keyword) {
        return dAO.getData(keyword);
    }

    @Override
    public String save(String id, String employee, String role) {
        String result = "Data gagal disimpan";
        if (dAO.saveOrDelete(new EmployeeRole(new Long(id), new Employee(Long.parseLong(employee)), 
                new Role(Long.parseLong(role))), false)) {
            result = "Data berhasil di simpan";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "Failed";
        if (dAO.saveOrDelete(new EmployeeRole(new Long(id)), true)) {
        }
        return result="success";
    }    
}
