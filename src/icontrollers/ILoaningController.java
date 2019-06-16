/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Asset;
import models.Loaning;

/**
 *
 * @author WINDOWS 10
 */
public interface ILoaningController {
        public List<Loaning> getAll();

    public Loaning getById(String id);

    public List<Loaning> search(Object keyword);

    public String save(String id, String loaningDate, String returnDate,
            String note, String asset, String employee);
   
    
    public String delete(String id);
}
