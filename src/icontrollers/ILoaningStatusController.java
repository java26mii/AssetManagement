/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Asset;
import models.LoaningStatus;
import models.RepairStatus;

/**
 *
 * @author WINDOWS 10
 */
public interface ILoaningStatusController {
        public List<LoaningStatus> getAll();

    public LoaningStatus getById(String id);

    public List<LoaningStatus> search(Object keyword);

    public String save(String id,String dateLoaning, String loaning, String status);
   
    
    public String delete(String id);
}
