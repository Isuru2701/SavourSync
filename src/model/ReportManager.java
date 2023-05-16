package model;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.ResultSet;

public class ReportManager {

    public void compileDailyReport() {
        try {
            DBConn db = new DBConn();
            String query = "SELECT * FROM reservation WHERE DATE(start_datetime) = CURDATE();";
            ResultSet reply = db.query(query);

            JasperReport report = JasperCompileManager.compileReport("C:\\Users\\ASUS\\Documents\\Programs\\SavourSync\\src\\model\\reportTemplates\\testReport.jrxml");
            JRResultSetDataSource rsds = new JRResultSetDataSource(reply);
            JasperPrint print = JasperFillManager.fillReport(report, null, rsds);
            JasperViewer.viewReport(print, false);

        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void compileWeekDayReport() {

    }

    public void compileCanceledReport() {

    }
}
