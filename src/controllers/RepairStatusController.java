/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IAssetController;
import icontrollers.IRepairStatusController;
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
import models.Repair;
import models.RepairStatus;
import models.Status;
import org.hibernate.SessionFactory;

/**
 *
 * @author WINDOWS 10
 */
public class RepairStatusController implements IRepairStatusController {

    Date date = new Date(); // this object contains the current date value 
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private IGeneralDAO<RepairStatus> rsdao;

    public RepairStatusController(SessionFactory factory) {
        rsdao = new GeneralDAO<>(factory, RepairStatus.class);
    }

    @Override
    public List<RepairStatus> getAll() {
        return rsdao.getData("");
    }

    @Override
    public RepairStatus getById(String id) {
        return rsdao.getById(new Long(id));
    }

//    @Override
    public List<RepairStatus> search(Object keyword) {
        return rsdao.getData(keyword);
    }

    @Override
    public String delete(String id) {
        if (rsdao.saveOrDelete(new RepairStatus(new Long(id)), true)) {
            return "Data berhasil dihapus";
        } else {
            return "Data gagal dihapus";
        }
    }

    @Override
    public String save(String id, String status, String repair, String dateRepair) {
        String result = "Data gagal disimpan";
        try {
            date = formatter.parse(dateRepair);
            if (rsdao.saveOrDelete(new RepairStatus(Long.parseLong(id), new Status(Long.parseLong(id)),
                    new Repair(Long.parseLong(id)), new java.sql.Date(date.getTime())), false)) {
                result = "Data berhasil di simpan";
            }
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
