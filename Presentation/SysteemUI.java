package Presentation;

import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.JButton;
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
        setVisible(true);
        
        setLayout(new BorderLayout());
        add(new navBarPanel(), BorderLayout.NORTH);
    }
    
    class navBarPanel extends JPanel
    {
        private JButton menuButton, orderedItemButton, billButton, helpButton;
        
        public navBarPanel()
        {
            menuButton = new JButton("Menu");
            orderedItemButton = new JButton("Bestelde Gerechten");
            billButton = new JButton("Rekening");
            helpButton = new JButton("?");
            
            add(menuButton);
            add(orderedItemButton);
            add(billButton);
            add(helpButton);
        }
    }
}
