package controller;

import model.ReportManager;
import net.sf.jasperreports.swing.JRViewer;
import view.ReportView;

/**
 * Controller for ReportView
 * <br>
 * interaction logic with view and model for generating reports
 *
 */
public class ReportController extends AbstractController{

    private ReportView view;
    private ReportManager model;

    public ReportController(ReportView view){
        this.view = view;
        model = new ReportManager();
    }

    public JRViewer dailyReport(){
        return model.compileDailyReport();
    }

    public JRViewer canceledReport(){
        return model.compileCanceledReport();
    }

}
