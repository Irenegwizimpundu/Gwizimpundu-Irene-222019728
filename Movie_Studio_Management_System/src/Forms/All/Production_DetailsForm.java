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

import MyProject.Production_Details;

public class Production_DetailsForm implements ActionListener{
JFrame frame;//Production_Details_Id	Budget	Marketing_Location	Production_Start_Line	Production_End_Line
	
	JLabel prdid_lb=new JLabel("Production_Details_Id");
	JLabel bgt_lb=new JLabel("Budget");
	JLabel mktlctn_lb=new JLabel("Marketing_Location");
	JLabel prstlin_lb=new JLabel("Production_Start_Line");
	JLabel prenlin_lb=new JLabel("Production_End_Line");
	
	JTextField prdid_txf=new JTextField();
	JTextField bgt_txf=new JTextField();
	JTextField mktlctn_txf=new JTextField();
	JTextField prstlin_txf=new JTextField();
	JTextField prenlin_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public Production_DetailsForm(){
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
		frame.setTitle("Production Details Form");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.pink);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		prdid_lb.setBounds(10,10,220,30);
		bgt_lb.setBounds(10,50,170,30);
		mktlctn_lb.setBounds(10,90,230,30);
		prstlin_lb.setBounds(10,130,230,30);
		prenlin_lb.setBounds(10,170,230,30);
		
		
		prdid_txf.setBounds(250,10,190,30);
		bgt_txf.setBounds(250,50,190,30);
		mktlctn_txf.setBounds(250,90,190,30);
		prstlin_txf.setBounds(250,130,190,30);
		prenlin_txf.setBounds(250,170,190,30);
		
		
		insert_btn.setBounds(10,240,85,30);
		read_btn.setBounds(110,240,85,30);
		update_btn.setBounds(210,240,85,30);
		delete_btn.setBounds(310,240,85,30);
		
		table.setBounds(500, 10, 600, 240);
		
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		prdid_lb.setFont(font);
		bgt_lb.setFont(font);
		mktlctn_lb.setFont(font);
		prstlin_lb.setFont(font);
		prenlin_lb.setFont(font);
		
		
		prdid_txf.setFont(font);
		bgt_txf.setFont(font);
		mktlctn_txf.setFont(font);
		prstlin_txf.setFont(font);
		prenlin_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(prdid_lb);
		frame.add(bgt_lb);
		frame.add(mktlctn_lb);
		frame.add(prstlin_lb);
		frame.add(prenlin_lb);
		
		
		frame.add(prdid_txf);
		frame.add(bgt_txf);
		frame.add(mktlctn_txf);
		frame.add(prstlin_txf);
		frame.add(prenlin_txf);
		
		
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Production_Details pd=new Production_Details();
		if(e.getSource()==insert_btn) {
			
			pd.setBgt(bgt_txf.getText());
			pd.setMktlctn(mktlctn_txf.getText());
			pd.setPrstlin(prstlin_txf.getText());
			pd.setPrenlin(prenlin_txf.getText());
		    pd.insertData();
			
		}
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("Production_Details_Id");
            model.addColumn("Budget");
            model.addColumn("Marketing_Location");
            model.addColumn("Production_Start_Line");
            model.addColumn("Production_End_Line");
            
            ResultSet resultSet =Production_Details .viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_btn) {
	    	int id=Integer.parseInt(prdid_txf.getText());
			
			pd.setBgt(bgt_txf.getText());
			pd.setMktlctn(mktlctn_txf.getText());
			pd.setPrstlin(prstlin_txf.getText());
			pd.setPrenlin(prenlin_txf.getText());
			pd.update(id);
	    }
	  else {
			int id=Integer.parseInt(prdid_txf.getText());
			pd.delete(id);}

	  }
		public static void main(String[] args) {
		Production_DetailsForm pdf= new Production_DetailsForm();
  		System.out.println(pdf);

	}
		
	}
