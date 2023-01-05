import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;
import java.sql.*;
public class DataManagerSQL extends JFrame implements ActionListener{
	SQLCODE code = new SQLCODE();
        Sql_warnings SQW = new Sql_warnings();
        Connection conn = null;
        Statement Statement = null;
	int c=0;
        int cr = 0;
	JTextField name = null;
	JTextField mark1 = null;
	JTextField mark2 = null;
	JTextField reg_no = null;
	JTextField Grade = null;
	JTextField mark3 = null;
	JRadioButton edit = null;
	JRadioButton add = null;
	JRadioButton display = null;
	JRadioButton custom = null;
        JRadioButton Rank = null;
	JTextField command = null;
	JTextArea  status = null;
	ButtonGroup radio_buttons = null;
	JButton add_button = null;	
	JButton search_button = null;
	JButton edit_button = null;
	JButton display_button = null;
	JButton command_button = null;
	JButton fetch = null;
	JLabel label = null;
	JLabel title = null;
        JTextArea ResultArea = null;
	String NAME;
	String M1;
	String GRADE;
	String M3;
	String REG_NO;
	String M2;
	String SQL_Command;
DataManagerSQL(){
		setTitle("DATA DUCK");
		setSize(1400,730);
		getContentPane().setBackground(Color.DARK_GRAY);
		setLayout(null);
		setVisible(true);
		radio_buttons = new ButtonGroup();
		command = new JTextField("ADD SQL COMMANDS");command.setVisible(false);
		edit = new JRadioButton("EDIT");
		add = new JRadioButton("ADD");
		display = new JRadioButton("DISPLAY");
		custom = new JRadioButton("CUSTOM COMMAND");
                Rank = new JRadioButton("RANK LIST");
		edit.setBackground(Color.MAGENTA);
		add.setBackground(Color.MAGENTA);
		display.setBackground(Color.MAGENTA);
                Rank.setBackground(Color.MAGENTA);
		custom.setBackground(Color.MAGENTA);
		name = new JTextField("Enter name"); 
		name.setVisible(false);
		mark1 = new JTextField("Enter mark1"); 
		mark1.setVisible(false);
		mark2 = new JTextField("Enter mark2");
		mark2.setVisible(false);
		reg_no = new JTextField("Enter Reg No"); 
		reg_no.setVisible(false);
		Grade = new JTextField("Enter Grade"); 
		Grade.setVisible(false);
		mark3 = new JTextField("Enter mark3"); 
		mark3.setVisible(false);
		add_button = new JButton("ADD"); 
		add_button.setVisible(false);
		edit_button = new JButton("EDIT");
		edit_button.setVisible(false);
		display_button = new JButton("GO");
		display_button.setVisible(false);
		search_button = new JButton("SEARCH");
		search_button.setVisible(false);
		label = new JLabel("DATABASE MANAGER (lite)");
		title = new JLabel("DATA DUCK");
		status = new JTextArea("STATUS \n",8,9);
                ResultArea = new JTextArea("OUTPUT \n",9,10);
                ResultArea.setVisible(false);
		status.setBackground(Color.LIGHT_GRAY);
                ResultArea.setBackground(Color.LIGHT_GRAY);
		title.setIcon(new ImageIcon("title.png"));
		label.setIcon(new ImageIcon("icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		title.setBounds(500,30,191,53);
		label.setBounds(900,50,364,629);
		edit.setBounds(100,100,250,50);
		add.setBounds(100,180,250,50);
		display.setBounds(100,260,250,50);
		custom.setBounds(100,340,250,50);
                Rank.setBounds(100, 420, 250,50);
		reg_no.setBounds(600,100,250,40);
		name.setBounds(600,150,250,40);
		mark1.setBounds(600,200,250,40);
		command.setBounds(600,100,250,40);
		mark2.setBounds(600,250,250,40);
		mark3.setBounds(600,300,250,40);
		Grade.setBounds(600,350,250,40);
		add_button.setBounds(600,400,100,40);
		edit_button.setBounds(600,400,100,40);
		display_button.setBounds(600,400,100,40);
		search_button.setBounds(600,400,100,40);
		status.setBounds(100, 500, 500, 100);
		status.setEditable(false);
                ResultArea.setBounds(500,180,300,200);
                ResultArea.setEditable(false);
		edit.addActionListener(this);
		add.addActionListener(this);
		display.addActionListener(this);
		custom.addActionListener(this);
                Rank.addActionListener(this);
		edit_button.addActionListener(this);
		search_button.addActionListener(this);
		display_button.addActionListener(this);
		add_button.addActionListener(this);
		edit_button.setBackground(Color.ORANGE);
		search_button.setBackground(Color.ORANGE);
		display_button.setBackground(Color.ORANGE);
		add_button.setBackground(Color.ORANGE);
		add(add_button); 
		add(name);
		add(mark1);
		add(reg_no);
		add(mark2);
		add(mark3);
		add(Grade);
		add(status);
		add(edit); 
		add(add);
		add(display);
		add(custom);
                add(Rank);
		add(command);
		add(title);
		add(label);
		add(add_button);
		add(edit_button);
		add(display_button);
		add(search_button);
		add(ResultArea);
		radio_buttons.add(edit);
		radio_buttons.add(add);
		radio_buttons.add(display);
		radio_buttons.add(custom);
                radio_buttons.add(Rank);
}
public void actionPerformed(ActionEvent ae){
	try{
		if(ae.getSource() == add){ //add
			name.setVisible(true);
			mark1.setVisible(true);
			reg_no.setVisible(true);
			mark2.setVisible(true);
			mark3.setVisible(true);
			Grade.setVisible(false);
			add_button.setVisible(true);
			reg_no.setText("Add reg.no ");
			command.setVisible(false);
			display_button.setVisible(false);
                        ResultArea.setVisible(false);
		}
		else if(ae.getSource() == edit){ //edit
			name.setVisible(true);
			mark1.setVisible(true);
			reg_no.setText("Enter reg.no to edit Details");
			reg_no.setVisible(true); // reg no to edit
			mark2.setVisible(true);
			mark3.setVisible(true);
			Grade.setVisible(false);
			add_button.setVisible(false);
			edit_button.setVisible(true);
			command.setVisible(false);
			display_button.setVisible(false);
                        ResultArea.setVisible(false);
		}
		else if(ae.getSource() == display){ // SEARCH
			name.setVisible(false);
			mark1.setVisible(false);
			reg_no.setText("Enter reg.no to Display Details");
			display_button.setVisible(false);
			reg_no.setVisible(true); // reg no to edit
			mark2.setVisible(false);
			edit_button.setVisible(false);
			mark3.setVisible(false);
			Grade.setVisible(false);
			add_button.setVisible(false);
			command.setVisible(false);
			search_button.setVisible(true);
                        ResultArea.setVisible(true);
		}
		else if(ae.getSource() == custom){
			name.setVisible(false);
			mark1.setVisible(false);
			reg_no.setVisible(false);
			mark2.setVisible(false);
			mark3.setVisible(false);
			Grade.setVisible(false);
			add_button.setVisible(false);
			display_button.setVisible(true);
			command.setVisible(true);
			search_button.setVisible(false);
                        ResultArea.setVisible(true);
                        edit_button.setVisible(false);
		}
		else{
			name.setVisible(false);
			mark1.setVisible(false);
			reg_no.setVisible(false);
			mark2.setVisible(false);
			mark3.setVisible(false);
			Grade.setVisible(false);
			add_button.setVisible(false);
			command.setVisible(false);
			edit_button.setVisible(false);
			display_button.setVisible(false);
			search_button.setVisible(false);
                        ResultArea.setVisible(true);
		}
		if(ae.getSource() == edit_button){ 
			try{
				NAME = name.getText();
				M1 = mark1.getText();
				REG_NO = reg_no.getText().strip();
				GRADE = Grade.getText();
				M3 = mark3.getText();
				M2 = mark2.getText();
                                String a;
                                double mark1 = code.convert_to_double(M1);
                                double mark2 = code.convert_to_double(M2);
                                double mark3 = code.convert_to_double(M3);
                                if(mark1+mark2+mark3 > 300){
                                    a = null;
                                }
                                else{
                                    a = code.Edit_data(REG_NO, M1, M2, M3);
                                }
                                if(a == null){
                                    status.append("DATA NOT EDITED!! \n CHECK VALUES AGAIN \n");
                                }
                                else{
                                    status.append("DATA  EDITED\n");
                                }
			}
			catch(Exception E){
				status.append(" ***** ERROR ***** \n"+E);
                                status.append(SQL_Command);
                                name.setVisible(true);
                                mark1.setVisible(true);
                                reg_no.setText("Enter reg.no to edit Details");
                                reg_no.setVisible(true); // reg no to edit
                                mark2.setVisible(true);
                                mark3.setVisible(true);
                                Grade.setVisible(false);
			}
			status.append(SQL_Command);
			name.setVisible(true);
			mark1.setVisible(true);
			reg_no.setText("Enter reg.no to edit Details");
			reg_no.setVisible(true); // reg no to edit
			mark2.setVisible(true);
			mark3.setVisible(true);
			Grade.setVisible(false);
			add_button.setVisible(false);
			edit_button.setVisible(true);
			command.setVisible(false);
			display_button.setVisible(false);
                        ResultArea.setVisible(false);
		}
		else if(ae.getSource() == add_button){
			try{
			NAME = name.getText();
			M1 = mark1.getText();
			REG_NO = reg_no.getText().strip();
			M3 = mark3.getText();
			M2 = mark2.getText();
                        String a;
                        double mark1 = code.convert_to_double(M1);
                        double mark2 = code.convert_to_double(M2);
                        double mark3 = code.convert_to_double(M3);
                        if(mark1+mark2+mark3 >300){
                            a = null;
                            status.append("MAX MARK = 100 \n");
                        }
                        else{
                            a = code.Add_data(REG_NO, NAME, M1, M2, M3);
                        }
                        if(a==null){
                            status.append("DATA NOT ADDED !!\n+ Check Values Again \n");
                        }
                        else{
                            status.append("DATA ADDED \n");
                        }
		}
		catch(java.lang.NumberFormatException E){
			status.append(" ***** ERROR ***** \n"+E);
		}
			status.append(SQL_Command);
			add_button.setVisible(true);
			name.setVisible(true);
			mark1.setVisible(true);
			reg_no.setVisible(true);
			mark2.setVisible(true);
			mark3.setVisible(true);
			Grade.setVisible(false);
			add_button.setVisible(true);
			reg_no.setText("Add reg.no ");
			command.setVisible(false);
			display_button.setVisible(false);
                        ResultArea.setVisible(false);
		}
		else if(ae.getSource() == search_button){ // handles display
                        ResultArea.selectAll();
                        status.replaceSelection(" ");
			status.append("OUTPUT\n");
			REG_NO = reg_no.getText();
			search_button.setVisible(true);
			display.setVisible(true);
			reg_no.setVisible(true);
                        try{
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENTS","root","--------------");
                        Statement = conn.createStatement();
                        ResultSet rs = Statement.executeQuery("SELECT * FROM StudentInfo WHERE Reg_no = '"+REG_NO+"' ;");
                        while(rs.next())
                            ResultArea.append(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getString(6)+"\n");
                        }
                        catch(SQLException E){
                            System.out.println(""+E);
                            status.append(E+"\n");
                            E.printStackTrace();
                            return;
                        }
                        catch(Exception E){
                            status.append(E+"\n");
                        }
		}

		else if(ae.getSource()== display_button){
			SQL_Command = command.getText();
			status.append(SQL_Command+"\n");
			display_button.setVisible(true);
			command.setVisible(true);
                        ResultArea.setVisible(true);
                        ResultArea.append(" ********** OUTPUT ********** \n");
                        int sts = SQW.Check_Warning(SQL_Command);
                        switch(sts){
                        case 2:
                            try{
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENTS","root","--------------");
                                Statement = conn.createStatement();
                                ResultSet rs = Statement.executeQuery(SQL_Command);
                                while(rs.next())
                                    ResultArea.append(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getString(6)+"\n");
                                    cr++;
                                }
                                catch(SQLException E){
                                    System.out.println(""+E);
                                    status.append(E+"\n");
                                    E.printStackTrace();
                                    return;
                                }
                                catch(Exception E){
                                    status.append(E+"\n"); c++;
                                }
                                break;
                        case 1:
                            try{
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENTS","root","--------------");
                                Statement = conn.createStatement();
                                Statement.executeQuery(SQL_Command);
                                }
                                catch(SQLException E){
                                    System.out.println(""+E);
                                    status.append(E+"\n");
                                    E.printStackTrace();
                                    return;
                                }
                                catch(Exception E){
                                    status.append(E+"\n");
                                } 
                                break;
                        case 0:
                            status.append("ILLEGAL COMMAND!! \n");
                            c++;
                            break;
        }
		}
                if(ae.getSource() == Rank){
                    ResultArea.append(" ********** RANK LIST ********** \n");
                    cr++;
                    try{
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENTS","root","--------------");
                            Statement = conn.createStatement();
                            ResultSet rs = Statement.executeQuery("SELECT Reg_no,Name,SUM(mark_1+mark_2+mark_3) FROM StudentInfo GROUP BY Reg_no  ORDER BY SUM(mark_1+mark_2+mark_3) DESC ");
                            while(rs.next())
                                ResultArea.append(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+"\n");
                                cr++;
                            }
                            catch(SQLException E){
                                System.out.println(""+E);
                                status.append(E+"\n");
                                E.printStackTrace();
                                return;
                            }
                            catch(Exception E){
                                status.append(E+"\n"); c++;
                            }
                }
		if(ae.getSource() != null){
			status.append("--->>: "+ae +"\n");
			c++;
			if(c>3){
				status.selectAll();
				status.replaceSelection("");
				status.append("STATUS\n");
				c=0;
			}
		}
                if(c>2){
				status.selectAll();
				status.replaceSelection("");
				status.append("STATUS\n");
				c=0;
               }
               if(cr > 4){
                   ResultArea.selectAll();
                   ResultArea.replaceSelection(" ");
                   cr = 0;
               }
	}
	catch(Exception E){
		System.out.println(" ***** ERROR ***** "+E);
	}	
	}
public static void main(String ar[]){
	SwingUtilities.invokeLater(new Runnable(){
		public void run(){
			new DataManagerSQL();
		}
	});
	}
}

// SQL HANDLING CLASS

class SQLCODE{
    String query;
    String Grade;
    public double convert_to_double(String m){
        double mark = Double.parseDouble(m);
        return mark;
    }
public String Generate_grade(double m1, double m2, double m3){
        double avg;
        String Grade;
        avg = ((m1+m2+m3)/300)*100;
        if(avg <101 && avg > 90){
            Grade = "A+";
        }
        else if(avg <90 && avg > 80){
            Grade = "A";
        }
        else if(avg <80 && avg > 70){
            Grade = "B+";
        }
        else if(avg <70 && avg > 60){
            Grade = "B";
        }
        else if(avg <60 && avg > 50){
            Grade = "c+";
        }
        else if(avg <50 && avg > 40){
            Grade = "c";
        }
        else if(avg <40 && avg > 30){
            Grade = "d";
        }
        else{
            Grade = "F";
        }
        return Grade;
    }
    public String Edit_data(String Reg_no, String m1, String m2, String m3)throws ClassNotFoundException{
    Connection conn = null;
    Statement command = null;
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENTS","root","--------------");
        command = conn.createStatement();
        double ma1 = convert_to_double(m1);
        double ma2 = convert_to_double(m2);
        double ma3 = convert_to_double(m3);
        String Grade = Generate_grade(ma1, ma2, ma3);
        String SQl_command = "UPDATE StudentInfo SET mark_1 = "+m1+",mark_2 = "+m2+",mark_3 ="+m3+", grade = '"+Grade+"' WHERE Reg_no = '"+Reg_no+"';";
        command.executeUpdate(SQl_command);
        return SQl_command;
    }
     catch(SQLException E){
        System.out.println(""+E);
        E.printStackTrace();
        return null;
    }
    catch(Exception E){
        System.out.println(E);
        return null;
    }
    }
    public String Add_data(String Reg_no, String Name, String m1, String m2, String m3)throws ClassNotFoundException{
        Connection conn = null;
        Statement command = null;
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENTS","root","--------------");
        command = conn.createStatement();
        double ma1 = convert_to_double(m1);
        double ma2 = convert_to_double(m2);
        double ma3 = convert_to_double(m3);
        Grade = Generate_grade(ma1, ma2, ma3);
        String SQl_command = "INSERT INTO StudentInfo (Reg_no, Name, mark_1, mark_2, mark_3, grade) VALUES ("+"'"+Reg_no+"',"+"'"+Name+"'"+","+m1+","+m2+","+m3+","+"'"+Grade+"'"+");";
        System.out.println(SQl_command);
        int a = command.executeUpdate(SQl_command);
        if(a == 1){
            return "DATA ADDED!! \n";
        }
        else{
            return "FAILED TO ADD DATA!! \n";
        }
    }
    catch(SQLException E){
        System.out.println(""+E);
        E.printStackTrace();
        return null;
    }
    catch(Exception E){
        System.out.println(E);
        return null;
    }
    }
} 

// SQL WARNINGS CLASS

class Sql_warnings{
    public int Check_Warning(String Query){
        Query = Query.toLowerCase().strip();
        if(Query.contains("delete")){
            return 0;
        }
        else if(Query.contains("drop")){
            return 0;
        }
        else if(Query.contains("alter")){
            return 0;
        }
        else if(Query.contains("select")){
            return 2;
        }
        else{
            return 1;
        }
    }
}
