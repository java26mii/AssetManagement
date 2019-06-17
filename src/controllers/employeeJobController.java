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
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author erik
 */
public class employeeJobController implements IEmployeeJob{
    private GeneralDAO<EmployeeJob> dAO;
    
    public employeeJobController(SessionFactory factory) {
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
    public String save(String id, String employee, String job) {
        String result = "Data gagal disimpan";
        if (dAO.saveOrDelete(new EmployeeJob(new Long (id), new Employee(Long.parseLong(employee)), new Job(Long.parseLong(job))), false)) {
            result = "Data berhasil di simpan";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "Failed";
        if (dAO.saveOrDelete(new EmployeeJob(new Long(id)), true)) {
        result = "success";
    }
        return result;
    }
}
