package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
        setVisible(true);
        
        setLayout(new BorderLayout());
        setTitle("De Hartige Hap");
        
        add(new navBarPanel(), BorderLayout.NORTH);
        
        pack();
        setExtendedState(Frame.MAXIMIZED_BOTH);
    }
    
    class navBarPanel extends JPanel
    {   
        private JButton helpButton;
        
        public navBarPanel()
        {
            setLayout(new BorderLayout());
            
            add(new navButtonPanel(), BorderLayout.WEST);
            
            add(helpButton, BorderLayout.EAST);
        }
        
        class navButtonPanel extends JPanel
        {
            private JButton menuButton, orderedItemButton, billButton;
            private ArrayList<JButton> navBarButtons;
            
            public navButtonPanel()
            {
                //Menu buttons
                menuButton = new JButton("Menu");
                orderedItemButton = new JButton("Bestelde Gerechten");
                billButton = new JButton("Rekening");
                helpButton = new JButton("?");
                
                //Array with all navbar buttons for styling and adding to the panel
                navBarButtons = new ArrayList<>();
                
                navBarButtons.add(menuButton);
                navBarButtons.add(orderedItemButton);
                navBarButtons.add(billButton);
                
                for(JButton button : navBarButtons)
                {
                    button.setMargin(new Insets(10, 10, 10, 10));
                    add(button);
                }
            }
        }
    }
}
