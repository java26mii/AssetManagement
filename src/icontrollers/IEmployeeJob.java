/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.EmployeeJob;

/**
 *
 * @author erik
 */
public interface IEmployeeJob {
    public List<EmployeeJob> getAll();

    public EmployeeJob getById(String id);

    public List<EmployeeJob> search(Object keyword);

    public String save(String Id, String first_name, String last_name,
            String email, String phone_number, String manager,
            String is_delete);
   
    
    public String delete(String id);
}
