/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IAssetController;
import icontrollers.IRoleController;
import icontrollers.IStatusController;
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
import models.Status;
import org.hibernate.SessionFactory;

/**
 *
 * @author WINDOWS 10
 */
public class StatusController implements IStatusController{
    
    private IGeneralDAO<Status> sdao;

    public StatusController(SessionFactory factory) {
        sdao = new GeneralDAO<>(factory, Status.class);
    }

    @Override
    public List<Status> getAll() {
        return sdao.getData("");
    }

    @Override
    public Status getById(String id) {
        return sdao.getById(new Integer(id));
    }

//    @Override
    public List<Status> search(Object keyword) {
        return sdao.getData(keyword);
    }

    @Override
    public String delete(String id) {
        if (sdao.saveOrDelete(new Status(new Long(id)), true)) {
            return "Data berhasil dihapus";
        } else {
            return "Data gagal dihapus";
        }
    }

    @Override
    public String save(String id, String name) {
        String result = "Data gagal disimpan";
        if (sdao.saveOrDelete(new Status(new Long(id), name, new Character('0')), false)) {
            result = "Data berhasil di simpan";
        }
        return result;
    }
}
