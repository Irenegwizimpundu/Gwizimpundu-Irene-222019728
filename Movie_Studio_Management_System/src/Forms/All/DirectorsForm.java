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

import MyProject.Directors;

public class DirectorsForm implements ActionListener{
	JFrame frame;//Director_Id	Names	Telephone	Email	
	JLabel dirctid_lb=new JLabel("Director_Id");
	JLabel name_lb=new JLabel("Names");
	JLabel phone_lb=new JLabel("Telephone");
	JLabel email_lb=new JLabel("Email");
	
	JTextField dirctid_txf=new JTextField();
	JTextField name_txf=new JTextField();
	JTextField phone_txf=new JTextField();
	JTextField email_txf=new JTextField();

	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public DirectorsForm(){
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
		frame.setTitle("DIRECTORS FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.pink);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		dirctid_lb.setBounds(10,10,130,30);
		name_lb.setBounds(10,50,130,30);
		phone_lb.setBounds(10,90,150,30);
		email_lb.setBounds(10,130,200,30);
		
		
		dirctid_txf.setBounds(150,10,190,30);
		name_txf.setBounds(150,50,190,30);
		phone_txf.setBounds(150,90,190,30);
		email_txf.setBounds(150,130,190,30);
		
     
		insert_btn.setBounds(10,220,85,30);
		read_btn.setBounds(110,220,85,30);
		update_btn.setBounds(210,220,85,30);
		delete_btn.setBounds(310,220,85,30);
		
		table.setBounds(500, 10, 600, 240);
		
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		dirctid_lb.setFont(font);
		name_lb.setFont(font);
		phone_lb.setFont(font);
		email_lb.setFont(font);
		
		dirctid_txf.setFont(font);
		name_txf.setFont(font);
		email_txf.setFont(font);
		phone_txf.setFont(font);
		
	
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(dirctid_lb);
		frame.add(name_lb);
		frame.add(phone_lb);
		frame.add(email_lb);
		
		
		frame.add(dirctid_txf);
		frame.add(name_txf);
		frame.add(phone_txf);
		frame.add(email_txf);
		
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Directors cst=new Directors();
		if(e.getSource()==insert_btn) {
			
			cst.setName(name_txf.getText());
			cst.setPhone(phone_txf.getText());
			cst.setEmail(email_txf.getText());
		
			cst.insertData();
			
		}
		
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("Director_Id");
            model.addColumn("Names");
            model.addColumn("Telephone");
            model.addColumn("Email");
            
           
            ResultSet resultSet =Directors.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(dirctid_txf.getText());
			
			cst.setName(name_txf.getText());
			cst.setPhone(phone_txf.getText());
			cst.setEmail(email_txf.getText());
			
			cst.update(id);
	    }
	  else {
			int id=Integer.parseInt(dirctid_txf.getText());
			cst.delete(id);}

	  }
      public static void main(String[] args) {
    	  DirectorsForm dctf= new DirectorsForm();
  		System.out.println(dctf);


	}

	}


