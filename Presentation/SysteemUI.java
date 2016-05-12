package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
/**
 *
 * @author Mathijs, Dennis
 */
public class SysteemUI extends JFrame
{
    private JPanel navBarPanel, orderedItemPanel, billPanel;
    private JTabbedPane menuTabbedPane;
    
    public SysteemUI()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        setLayout(new BorderLayout());
        setTitle("De Hartige Hap");
        
        //Navigation bar with buttons
        add(new NavBarPanel(), BorderLayout.NORTH);
        
        //Menu with categories
        menuTabbedPane = new JTabbedPane();
        menuTabbedPane.add("Voorgerechten", new AppetizerPanel());
        menuTabbedPane.add("HoofdGerechten", new MainCoursePanel());
        menuTabbedPane.add("Nagerechten", new DessertPanel());
        menuTabbedPane.add("Dranken", new DrinkPanel());
        add(menuTabbedPane, BorderLayout.CENTER);
        
        pack();
        setExtendedState(Frame.MAXIMIZED_BOTH);
    }
    
    class NavBarPanel extends JPanel
    {   
        private JButton helpButton;
        
        public NavBarPanel()
        {
            setLayout(new BorderLayout());
            setBackground(Color.white);
            
            add(new NavButtonPanel(), BorderLayout.WEST);
            
            add(helpButton, BorderLayout.EAST);
        }
        
        class NavButtonPanel extends JPanel
        {
            private JButton menuButton, orderedItemButton, billButton;
            private ArrayList<JButton> navBarButtons;
            
            public NavButtonPanel()
            {
                setLayout(new GridLayout(1, 3));
                
                //Menu buttons
                menuButton = new JButton("Menu");
                orderedItemButton = new JButton("Bestelde Gerechten");
                orderedItemButton.addActionListener((ActionEvent e) -> {
                    
                });
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
    
    class AppetizerPanel extends JPanel
    {
        public AppetizerPanel()
        {
            setBackground(Color.red);
        }
    }
    
    class MainCoursePanel extends JPanel
    {
        public MainCoursePanel()
        {
            setBackground(Color.blue);
        }
    }
    
    class DessertPanel extends JPanel
    {
        public DessertPanel()
        {
            setBackground(Color.green);
        }
    }
    
    class DrinkPanel extends JPanel
    {
        public DrinkPanel()
        {
            setBackground(Color.yellow);
        }
    }
}
