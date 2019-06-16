/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IAssetController;
import icontrollers.IRoleController;
import idaos.IGeneralDAO;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Asset;
import models.Employee;
import models.Job;
import models.Role;
import org.hibernate.SessionFactory;

/**
 *
 * @author WINDOWS 10
 */
public class RoleController implements IRoleController{
    
    private IGeneralDAO<Role> rdao;

    public RoleController(SessionFactory factory) {
        rdao = new GeneralDAO<>(factory, Role.class);
    }

    @Override
    public List<Role> getAll() {
        return rdao.getData("");
    }

    @Override
    public Role getById(String id) {
        return rdao.getById(new Long(id));
    }

//    @Override
    public List<Role> search(Object keyword) {
        return rdao.getData(keyword);
    }

    @Override
    public String delete(String id) {
        if (rdao.saveOrDelete(new Role(new Long(id)), true)) {
            return "Data berhasil dihapus";
        } else {
            return "Data gagal dihapus";
        }
    }

    @Override
    public String save(String id, String name) {
        String result = "Data gagal disimpan";
        if (rdao.saveOrDelete(new Role(new Long(id), name, new Character('0')), false)) {
            result = "Data berhasil di simpan";
        }
        return result;
    }
}
