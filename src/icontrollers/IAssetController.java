/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Asset;

/**
 *
 * @author WINDOWS 10
 */
public interface IAssetController {
        public List<Asset> getAll();

    public Asset getById(String id);

    public List<Asset> search(Object keyword);

    public String save(String Id, String name, String quantity,
            String category, String note);
   
    
    public String delete(String id);
}
