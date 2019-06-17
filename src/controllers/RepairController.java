/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IAssetController;
import icontrollers.ILoaningController;
import icontrollers.IRepairController;
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
import models.Loaning;
import models.Repair;
import org.hibernate.SessionFactory;

/**
 *
 * @author WINDOWS 10
 */
public class RepairController implements IRepairController{

    private IGeneralDAO<Repair> redao;
    Date date = new Date(); // this object contains the current date value 
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    public RepairController(SessionFactory factory) {
        redao = new GeneralDAO<>(factory, Repair.class);
    }

    @Override
    public List<Repair> getAll() {
        return redao.getData("");
    }

    @Override
    public Repair getById(String id) {
        return redao.getById(new Long(id));
    }

//    @Override
    public List<Repair> search(Object keyword) {
        return redao.getData(keyword);
    }

    @Override
    public String delete(String id) {
        if (redao.saveOrDelete(new Repair(new Long(id)), true)) {
            return "Data berhasil dihapus";
        } else {
            return "Data gagal dihapus";
        }
    }

    @Override
    public String save(String id, String cost, String note, String asset, String employee) {
        String result = "Data gagal disimpan";
        if (redao.saveOrDelete(new Repair(Long.parseLong(id), Long.parseLong(cost),
                note, new Asset(Long.parseLong(id)), new Employee(Long.parseLong(id)), new Character('0')), false)) {
            result = "Data berhasil di simpan";
        }
        return result;
    }
}
