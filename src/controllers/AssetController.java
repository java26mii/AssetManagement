/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IAssetController;
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
import org.hibernate.SessionFactory;

/**
 *
 * @author WINDOWS 10
 */
public class AssetController implements IAssetController{
    
    private IGeneralDAO<Asset> adao;

    public AssetController(SessionFactory factory) {
        adao = new GeneralDAO<>(factory, Asset.class);
    }

    @Override
    public List<Asset> getAll() {
        return adao.getData("");
    }

    @Override
    public Asset getById(String id) {
        return adao.getById(new Long(id));
    }

//    @Override
    public List<Asset> search(Object keyword) {
        return adao.getData(keyword);
    }

    @Override
    public String delete(String id) {
        if (adao.saveOrDelete(new Asset(new Long(id)), true)) {
            return "Data berhasil dihapus";
        } else {
            return "Data gagal dihapus";
        }
    }

    @Override
    public String save(String id, String name, String quantity, String category, String note) {
        String result = "Data gagal disimpan";
        if (adao.saveOrDelete(new Asset(name, new Integer(quantity), category, note), false)) {
            result = "Data berhasil di simpan";
        }
        return result;
    }
}
