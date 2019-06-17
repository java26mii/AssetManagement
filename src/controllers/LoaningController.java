/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IAssetController;
import icontrollers.ILoaningController;
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
import org.hibernate.SessionFactory;

/**
 *
 * @author WINDOWS 10
 */
public class LoaningController implements ILoaningController {

    private IGeneralDAO<Loaning> lodao;
    Date date = new Date(); // this object contains the current date value 
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    public LoaningController(SessionFactory factory) {
        lodao = new GeneralDAO<>(factory, Loaning.class);
    }

    @Override
    public List<Loaning> getAll() {
        return lodao.getData("");
    }

    @Override
    public Loaning getById(String id) {
        return lodao.getById(new Long(id));
    }

//    @Override
    public List<Loaning> search(Object keyword) {
        return lodao.getData(keyword);
    }

    @Override
    public String delete(String id) {
        if (lodao.saveOrDelete(new Loaning(new Long(id)), true)) {
            return "Data berhasil dihapus";
        } else {
            return "Data gagal dihapus";
        }
    }

    @Override
    public String save(String id, String loaningDate, String returnDate, String note, String asset, String employee) {
        String result = "Data gagal disimpan";
        try {
//            date = formatter.parse(loaningDate);
//            date = formatter.parse(returnDate);
            if (lodao.saveOrDelete(new Loaning(Long.parseLong(id), new java.sql.Date(formatter.parse(loaningDate).getTime()),
                   new java.sql.Date(formatter.parse(returnDate).getTime()), note, new Asset(Long.parseLong(id)),
                    new Employee(Long.parseLong(id)), new Character('0')), false)) {
                result = "Data berhasil di simpan";
            }
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
