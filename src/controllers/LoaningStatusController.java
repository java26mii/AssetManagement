/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IAssetController;
import icontrollers.ILoaningStatusController;
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
import models.Loaning;
import models.LoaningStatus;
import models.Repair;
import models.RepairStatus;
import models.Status;
import org.hibernate.SessionFactory;

/**
 *
 * @author WINDOWS 10
 */
public class LoaningStatusController implements ILoaningStatusController {

    Date date = new Date(); // this object contains the current date value 
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private IGeneralDAO<LoaningStatus> lsdao;

    public LoaningStatusController(SessionFactory factory) {
        lsdao = new GeneralDAO<>(factory, LoaningStatus.class);
    }

    @Override
    public List<LoaningStatus> getAll() {
        return lsdao.getData("");
    }

    @Override
    public LoaningStatus getById(String id) {
        return lsdao.getById(new Long(id));
    }

//    @Override
    public List<LoaningStatus> search(Object keyword) {
        return lsdao.getData(keyword);
    }

    @Override
    public String delete(String id) {
        if (lsdao.saveOrDelete(new LoaningStatus(new Long(id)), true)) {
            return "Data berhasil dihapus";
        } else {
            return "Data gagal dihapus";
        }
    }

    @Override
    public String save(String id, String dateLoaning, String loaning, String status) {
        String result = "Data gagal disimpan";
        try {
            date = formatter.parse(dateLoaning);
            if (lsdao.saveOrDelete(new LoaningStatus(Long.parseLong(id), new java.sql.Date(date.getTime()),
                    new Loaning(Long.parseLong(id)),
                    new Status(Long.parseLong(id))), false)) {
                result = "Data berhasil di simpan";
            }
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
