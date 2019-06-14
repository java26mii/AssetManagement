/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IjobController;
import java.util.List;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author erik
 */
public class jobController implements IjobController{
    private GeneralDAO<Job> jdao;
    
    public jobController(SessionFactory factory) {
        jdao = new GeneralDAO(factory, jobController.class);
    }

    @Override
    public List<Job> getAll() {
        return jdao.getData("");
    }

    @Override
    public Job getById(String id) {
        return jdao.getById(new Long(id));
    }

    @Override
    public List<Job> search(Object keyword) {
        return jdao.getData(keyword);
    }

    @Override
    public String save(String id, String name) {
        String result = "";
        Job job = new Job(new Long(id), name);
        if (jdao.saveOrDelete(job, false)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "Failed";
        if (jdao.saveOrDelete(new Job(new Long(id)), true)) {
            result = "Success";
        }
        return result;
    }
}
