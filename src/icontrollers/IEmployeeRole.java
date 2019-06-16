/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import controllers.employeeRoleController;
import java.util.List;
import models.EmployeeRole;

/**
 *
 * @author erik
 */
public interface IEmployeeRole {
    public List<EmployeeRole> getAll();

    public EmployeeRole getById(String id);

    public List<EmployeeRole> search(Object keyword);

    public String save(String id, String employee, String job);
   
    
    public String delete(String id);
}
