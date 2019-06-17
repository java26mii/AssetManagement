/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Job;

/**
 *
 * @author erik
 */
public interface IjobController {
    public List<Job> getAll();

    public Job getById(String id);

    public List<Job> search(Object keyword);

    public String save(String id, String name);
   
    
    public String delete(String id);
}
