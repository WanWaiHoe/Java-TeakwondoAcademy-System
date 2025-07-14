/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class Assignment2 {
    
    static JFrame frame, frame2, frame3, frame4, frame41, frame42, frame5, frame51, frame52, frame53;
    static JTable tblMember, tblAppointment;
    static String member,Gender;
    static Double Payment;
    static JButton btnSearch, btnSearch1;

    public static void main(String[] args) {
       frame = new JFrame("Welcome");
       frame.setSize(350,200);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setLocationRelativeTo(null);
       frame.setLayout(new BorderLayout());
       
       frame2 = new JFrame("Saikyo Teakwondo");
       frame2.setSize(400,350);
       frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame2.setLocationRelativeTo(null);
       frame2.setLayout(new BorderLayout());
       
       frame3 = new JFrame("Register");
       frame3.setSize(500,450);
       frame3.setLocationRelativeTo(null);
       frame3.setLayout(new BorderLayout());
       frame3.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent windowEvent){
                frame2.setVisible(true);
            }
        });
       
       frame4 = new JFrame("Member");
       frame4.setSize(1200,600);
       frame4.setLocationRelativeTo(null);
       frame4.setLayout(new BorderLayout());
       frame4.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent windowEvent){
                frame2.setVisible(true);
            }
        });
       
       frame41 = new JFrame("Delete");
       frame41.setSize(350,170);
       frame41.setLocationRelativeTo(null);
       frame41.setLayout(new BorderLayout());
       
       frame42 = new JFrame("Renew");
       frame42.setSize(350,170);
       frame42.setLocationRelativeTo(null);
       frame42.setLayout(new GridLayout(3,1));
       
       frame5 = new JFrame("Appointment");
       frame5.setSize(500,400);
       frame5.setLocationRelativeTo(null);
       frame5.setLayout(new BorderLayout());
       frame5.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent windowEvent){
                frame2.setVisible(true);
            }
        });
       
       frame51 = new JFrame("Add Appointment");
       frame51.setSize(350,170);
       frame51.setLocationRelativeTo(null);
       frame51.setLayout(new GridLayout(3,1));
       
       frame52 = new JFrame("Remove Appointment");
       frame52.setSize(350,170);
       frame52.setLocationRelativeTo(null);
       frame52.setLayout(new BorderLayout());
       
       frame53 = new JFrame("Delete");
       frame53.setSize(350,170);
       frame53.setLocationRelativeTo(null);
       frame53.setLayout(new BorderLayout());
       
       //start page
       JPanel pnlCtrLG = new JPanel(new GridLayout(2,2,0,15));
       pnlCtrLG.setBorder(new EmptyBorder(25,15,25,15));
       JPanel pnlBtnLG = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       JLabel LGid = new JLabel("User ID: ");
       JLabel LGpw = new JLabel("Password: ");
       
       JTextField LGID = new JTextField(5);
       JPasswordField LGPW = new JPasswordField(5);
       
       JButton btnWlc = new JButton("Log In");
       btnWlc.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               if(LGID.getText().equals("Admin") && LGPW.getText().equals("admin")){
                   frame.setVisible(false);
                   frame2.setVisible(true);
                   LGID.setText("");
                   LGPW.setText("");
               }else{
                   JOptionPane.showMessageDialog(frame, "Please insert correct User ID or password");
               }
           }
       });
       
       JButton btnExt1 = new JButton("Exit");
       btnExt1.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               System.exit(0);
           }
       });
       
       //Menu
       JPanel pnlBtnMenu = new JPanel(new GridLayout(4,1,25,25));
       pnlBtnMenu.setBorder(new EmptyBorder(20,20,20,20));
       
       JButton btnRegister = new JButton("Register");
       btnRegister.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               frame2.setVisible(false);
               frame3.setVisible(true);
           }
       });
       JButton btnMember = new JButton("Check Member");
       btnMember.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               frame2.setVisible(false);
               frame4.setVisible(true);
           }
       });
       JButton btnAppointment = new JButton("Check Appointment");
       btnAppointment.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               frame2.setVisible(false);
               frame5.setVisible(true);
           }
       });
       JButton btnLO = new JButton("Log Out");
       btnLO.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               frame2.setVisible(false);
               frame.setVisible(true);
           }
       });
       
       //Register
       JLabel lblMemberID = new JLabel("Member ID:");
       JLabel lblFN = new JLabel("First Name:");
       JLabel lblLN = new JLabel("Last Name:");
       JLabel lblGender = new JLabel("Gender:");
       JLabel lblRace = new JLabel("Race:");
       JLabel lblArea = new JLabel("Area:");
       JLabel lblContact = new JLabel("Contace Number:");
       JLabel lblEmail = new JLabel("Email Address:");
       
       JTextField txtMemberID = new JTextField(10);
       JTextField txtFN = new JTextField(10);
       JTextField txtLN = new JTextField(10);
       JTextField txtRace = new JTextField(10);
       JTextField txtArea = new JTextField(10);
       JTextField txtContact = new JTextField(10);
       JTextField txtEmail = new JTextField(10);
       
       JRadioButton rdbMale = new JRadioButton("Male");
       JRadioButton rdbFemale = new JRadioButton("Female");
       ButtonGroup grpGender = new ButtonGroup();
       grpGender.add(rdbMale);
       grpGender.add(rdbFemale);
       JPanel pnlGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
       
       JRadioButton rdbMember = new JRadioButton("Normal");
       JRadioButton rdbVIP = new JRadioButton("VIP");
       JRadioButton rdbVVIP = new JRadioButton("VVIP");
       ButtonGroup grpPackage = new ButtonGroup();
       grpPackage.add(rdbMember);
       grpPackage.add(rdbVIP);
       grpPackage.add(rdbVVIP);
       JLabel lblPackage = new JLabel("Package:");
       JPanel pnlPackage = new JPanel(new FlowLayout(FlowLayout.LEFT));
       JPanel pnlCenterRG = new JPanel(new GridLayout(7,2,15,15));
       pnlCenterRG.setBorder(new EmptyBorder(25,20,25,20));
       JPanel pnlTopRG = new JPanel(new FlowLayout(FlowLayout.CENTER));
       JPanel pnlFN = new JPanel(new FlowLayout(FlowLayout.LEFT));
       JPanel pnlLN = new JPanel(new FlowLayout(FlowLayout.LEFT));
       
       JPanel pnlBtnRG = new JPanel(new FlowLayout(FlowLayout.CENTER));
       JButton btnRGSudmit = new JButton("Sudmit");
       btnRGSudmit.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               try{
                   if(rdbMember.isSelected()==true){
                   member = "Normal";
                   Payment = 29.90;
                   }
                   
                   if(rdbVIP.isSelected()==true){
                   member = "VIP";
                   Payment = 39.90;
                   }
                   
                   if(rdbVVIP.isSelected()==true){
                   member = "VVIP";
                   Payment = 49.90;
                   }
                   
                   if(rdbMale.isSelected()==true){
                       Gender = "Male";
                   }
                   
                   if(rdbFemale.isSelected()==true){
                       Gender = "Female";
                   }
                   if(!txtMemberID.getText().equals("")){
                    Connection conn = ConnectionManager.getConnection();
                    String sql = "INSERT INTO `user`(`Member_ID`, `First_Name`, `Last_Name`, `Gender`, `Race`, `Area`, `Contact`, `Email`, `Type`, `Renew_Payment`, `Expire_Date`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, DATE_ADD(now(), INTERVAL 1 MONTH))";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1,txtMemberID.getText());
                    pstmt.setString(2,txtFN.getText());
                    pstmt.setString(3,txtLN.getText());
                    pstmt.setString(4,Gender);
                    pstmt.setString(5,txtRace.getText());
                    pstmt.setString(6,txtArea.getText());
                    pstmt.setString(7,txtContact.getText());
                    pstmt.setString(8,txtEmail.getText());
                    pstmt.setString(9, member);
                    pstmt.setString(10,String.valueOf(Payment));
                    
                    if(member.equals("VIP") || member.equals("VVIP")){
                        Connection conn1 = ConnectionManager.getConnection();
                        String sql1 = "INSERT INTO `appointment`(`Member_ID`, `Type`, `Appointment_Time`) VALUES (? , ?, null);";
                        PreparedStatement pstmt1 = conn1.prepareStatement(sql1);
                        pstmt1.setString(1, txtMemberID.getText());
                        pstmt1.setString(2, member);
                        pstmt1.executeUpdate();
                    }
                    
                    int result = pstmt.executeUpdate();
                    
                    if(result > 0){
                        JOptionPane.showMessageDialog(null,"Register successfully");
                        txtMemberID.setText("");
                        txtFN.setText("");
                        txtLN.setText("");
                        txtRace.setText("");
                        txtArea.setText("");
                        txtContact.setText("");
                        txtEmail.setText("");
                        btnSearch.doClick();
                        btnSearch1.doClick();
                    }
                    }else{
                       JOptionPane.showMessageDialog(null, "Member ID must Insert");
                   }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Member ID( "+txtMemberID.getText()+" )already in used. Please use another customer ID.");
                }
           }
       });
       JButton btnRGCancel = new JButton("Cancel");
       btnRGCancel.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               frame3.setVisible(false);
               frame2.setVisible(true);
           }
       });
       
       //Member
       tblMember = new JTable();
       
       try{
           Connection conn = ConnectionManager.getConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM user");
           DefaultTableModel model = buildTableModel(rs);
           tblMember = new JTable(model);
       }catch(Exception ex){
           
       }
       
       JPanel pnlTopMB = new JPanel(new FlowLayout(FlowLayout.LEFT));
       JLabel lblUFN = new JLabel("First Name: ");
       JLabel lblULN = new JLabel("Last Name: ");
       JLabel lblUT = new JLabel("User Type: ");
       JLabel lblED = new JLabel("Status ");
       JLabel lblUA = new JLabel("Area: ");
       
       JTextField txtUFN = new JTextField(10);
       JTextField txtULN = new JTextField(10);
       JTextField txtUT = new JTextField(10);
       JTextField txtUA = new JTextField(10);
       
       JRadioButton rdbExpire = new JRadioButton("Expire");
       JRadioButton rdbActive = new JRadioButton("Active");
       ButtonGroup grpED = new ButtonGroup();
       grpED.add(rdbExpire);
       grpED.add(rdbActive);
       
       JLabel lblDelete1 = new JLabel("Member ID: ");
       JTextField txtDelete1 = new JTextField(10);
       
       JPanel pnlDeleteCenter = new JPanel(new FlowLayout(FlowLayout.LEFT));
       JPanel pnlDeleteBtm = new JPanel(new FlowLayout(FlowLayout.LEFT));
       JButton btnDelete1 = new JButton("Delete");
       btnDelete1.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               try{
                   Connection conn = ConnectionManager.getConnection();
                   String sql = "DELETE FROM `user` WHERE Member_ID = ?;";
                   PreparedStatement pstmt = conn.prepareStatement(sql);
                   pstmt.setString(1, txtDelete1.getText());
                   int Count = pstmt.executeUpdate();
                   
                   if(Count > 0){
                       JOptionPane.showMessageDialog(null, "Delete Successful");
                       frame41.setVisible(false);
                       txtDelete1.setText("");
                       btnSearch.doClick();
                       btnSearch1.doClick();
                   }else{
                       JOptionPane.showMessageDialog(null, "Invalid Member ID");
                   }
               }catch(Exception ex){
                   
               }
           }});
       
       JButton btnCancel1 = new JButton("Cancel");
       btnCancel1.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               frame41.setVisible(false);
           }
       });
       
       JButton btnRenew = new JButton("Renew");
       btnRenew.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               frame42.setVisible(true);
       }});
       
       JPanel pnlTopRenew = new JPanel(new FlowLayout(FlowLayout.LEFT));
       JPanel pnlCenterRenew = new JPanel(new FlowLayout(FlowLayout.LEFT));
       JPanel pnlBtmRenew = new JPanel(new FlowLayout(FlowLayout.LEFT));
       
       JLabel lblRenew = new JLabel("Member ID: ");
       JTextField txtRenew = new JTextField(10);
       JLabel lblMonth = new JLabel("Month:          ");
       JTextField txtMonth = new JTextField(10);
       JButton btnRenew1 = new JButton("Renew");
       btnRenew1.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               try{
                   Connection conn = ConnectionManager.getConnection();
                   String sql = "UPDATE `user` SET Expire_Date = DATE_ADD(Expire_Date, INTERVAL ? MONTH) WHERE Member_ID = ?";
                   PreparedStatement pstmt = conn.prepareStatement(sql);
                   pstmt.setString(1, txtMonth.getText());
                   pstmt.setString(2, txtRenew.getText());
                   int Count = pstmt.executeUpdate();
                   
                   if(Count>0){
                       JOptionPane.showMessageDialog(null, "Renew Successful");
                       frame42.setVisible(false);
                       txtRenew.setText("");
                       txtMonth.setText("");
                       btnSearch.doClick();
                       btnSearch1.doClick();
                   }else{
                       JOptionPane.showMessageDialog(null, "Invalid Member ID");
                   }
               }catch(Exception ex){
                   
               }
           }
       });
       JButton btnCancel2 = new JButton("Cancel");
       btnCancel2.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               frame42.setVisible(false);
           }
       });
       
       btnSearch = new JButton("Search");
       btnSearch.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               try{
                   Connection conn = ConnectionManager.getConnection();
                   String sql = "SELECT * FROM user WHERE 1 ";
                   int num1 = 0;
                   int num2 = 0;
                   int num3 = 0;
                   int num4 = 0;
                   int num5 = 0;
                   
                   if(!txtUFN.getText().equals("")){
                       sql = sql + "AND First_Name = ?";
                       num1++;
                       num2++;
                       num3++;
                       num4++;
                   }
                   
                   if(!txtULN.getText().equals("")){
                       sql = sql + "AND Last_Name = ?";
                       num2++;
                       num3++;
                       num4++;
                   }
                   
                   if(!txtUT.getText().equals("")){
                       sql = sql + "AND Type = ?";
                       num3++;
                       num4++;
                   }
                   
                   if(!txtUA.getText().equals("")){
                       sql = sql + "AND Area = ?";
                       num4++;
                       num5++;
                   }
                   
                   if(rdbExpire.isSelected()==true){
                       sql = sql + "AND Expire_Date < now();";
                       num5++;
                   }
                   
                   if(rdbActive.isSelected()==true){
                       sql = sql + "AND Expire_Date > now();";
                       num5++;
                   }
                   PreparedStatement pstmt = conn.prepareStatement(sql);
                   if(!txtUFN.getText().equals("")){
                       pstmt.setString(num1, txtUFN.getText());
                   }
                   
                   if(!txtULN.getText().equals("")){
                       pstmt.setString(num2, txtULN.getText());
                   }
                   
                   if(!txtUT.getText().equals("")){
                       pstmt.setString(num3, txtUT.getText());
                   }
                   
                   if(!txtUA.getText().equals("")){
                       pstmt.setString(num4, txtUA.getText());
                   }
                   
                   ResultSet rs = pstmt.executeQuery();
                   tblMember.setModel(buildTableModel(rs));
               }catch(Exception ex){
                   
               }
           }
       });
       
       JButton btnDelete = new JButton("Delete");
       btnDelete.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               frame41.setVisible(true);
           }
       });
       
       //Appointment
       tblAppointment = new JTable();
       
       try{
           Connection conn = ConnectionManager.getConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM appointment");
           DefaultTableModel model = buildTableModel(rs);
           tblAppointment = new JTable(model);
       }catch(Exception ex){
           
       }
       
       btnSearch1 = new JButton("Search");
       btnSearch1.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               try{
                   Connection conn = ConnectionManager.getConnection();
                   String sql = "SELECT * FROM `appointment` WHERE 1";
                   int num1 = 0;
                   int num2 = 0;
                   int num3 = 0;
                   int num4 = 0;
                   int num5 = 0;
                   
                   if(!txtUFN.getText().equals("")){
                       sql = sql + "AND First_Name = ?";
                       num1++;
                       num2++;
                       num3++;
                       num4++;
                   }
                   
                   if(!txtULN.getText().equals("")){
                       sql = sql + "AND Last_Name = ?";
                       num2++;
                       num3++;
                       num4++;
                   }
                   
                   if(!txtUT.getText().equals("")){
                       sql = sql + "AND Type = ?";
                       num3++;
                       num4++;
                   }
                   
                   if(!txtUA.getText().equals("")){
                       sql = sql + "AND Area = ?";
                       num4++;
                       num5++;
                   }
                   
                   if(rdbExpire.isSelected()==true){
                       sql = sql + "AND Expire_Date < now();";
                       num5++;
                   }
                   
                   if(rdbActive.isSelected()==true){
                       sql = sql + "AND Expire_Date > now();";
                       num5++;
                   }
                   PreparedStatement pstmt = conn.prepareStatement(sql);
                   if(!txtUFN.getText().equals("")){
                       pstmt.setString(num1, txtUFN.getText());
                   }
                   
                   if(!txtULN.getText().equals("")){
                       pstmt.setString(num2, txtULN.getText());
                   }
                   
                   if(!txtUT.getText().equals("")){
                       pstmt.setString(num3, txtUT.getText());
                   }
                   
                   if(!txtUA.getText().equals("")){
                       pstmt.setString(num2, txtUA.getText());
                   }
                   
                   ResultSet rs = pstmt.executeQuery();
                   tblAppointment.setModel(buildTableModel(rs));
               }catch(Exception ex){
                   
               }
           }
       });
       
       JPanel pnlTopApm = new JPanel(new FlowLayout(FlowLayout.LEFT));
       JPanel pnlCenterAPM = new JPanel(new FlowLayout(FlowLayout.LEFT));
       JPanel pnlBtmApm = new JPanel(new FlowLayout(FlowLayout.LEFT));
       
       JLabel lblAddApm = new JLabel("Member ID:                              ");
       JTextField txtAddApm = new JTextField(10);
       JLabel lblDateApm = new JLabel("Date (Format YYYY-MM-DD):");
       JTextField txtDateApm = new JTextField(10);
       
       JButton btnSudmitApm = new JButton("Add");
       btnSudmitApm.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               try{
                   Connection conn = ConnectionManager.getConnection();
                   String sql = "UPDATE `appointment` SET `Appointment_Time` = ? WHERE Member_ID = ?;";
                   PreparedStatement pstmt = conn.prepareStatement(sql);
                   pstmt.setString(1, txtDateApm.getText());
                   pstmt.setString(2, txtAddApm.getText());
                   
                   int result = pstmt.executeUpdate();
                   
                   if(result > 0){
                       JOptionPane.showMessageDialog(null, "Add Successfull");
                       frame51.setVisible(false);
                       btnSearch1.doClick();
                       txtDateApm.setText("");
                       txtAddApm.setText("");
                   }else{
                       JOptionPane.showMessageDialog(null, "Member ID invalid");
                   }
               }catch(Exception ex){
                   
               }
           }
       });
       
       JButton btnCancelApm = new JButton("Cancel");
       btnCancelApm.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               frame51.setVisible(false);
           }
       });
       
       JPanel pnlBtmAPM = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       JButton btnAddApm = new JButton("Add Appointment");
       btnAddApm.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              frame51.setVisible(true);
          }
       });
       JButton btnRemoveApm = new JButton("Remove Appointment");
       btnRemoveApm.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               frame52.setVisible(true);
           }
       });
       
       JLabel lblRemoveApm = new JLabel("Member ID:                              ");
       JTextField txtRemoveApm = new JTextField(10);
       
       JButton btnRMApm = new JButton("Remove");
       btnRMApm.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               try{
                   if(!txtRemoveApm.getText().equals("")){
                   Connection conn = ConnectionManager.getConnection();
                   String sql = "UPDATE `appointment` SET `Appointment_Time` = null WHERE Member_ID = ?;";
                   PreparedStatement pstmt = conn.prepareStatement(sql);
                   pstmt.setString(1, txtRemoveApm.getText());
                   
                   int result = pstmt.executeUpdate();
                   
                   if(result > 0){
                       JOptionPane.showMessageDialog(null, "Remove Successfull");
                       frame52.setVisible(false);
                       txtRemoveApm.setText("");
                       btnSearch1.doClick();
                   }else{
                       JOptionPane.showMessageDialog(null, "Member ID invalid");
                   }
                   }else{
                       JOptionPane.showMessageDialog(null, "Please insert Member ID");
                   }
               }catch(Exception ex){
                   
               }
           }
       });
       JButton btnCancelRMApm = new JButton("Cancel");
       btnCancelRMApm.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               frame52.setVisible(false);
           }
       });
       
       JButton btnDeleteAPM = new JButton("Delete Appointment");
       btnDeleteAPM.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               frame53.setVisible(true);
           }
       });
       
       JLabel lblDeleteApm = new JLabel("Member ID:                              ");
       JTextField txtDeleteApm = new JTextField(10);
       
       JButton btnDLApm = new JButton("Delete");
       btnDLApm.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               try{
                   if(!txtDeleteApm.getText().equals("")){
                   Connection conn = ConnectionManager.getConnection();
                   String sql = "DELETE FROM `appointment` WHERE Member_ID = ?;";
                   PreparedStatement pstmt = conn.prepareStatement(sql);
                   pstmt.setString(1, txtDeleteApm.getText());
                   
                   int result = pstmt.executeUpdate();
                   
                   if(result > 0){
                       JOptionPane.showMessageDialog(null, "Delete Successfull");
                       frame53.setVisible(false);
                       txtDeleteApm.setText("");
                       btnSearch1.doClick();
                   }else{
                       JOptionPane.showMessageDialog(null, "Member ID invalid");
                   }
                   }else{
                       JOptionPane.showMessageDialog(null, "Please insert Member ID");
                   }
               }catch(Exception ex){
                   
               }
           }
       });
       JButton btnCancelDLApm = new JButton("Cancel");
       btnCancelDLApm.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               frame53.setVisible(false);
           }
       });
       
       JPanel pnlTopRMApm = new JPanel(new FlowLayout(FlowLayout.LEFT));
       JPanel pnlBtmRMApm = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       JPanel pnlTopDLApm = new JPanel(new FlowLayout(FlowLayout.LEFT));
       JPanel pnlBtmDLApm = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       
       //add
       pnlCtrLG.add(LGid);
       pnlCtrLG.add(LGID);
       pnlCtrLG.add(LGpw);
       pnlCtrLG.add(LGPW);
       
       pnlBtnLG.add(btnWlc);
       pnlBtnLG.add(btnExt1);
       
       pnlBtnMenu.add(btnRegister);
       pnlBtnMenu.add(btnMember);
       pnlBtnMenu.add(btnAppointment);
       pnlBtnMenu.add(btnLO);
       
       pnlTopRG.add(lblMemberID);
       pnlTopRG.add(txtMemberID);
       
       pnlFN.add(lblFN);
       pnlFN.add(txtFN);
       pnlLN.add(lblLN);
       pnlLN.add(txtLN);
       pnlGender.add(rdbMale);
       pnlGender.add(rdbFemale);
       
       pnlBtnRG.add(btnRGSudmit);
       pnlBtnRG.add(btnRGCancel);
       
       pnlPackage.add(rdbMember);
       pnlPackage.add(rdbVIP);
       pnlPackage.add(rdbVVIP);
       
       pnlCenterRG.add(pnlFN);
       pnlCenterRG.add(pnlLN);
       pnlCenterRG.add(lblGender);
       pnlCenterRG.add(pnlGender);
       pnlCenterRG.add(lblRace);
       pnlCenterRG.add(txtRace);
       pnlCenterRG.add(lblArea);
       pnlCenterRG.add(txtArea);
       pnlCenterRG.add(lblContact);
       pnlCenterRG.add(txtContact);
       pnlCenterRG.add(lblEmail);
       pnlCenterRG.add(txtEmail);
       pnlCenterRG.add(lblPackage);
       pnlCenterRG.add(pnlPackage);
       
       pnlTopMB.add(lblUFN);
       pnlTopMB.add(txtUFN);
       pnlTopMB.add(lblULN);
       pnlTopMB.add(txtULN);
       pnlTopMB.add(lblUT);
       pnlTopMB.add(txtUT);
       pnlTopMB.add(lblUA);
       pnlTopMB.add(txtUA);
       pnlTopMB.add(lblED);
       pnlTopMB.add(rdbActive);
       pnlTopMB.add(rdbExpire);
       pnlTopMB.add(btnSearch);
       pnlTopMB.add(btnRenew);
       pnlTopMB.add(btnDelete);
       
       pnlDeleteCenter.add(lblDelete1);
       pnlDeleteCenter.add(txtDelete1);
       pnlDeleteBtm.add(btnDelete1);
       pnlDeleteBtm.add(btnCancel1);
       
       pnlTopRenew.add(lblRenew);
       pnlTopRenew.add(txtRenew);
       pnlCenterRenew.add(lblMonth);
       pnlCenterRenew.add(txtMonth);
       pnlBtmRenew.add(btnRenew1);
       pnlBtmRenew.add(btnCancel2);
       
       pnlTopApm.add(lblAddApm);
       pnlTopApm.add(txtAddApm);
       pnlCenterAPM.add(lblDateApm);
       pnlCenterAPM.add(txtDateApm);
       pnlBtmApm.add(btnSudmitApm);
       pnlBtmApm.add(btnCancelApm);
       
       pnlTopRMApm.add(lblRemoveApm);
       pnlTopRMApm.add(txtRemoveApm);
       pnlBtmRMApm.add(btnRMApm);
       pnlBtmRMApm.add(btnCancelRMApm);
       
       pnlTopDLApm.add(lblDeleteApm);
       pnlTopDLApm.add(txtDeleteApm);
       pnlBtmDLApm.add(btnDLApm);
       pnlBtmDLApm.add(btnCancelDLApm);
       
       pnlBtmAPM.add(btnAddApm);
       pnlBtmAPM.add(btnRemoveApm);
       pnlBtmAPM.add(btnDeleteAPM);
       
       JScrollPane scrMember = new JScrollPane(tblMember);
       JScrollPane scrAppointment = new JScrollPane(tblAppointment);
       
       
       frame.add(pnlCtrLG, BorderLayout.CENTER);
       frame.add(pnlBtnLG, BorderLayout.SOUTH);
       
       frame2.add(pnlBtnMenu, BorderLayout.CENTER);
       
       frame3.add(pnlTopRG, BorderLayout.NORTH);
       frame3.add(pnlCenterRG, BorderLayout.CENTER);
       frame3.add(pnlBtnRG, BorderLayout.SOUTH);
       
       frame4.add(scrMember, BorderLayout.CENTER);
       frame4.add(pnlTopMB, BorderLayout.NORTH);
       
       frame41.add(pnlDeleteCenter, BorderLayout.CENTER);
       frame41.add(pnlDeleteBtm, BorderLayout.SOUTH);
       
       frame42.add(pnlTopRenew);
       frame42.add(pnlCenterRenew);
       frame42.add(pnlBtmRenew);
       
       frame5.add(scrAppointment, BorderLayout.CENTER);
       frame5.add(pnlBtmAPM, BorderLayout.SOUTH);
       
       frame51.add(pnlTopApm);
       frame51.add(pnlCenterAPM);
       frame51.add(pnlBtmApm);
       
       frame52.add(pnlTopRMApm, BorderLayout.CENTER);
       frame52.add(pnlBtmRMApm, BorderLayout.SOUTH);
       
       frame53.add(pnlTopDLApm, BorderLayout.CENTER);
       frame53.add(pnlBtmDLApm, BorderLayout.SOUTH);
       
       frame.setVisible(true);
    }
    public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);
}
}