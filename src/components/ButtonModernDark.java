package components;

import javax.swing.plaf.metal.MetalButtonUI;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class ButtonModernDark extends MetalButtonUI {

    @Override
    protected Color getDisabledTextColor() {
        return new ColorUIResource(Color.LIGHT_GRAY);
    }

    // Override the default button foreground color (text color)
    @Override
    protected Color getSelectColor() {
        return new ColorUIResource(Color.WHITE);
    }

    // Override the default button border color
    @Override
    protected Color getFocusColor() {
        return new ColorUIResource(Color.GRAY);
    }
}
