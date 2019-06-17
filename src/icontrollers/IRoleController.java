/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Asset;
import models.Role;

/**
 *
 * @author WINDOWS 10
 */
public interface IRoleController {
        public List<Role> getAll();

    public Role getById(String id);

    public List<Role> search(Object keyword);

    public String save(String id, String name);
   
    
    public String delete(String id);
}
