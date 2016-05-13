package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import Manager.UIManager;
/**
 *
 * @author Mathijs, Dennis
 */
public class SysteemUI extends JFrame
{
    private JFrame frame;
    private JPanel navBarPanel, orderedItemPanel, receiptPanel;
    private ArrayList<JPanel> panelList;
    private JTabbedPane menuTabbedPane;
    private UIManager manager;
    
    public SysteemUI()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        frame.setLayout(new BorderLayout());
        frame.setTitle("De Hartige Hap");
        
        panelList = new ArrayList<>();
        
        //Navigation bar with buttons
        frame.add(new NavBarPanel(), BorderLayout.NORTH);
        
        //Menu with categories
        menuTabbedPane = new JTabbedPane();
        menuTabbedPane.add("Voorgerechten", new AppetizerPanel());
        menuTabbedPane.add("HoofdGerechten", new MainCoursePanel());
        menuTabbedPane.add("Nagerechten", new DessertPanel());
        menuTabbedPane.add("Dranken", new DrinkPanel());
        frame.add(menuTabbedPane, BorderLayout.CENTER);
        
        //Menu with list of ordered items
        orderedItemPanel = new JPanel();
        panelList.add(orderedItemPanel);
        add(orderedItemPanel, BorderLayout.CENTER);
        orderedItemPanel.setVisible(false);
        
        frame.pack();
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
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
            private JButton menuButton, orderedItemButton, receiptButton;
            private ArrayList<JButton> navBarButtons;
            
            public NavButtonPanel()
            {
                setLayout(new GridLayout(1, 3));
                
                //Menu buttons
                menuButton = new JButton("Menu");
                menuButton.addActionListener((ActionEvent e) -> {
                    //Change active panel to the menu
                    for(JPanel panel : panelList)
                    {
                        panel.setVisible(false);
                    }
                    menuTabbedPane.setVisible(true);
                });
                
                orderedItemButton = new JButton("Bestelde Gerechten");
                orderedItemButton.addActionListener((ActionEvent e) -> {
                    changePanel(orderedItemPanel);
                });
                
                receiptButton = new JButton("Rekening");
                receiptButton.addActionListener((ActionEvent e) -> {
                   changePanel(receiptPanel);
                });
                
                helpButton = new JButton("?");
                
                //Array with all navbar buttons for styling and adding to the panel
                navBarButtons = new ArrayList<>();
                
                navBarButtons.add(menuButton);
                navBarButtons.add(orderedItemButton);
                navBarButtons.add(receiptButton);
                
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
    
    public void changePanel(JPanel panel)
    {
        //Set every panel to invisible except the given panel;
        for(JPanel panelInList : panelList)
        {
            if(panelInList != panel)
            {
                panelInList.setVisible(false);
            }
        }
        menuTabbedPane.setVisible(false);
        panel.setVisible(true);
    }
}
