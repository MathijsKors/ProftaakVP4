package Presentation;

import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Mathijs, Dennis
 */
public class SysteemUI extends JFrame
{
    private JPanel navBarPanel, menuPanel, orderedItemPanel, billPanel;
    
    public SysteemUI()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}
