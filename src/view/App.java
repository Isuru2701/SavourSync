/*
 * Created by JFormDesigner on Sat May 13 06:17:56 IST 2023
 */

package view;

import java.awt.*;
import javax.swing.*;

/**
 * @author ASUS
 */
public class App {
    public App() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - isuru Yahampath
        App = new JFrame();

        //======== App ========
        {
            App.setTitle("SavourSync");
            App.setPreferredSize(new Dimension(1000, 750));
            var AppContentPane = App.getContentPane();
            AppContentPane.setLayout(null);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < AppContentPane.getComponentCount(); i++) {
                    Rectangle bounds = AppContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = AppContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                AppContentPane.setMinimumSize(preferredSize);
                AppContentPane.setPreferredSize(preferredSize);
            }
            App.pack();
            App.setLocationRelativeTo(App.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        App.setVisible(true);
        App.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        App.setLocation(20, 20);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    private JFrame App;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
