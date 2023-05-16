import model.DBConn;
import net.sf.jasperreports.engine.*;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class ReportTest extends JFrame {

    public static void main(String[] args) {
        try {
            JasperReport jr = JasperCompileManager.compileReport("../src/reportTemplates/testReport.jrxml");

            DBConn db = new DBConn();
            ResultSet reply = db.query("Select * from client");

            JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(reply);


            // Step 3: Set the report parameters (if any)
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("ReportTitle", "Sample Report");

            // Step 4: Fill the report with data and parameters
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr, parameters, resultSetDataSource);

            JasperViewer.viewReport(jasperPrint, true);

        } catch (JRException e) {
            System.out.println(e.getMessage());
        }


    }
}
