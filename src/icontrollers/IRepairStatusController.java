/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Asset;
import models.RepairStatus;

/**
 *
 * @author WINDOWS 10
 */
public interface IRepairStatusController {
        public List<RepairStatus> getAll();

    public RepairStatus getById(String id);

    public List<RepairStatus> search(Object keyword);

    public String save(String id, String status, String repair,
            String dateRepair);
   
    
    public String delete(String id);
}
