/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIclient;

/**
 *
 * @author Fahmee
 */
import BusinessClasses.UserAccountList;
import BusinessClasses.UserAccount;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.util.HashMap;
public class UseraccountManagementForm extends javax.swing.JFrame {

    /**
     * Creates new form UseraccountManagementForm
     */
    public static UserAccountList objusrList = new UserAccountList();
    public UseraccountManagementForm() {
        initComponents();
        this.getContentPane().setBackground(Color.green);
        try {
                //Load the collection with data from File   
                objusrList.load();
                
                //Disables the X Close button on the Frame.
                //Done so user MUST click the Exit button to exit frame
                setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

                   }
        catch (Exception objE) {
            //Trapping for any errors 
            JOptionPane.showMessageDialog(null, objE.toString());
        }   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        useraccountmanagmentLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usernameTxt = new javax.swing.JTextField();
        idnumberTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        changeusernameBtn = new javax.swing.JButton();
        changeuserpasswordBtn = new javax.swing.JButton();
        changeuseremailBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        useraccountlistBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        useraccountmanagmentLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        useraccountmanagmentLbl.setText("USERACCOUNT MANAGEMENT");

        jLabel1.setText("Username: ");

        jLabel2.setText("ID number: ");

        jLabel3.setText("Password: ");

        jLabel4.setText("Email: ");

        idnumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idnumberTxtActionPerformed(evt);
            }
        });

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        removeBtn.setText("Remove");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        changeusernameBtn.setText("Chamge a Username");
        changeusernameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeusernameBtnActionPerformed(evt);
            }
        });

        changeuserpasswordBtn.setText("Change a Password");
        changeuserpasswordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeuserpasswordBtnActionPerformed(evt);
            }
        });

        changeuseremailBtn.setText("Change an Email");
        changeuseremailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeuseremailBtnActionPerformed(evt);
            }
        });

        exitBtn.setText("SAVE & EXIT");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        useraccountlistBtn.setText("List");
        useraccountlistBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useraccountlistBtnActionPerformed(evt);
            }
        });

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idnumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton1))
                        .addGap(68, 68, 68)
                        .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(editBtn)
                                    .addComponent(searchBtn))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(removeBtn)
                                    .addComponent(addBtn)))
                            .addComponent(changeusernameBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changeuserpasswordBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changeuseremailBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(useraccountmanagmentLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(useraccountlistBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addBtn, editBtn, removeBtn, searchBtn});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {emailTxt, idnumberTxt, passwordTxt, usernameTxt});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {exitBtn, jButton1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(useraccountmanagmentLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn)
                    .addComponent(addBtn))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idnumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn)
                    .addComponent(removeBtn))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(changeusernameBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(changeuserpasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeuseremailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(useraccountlistBtn)
                .addGap(22, 22, 22))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {exitBtn, jButton1});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changeuserpasswordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeuserpasswordBtnActionPerformed
        // TODO add your handling code here:
        try {
        
        boolean success;
        String username;
        String password;
        username = JOptionPane.showInputDialog(
                        null, "Please enter your username: ");
        password = JOptionPane.showInputDialog(
                        null, "Please enter your new password: ");

        
        
        
        success = objusrList.changePassword(username, password);

        if (success) {
            JOptionPane.showMessageDialog(null, "User password changed successfully!"); 
        } else {
          JOptionPane.showMessageDialog(null, "User not found!");    
        }
    }
         catch (Exception e) {
           JOptionPane.showMessageDialog(null, e.toString());   
        }
    }//GEN-LAST:event_changeuserpasswordBtnActionPerformed

    private void changeuseremailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeuseremailBtnActionPerformed
        // TODO add your handling code here:
        try {
        
        boolean success;
        String email,username;
        username = JOptionPane.showInputDialog(
                        null, "Please enter your username: ");
        email = JOptionPane.showInputDialog(
                        null, "Please enter your new email: ");

        
        
        
        success = objusrList.changeEmail(username, email);

        if (success) {
            JOptionPane.showMessageDialog(null, "User Email changed successfully!"); 
        } else {
          JOptionPane.showMessageDialog(null, "User not found!");    
        }
    }
         catch (Exception e) {
           JOptionPane.showMessageDialog(null, e.toString());   
        }
          
    }//GEN-LAST:event_changeuseremailBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        try {

            //Create a Customer pointer to store result of search
            UserAccount objusr;

            //Call the Search() method to do the work
            //TO Search for customer in list
            objusr = objusrList.search(usernameTxt.getText());

            //process results from method call
            //Customer found, display data
            if (objusr != null) {
                usernameTxt.setText(objusr.getUserName());
                idnumberTxt.setText(objusr.getUserAccountID());
                passwordTxt.setText(objusr.getPassword());
               
                                
                
                emailTxt.setText(objusr.getEmail());
                
               
                
            } else {
                //Display msg that customer was not found
                JOptionPane.showMessageDialog(null, "UserAccount not found!");
            }        
        
        
        }
        catch (Exception objE) {
            //Trapping for any errors 
            JOptionPane.showMessageDialog(null, objE.toString());            
        }     
    }//GEN-LAST:event_searchBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        try {

            boolean success;


            //Create customer object to add
            UserAccount objNewCustomer = UserAccount.getInstance();

            //Set Object properties with data from TextField Controls
            
            objNewCustomer.setUsername(usernameTxt.getText());
            objNewCustomer.setPassword(passwordTxt.getText());                       
            
           
            objNewCustomer.setEmail(emailTxt.getText());
            

            //Call add method to do the work
            success = objusrList.add(objNewCustomer.getUserName(), objNewCustomer);

            //Process results
            if (success) {

                JOptionPane.showMessageDialog(null,"UserAccount Added");
            } else {

                JOptionPane.showMessageDialog(null,"No available space!");
            }
        }
        catch (Exception objE) {
            //Trapping for any errors 
            JOptionPane.showMessageDialog(null, objE.toString());        
        } 
    }//GEN-LAST:event_addBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
         try {        

            //Create temporary variables
            boolean success;

  

            //Call Edit method to do the work
            success = objusrList.edit(usernameTxt.getText(), passwordTxt.getText(), emailTxt.getText());

            //Process results
            if (success) {

                JOptionPane.showMessageDialog(null,"User record modified");
            } else {

                JOptionPane.showMessageDialog(null,"User not found!");
            }
    }//GEN-LAST:event_editBtnActionPerformed
  catch (Exception objE) {
            //Trapping for any errors 
            JOptionPane.showMessageDialog(null, objE.toString());                
        } 
    }
    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        // TODO add your handling code here:
          try {

            //Create temporary variables
            boolean success;

 
            //Call Remove method to delete customer from list
            success = objusrList.remove(usernameTxt.getText());

            //Process results
            if (success) {
 
                JOptionPane.showMessageDialog(null,"user deleted");
            } else {

                JOptionPane.showMessageDialog(null,"user not found!");
            }
        }
        catch (Exception objE) {
            //Trapping for any errors 
                JOptionPane.showMessageDialog(null,objE.toString());           
        } 
    }//GEN-LAST:event_removeBtnActionPerformed

    private void idnumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idnumberTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idnumberTxtActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        try {

            //Save & clear the collection when Frame is closing
            objusrList.save();
            objusrList.clear();
                   }
        catch (Exception objE) {
            //Trapping for any errors 
            JOptionPane.showMessageDialog(null, objE.toString());
        }                      
        this.dispose();
    }//GEN-LAST:event_exitBtnActionPerformed

    private void useraccountlistBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useraccountlistBtnActionPerformed
        // TODO add your handling code here:
         try {
            //Create HashMap Pointer to hold HashMap List 
            //returned from Custom Collection Class Object
            HashMap<String, UserAccount> customerList;
            
            
            //Get a POINTER to the internal HashMap Collection inside the Custom Collection
            //Class object
            customerList = objusrList.getUseraccountList();

            //Clear the List
            jList1.removeAll();
            
            //To modify the elements in the list, you need to create a list model
            //Object (need to import the DefaultListModel Class)
            DefaultListModel<String> model = new DefaultListModel();
                   
            //Loop throught the HashMap collection using For Each Loop       
            for(UserAccount objCustomer : customerList.values())
               {
                   //Read next Object & create comma-delimited string from the properties
                    String item = 
                    
                    objCustomer.getUserName()  + ","  + 
                    objCustomer.getUserAccountID() + ","  +                                 
                    objCustomer.getPassword()  + ","  +
                    
                    objCustomer.getEmail();
                    
                    //Add item (comma-delimited line) to model
                    model.addElement(item);
                    
                    //Repeate process until all objects have been added
               }                             
   
            //SET the model to replace all items in the LIST
             jList1.setModel(model);
                       
            }
            catch (Exception objE) {
                //Trapping for any errors 
                JOptionPane.showMessageDialog(null,objE.toString());       
        } 
        
    }//GEN-LAST:event_useraccountlistBtnActionPerformed

    private void changeusernameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeusernameBtnActionPerformed
        // TODO add your handling code here:
        try {
            //UserAccount objusr = UserAccount.getInstance();
        
        boolean success;
        String username ,newusername;
        username = JOptionPane.showInputDialog(
                        null, "Please enter your username: ");

        
        
        newusername = JOptionPane.showInputDialog(
                        null, "Please enter your new username: ");
        success = objusrList.changeUserName(username,newusername);

        if (success) {
            JOptionPane.showMessageDialog(null,"User record modified");
        } else {
            JOptionPane.showMessageDialog(null,"User record not found!");
        }
    }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.toString());
        }
    }//GEN-LAST:event_changeusernameBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        usernameTxt.setText(null);
        passwordTxt.setText(null);
        emailTxt.setText(null);
        idnumberTxt.setText(null);
        
    }//GEN-LAST:event_jButton1ActionPerformed
     
      
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UseraccountManagementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UseraccountManagementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UseraccountManagementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UseraccountManagementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UseraccountManagementForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton changeuseremailBtn;
    private javax.swing.JButton changeusernameBtn;
    private javax.swing.JButton changeuserpasswordBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JButton exitBtn;
    private javax.swing.JTextField idnumberTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField passwordTxt;
    private javax.swing.JButton removeBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton useraccountlistBtn;
    private javax.swing.JLabel useraccountmanagmentLbl;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}