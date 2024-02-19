package Formmenus;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Forms.All.ActorsForm;
import Forms.All.DirectorsForm;
import Forms.All.Film_InformationForm;
import Forms.All.Financial_Management;
import Forms.All.Production_DetailsForm;


public class MenuForm extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu Actorsmenu;
    private JMenu Directorsmenu;
    private JMenu Film_Informationmenu;
    private JMenu Financial_Nanagementmenu;
    private JMenu Production_Detailsmenu;
    private JMenu Logoutmenu;
    
    public MenuForm() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem ActorsItem;
    private JMenuItem DirectorsItem;
    private JMenuItem Film_InformationItem;
    private JMenuItem Financial_NanagementItem;
    private JMenuItem Production_DetailsItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public MenuForm(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        Actorsmenu = new JMenu("Actors");
        Directorsmenu = new JMenu("Directors");
        Film_Informationmenu= new JMenu("Film_Information");
        Financial_Nanagementmenu = new JMenu("Financial_Management");
        Production_Detailsmenu = new JMenu("Production_Details");
       
        Logoutmenu = new JMenu("Logout");
        		

        // Create menu items
        menuBar.add(Actorsmenu);
        ActorsItem = new JMenuItem("ActorsForm");
        ActorsItem.addActionListener(this);
        
        menuBar.add(Directorsmenu);
        DirectorsItem = new JMenuItem("DirectorsForm");
        DirectorsItem.addActionListener(this);
        
        menuBar.add(Film_Informationmenu);
        Film_InformationItem = new JMenuItem("Film_InformationForm");
        Film_InformationItem.addActionListener(this);
        
        menuBar.add(Financial_Nanagementmenu);
        Financial_NanagementItem = new JMenuItem("Financial_NanagementForm");
        Financial_NanagementItem.addActionListener(this);
        
        menuBar.add(Production_Detailsmenu);
        Production_DetailsItem = new JMenuItem("Production_DetailsForm");
        Production_DetailsItem.addActionListener(this);
        

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        Actorsmenu.add(ActorsItem);
        Directorsmenu.add(DirectorsItem);
        Film_Informationmenu.add(Film_InformationItem);
        Financial_Nanagementmenu.add(Financial_NanagementItem);
        Production_Detailsmenu.add(Production_DetailsItem);
        
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ActorsItem) {
            new ActorsForm();
        
        } else if (e.getSource() == DirectorsItem) {
            new DirectorsForm();
        
        } else if (e.getSource() == Film_InformationItem) {
            new Film_InformationForm();
       
        } else if (e.getSource() == Financial_NanagementItem) {
           new Financial_Management();
        
        } else if (e.getSource() == Production_DetailsItem) {
           new Production_DetailsForm();
           
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuForm("TO MOVIE STUDIO MANAGEMENT SYSTEM"));
    }
}


