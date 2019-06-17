/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import idaos.IGeneralDAO;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Employee;
import models.Job;
import org.hibernate.SessionFactory;
import icontrollers.IEmployee;

/**
 *
 * @author WINDOWS 10
 */
public class EmployeeController implements IEmployee{
    
    
    Date date = new Date(); // this object contains the current date value 
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private IGeneralDAO<Employee> gdao;

    public EmployeeController(SessionFactory factory) {
        gdao = new GeneralDAO<>(factory, Employee.class);
    }

    @Override
    public List<Employee> getAll() {
        return gdao.getData("");
    }

    @Override
    public Employee getById(String id) {
        return gdao.getById(new Integer(id));
    }

//    @Override
    public List<Employee> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String delete(String id) {
        if (gdao.saveOrDelete(new Employee(new Long(id)), true)) {
            return "Data berhasil dihapus";
        } else {
            return "Data gagal dihapus";
        }
    }

    @Override
    public String save(String id, String firstName, String lastName, String email, String phoneNumber, String manager) {
        String result = "Data gagal disimpan";
        if (gdao.saveOrDelete(new Employee(new Long(id), firstName, lastName, email, new Long(phoneNumber), new Employee(new Long(manager)), new Character('0')), false)) {
            result = "Data berhasil di simpan";
        }
        return result;
    }
//    gdao.saveOrDelete(new Employee(Long.parseLong(Id), firstName, lastName, email, phoneNumber,
//                new Employee(Long.parseLong(manager)), false
}
