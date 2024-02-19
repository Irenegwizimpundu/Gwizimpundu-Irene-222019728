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

import MyProject.Financial_Nanagement;

public class Financial_Management implements ActionListener{
	
	JFrame frame;
	JLabel finamgtid_lb=new JLabel("Financial_Mgt_Id");
	JLabel flminfoid_lb=new JLabel("Film_Info_Id");
	JLabel bugt_lb=new JLabel("Budget");
	JLabel expns_lb=new JLabel("Expenses");
	JLabel reven_lb=new JLabel("Revenue");
	JLabel prft_lb=new JLabel("profit");
	
	JTextField finamgtid_txf=new JTextField();
	JTextField flminfoid_txf=new JTextField();
	JTextField bugt_txf=new JTextField();
	JTextField expns_txf=new JTextField();
	JTextField reven_txf=new JTextField();
	JTextField prft_txf=new JTextField();

	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public Financial_Management(){
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
		frame.setTitle("Financial Management Form");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.blue);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		finamgtid_lb.setBounds(10,10,170,30);
		flminfoid_lb.setBounds(10,50,130,30);
		bugt_lb.setBounds(10,90,150,30);
		expns_lb.setBounds(10,130,200,30);
		reven_lb.setBounds(10,170,200,30);
		prft_lb.setBounds(10,210,200,30);
		

		
		finamgtid_txf.setBounds(190,10,190,30);
		flminfoid_txf.setBounds(190,50,190,30);
		bugt_txf.setBounds(190,90,190,30);
		expns_txf.setBounds(190,130,190,30);
		reven_txf.setBounds(190,170,190,30);
		prft_txf.setBounds(190,210,190,30);
		
     
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
		finamgtid_lb.setFont(font);
		flminfoid_lb.setFont(font);
		bugt_lb.setFont(font);
		expns_lb.setFont(font);
		reven_lb.setFont(font);
		prft_lb.setFont(font);
		
		finamgtid_txf.setFont(font);
		flminfoid_txf.setFont(font);
		bugt_txf.setFont(font);
		expns_txf.setFont(font);
		reven_txf.setFont(font);
		prft_txf.setFont(font);
		
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(finamgtid_lb);
		frame.add(flminfoid_lb);
		frame.add(bugt_lb);
		frame.add(expns_lb);
		frame.add(reven_lb);
		frame.add(prft_lb);
		
		
        frame.add(finamgtid_txf);
		frame.add(flminfoid_txf);
		frame.add(bugt_txf);
		frame.add(expns_txf);
		frame.add(reven_txf);
		frame.add(prft_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Financial_Nanagement fmgt=new Financial_Nanagement();
		if(e.getSource()==insert_btn) {
			
			fmgt.setFlninfid(flminfoid_txf.getText());
			fmgt.setBugt(bugt_txf.getText());
			fmgt.setExpns(expns_txf.getText());
			fmgt.setReven(reven_txf.getText());
			fmgt.setPrft(prft_txf.getText());
			
			fmgt.insertData();
			
			
		}
		
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("Financial_Mgt_Id");
            model.addColumn("Film_Info_Id");
            model.addColumn("Budget");
            model.addColumn("Expenses");
            model.addColumn("Revenue");
            model.addColumn("profit");
            
            
            ResultSet resultSet =Financial_Nanagement.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(finamgtid_txf.getText());
			fmgt.setFlninfid(flminfoid_txf.getText());
			fmgt.setBugt(bugt_txf.getText());
			fmgt.setExpns(expns_txf.getText());
			fmgt.setReven(reven_txf.getText());
			fmgt.setPrft(prft_txf.getText());
			fmgt.update(id);
	    }
	  else {
			int id=Integer.parseInt(flminfoid_txf.getText());
			fmgt.delete(id);}

	  }

	public static void main(String[] args) {
		Financial_Management fimgt= new Financial_Management();
	  		System.out.println(fimgt);

	}

}
	


