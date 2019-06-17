/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Asset;
import models.Loaning;
import models.Repair;

/**
 *
 * @author WINDOWS 10
 */
public interface IRepairController {
        public List<Repair> getAll();

    public Repair getById(String id);

    public List<Repair> search(Object keyword);

    public String save(String id, String cost, String note,
            String asset, String employee);
   
    
    public String delete(String id);
}
