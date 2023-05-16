package model;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperDesignViewer;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class ReportManager {

    //as the app could be placed anywhere, fetch the dir path to cal abs path
    private String directory = System.getProperty("user.dir");

    public JRViewer compileDailyReport() {

        try {
            DBConn db = new DBConn();
            String query = "SELECT * FROM reservation WHERE DATE(start_datetime) = CURDATE();";
            ResultSet reply = db.query(query);

            InputStream input = new FileInputStream(new File(directory + "\\src\\model\\reportTemplates\\DayReport.jrxml"));

            JasperDesign jd = JRXmlLoader.load(input);

            JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(reply);

            JasperReport report = JasperCompileManager.compileReport(jd);

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("Table", resultSetDataSource);

            JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
            JRViewer viewer = new JRViewer(print);
            viewer.setZoomRatio(0.5f);

            return viewer;

        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }


    public JRViewer compileCanceledReport() {
        try{
            DBConn db = new DBConn();
            String query = "SELECT * FROM canceled WHERE DATE(start_datetime) = CURDATE();";
            ResultSet reply = db.query(query);

            InputStream input = new FileInputStream(new File(directory + "\\src\\model\\reportTemplates\\Cancelled.jrxml"));

            JasperDesign jd = JRXmlLoader.load(input);

            JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(reply);

            JasperReport report = JasperCompileManager.compileReport(jd);

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("Table", resultSetDataSource);

            JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
            JRViewer viewer = new JRViewer(print);
            viewer.setZoomRatio(0.5f);

            return viewer;

        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }

    }
}
