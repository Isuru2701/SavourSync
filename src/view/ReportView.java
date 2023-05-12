package view;
import javax.swing.*;

public class ReportView extends AbstractView{

    public ReportView() {
        initComponents();
    }

    @Override
    public void initComponents() {
        add(new JLabel("Report"));
    }
}
