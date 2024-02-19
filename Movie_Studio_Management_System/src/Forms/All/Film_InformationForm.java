package Forms.All;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import MyProject.Film_Information;
import MyProject.Financial_Nanagement;

public class Film_InformationForm implements ActionListener{
	JFrame frame;//Director_Id	Names	Telephone	Email
	
	JLabel flminfoid_lb=new JLabel("Film_Info_Id");
	JLabel actid_lb=new JLabel("Actor_Id");
	JLabel dirctid_lb=new JLabel("Director_Id");
	JLabel title_lb=new JLabel("Title");
	JLabel duration_lb=new JLabel("Duration");
	JLabel relsdate_lb=new JLabel("Release_Date");
	
	
	JTextField flminfoid_txf=new JTextField();
	JTextField actid_txf=new JTextField();
	JTextField dirctid_txf=new JTextField();
	JTextField title_txf=new JTextField();
	JTextField duration_txf=new JTextField();
	JTextField relsdate_txf=new JTextField();

	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public Film_InformationForm(){
		createForm();
	    }
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		}
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("Film Information Form");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.pink);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		flminfoid_lb.setBounds(10,10,130,30);
		actid_lb.setBounds(10,50,130,30);
		dirctid_lb.setBounds(10,90,150,30);
		title_lb.setBounds(10,130,200,30);
		duration_lb.setBounds(10,170,200,30);
		relsdate_lb.setBounds(10,210,200,30);
		
		
		flminfoid_txf.setBounds(150,10,190,30);
		actid_txf.setBounds(150,50,190,30);
		dirctid_txf.setBounds(150,90,190,30);
		title_txf.setBounds(150,130,190,30);
		duration_txf.setBounds(150,170,190,30);
		relsdate_txf.setBounds(150,210,190,30);
		
     
		insert_btn.setBounds(10,300,85,30);
		read_btn.setBounds(110,300,85,30);
		update_btn.setBounds(210,300,85,30);
		delete_btn.setBounds(310,300,85,30);
		
		table.setBounds(500, 10, 600, 240);
		
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		flminfoid_lb.setFont(font);
		actid_lb.setFont(font);
		dirctid_lb.setFont(font);
		title_lb.setFont(font);
		duration_lb.setFont(font);
		relsdate_lb.setFont(font);
		
		flminfoid_txf.setFont(font);
		actid_txf.setFont(font);
		dirctid_txf.setFont(font);
		title_txf.setFont(font);
		duration_txf.setFont(font);
		relsdate_txf.setFont(font);
		
	
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(flminfoid_lb);
		frame.add(actid_lb);
		frame.add(dirctid_lb);
		frame.add(title_lb);
		frame.add(duration_lb);
		frame.add(relsdate_lb);
		
		frame.add(flminfoid_txf);
		frame.add(actid_txf);
		frame.add(dirctid_txf);
		frame.add(title_txf);
		frame.add(duration_txf);
		frame.add(relsdate_txf);
		
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
		ActionEvent ();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Film_Information fin=new Film_Information();
		if(e.getSource()==insert_btn) {
			
			fin.setActid(actid_txf.getText());
			fin.setDirctid(dirctid_txf.getText());
			fin.setTitle(title_txf.getText());
			fin.setDuration(duration_txf.getText());
			fin.setRelsdate(relsdate_txf.getText());
			
			fin.insertData();
			
		}
		  else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("Film_Info_Id");
            model.addColumn("Actor_Id");
            model.addColumn("Director_Id");
            model.addColumn("Title");
            model.addColumn("Duration");
            model.addColumn("Release_Date");
            
            
            
            ResultSet resultSet =Film_Information.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)
                                , resultSet.getString(6)});
                   }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }}
			
	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(flminfoid_txf.getText());
			fin.setActid(actid_txf.getText());
			fin.setDirctid(dirctid_txf.getText());
			fin.setTitle(title_txf.getText());
			fin.setDuration(duration_txf.getText());
			fin.setRelsdate(relsdate_txf.getText());
			fin.update(id);
	    }
	  else {
			int id=Integer.parseInt(flminfoid_txf.getText());
			fin.delete(id);}
	  }

	public static void main(String[] args) {
		 Film_InformationForm fif= new Film_InformationForm();
	  		System.out.println(fif);

	}

	
		
	}


