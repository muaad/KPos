package views;

import helpers.ViewHelpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Stock;
import models.User;

import controllers.ClientController;

/**
*
* @author Muaad
*/
public class SignUp extends javax.swing.JFrame {

   /**
    * Creates new form SignUp
    */
   public SignUp(ClientController controller) {
	   this.controller = controller;
       initComponents();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">
   public void initComponents() {

       signUpPanel = new javax.swing.JPanel();
       userLabel = new javax.swing.JLabel();
       userTxt = new javax.swing.JTextField();
       passLabel = new javax.swing.JLabel();
       loginButton = new javax.swing.JButton();
       verifyUsernameLabel = new javax.swing.JLabel();
       reTypePassLabel = new javax.swing.JLabel();
       passwordField = new javax.swing.JPasswordField();
       reTypePasswordField = new javax.swing.JPasswordField();
       phoneTxt = new javax.swing.JTextField();
       phoneLabel = new javax.swing.JLabel();
       checkPasswordMatchLabel = new javax.swing.JLabel();
       signUpButton = new javax.swing.JButton();
       cancelButton = new javax.swing.JButton();
       lastNameTxt = new javax.swing.JTextField();
       firstNameLabel = new javax.swing.JLabel();
       lastNameLabel = new javax.swing.JLabel();
       emailLabel = new javax.swing.JLabel();
       txtEmail = new javax.swing.JTextField();
       firstNameTxt = new javax.swing.JTextField();
       logoPanel = new javax.swing.JPanel();
       logoLabel = new javax.swing.JLabel();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       setResizable(false);

       signUpPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

       userLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
       userLabel.setText("Username");

       passLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
       passLabel.setText("Password");

       loginButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
       loginButton.setForeground(new java.awt.Color(0, 0, 255));
       loginButton.setText("<html><body style = \"text-decoration:underline;\">Login if you already have an account.</body></html>");
       loginButton.setBorderPainted(false);
       loginButton.setContentAreaFilled(false);
       loginButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
       loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
           public void mouseEntered(java.awt.event.MouseEvent evt) {
               loginButtonMouseEntered(evt);
           }
           public void mouseExited(java.awt.event.MouseEvent evt) {
               loginButtonMouseExited(evt);
           }
       });
       loginButton.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               loginButtonActionPerformed(evt);
           }
       });

       verifyUsernameLabel.setForeground(new java.awt.Color(153, 153, 153));
       verifyUsernameLabel.setText("A - Z, 0 ~ 9 And must be unique");

       reTypePassLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
       reTypePassLabel.setText("Re-type Password");

       passwordField.setText("jPasswordField1");

       reTypePasswordField.setText("jPasswordField1");

       phoneLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
       phoneLabel.setText("Phone Number");

       signUpButton.setText("Sign Up");
       signUpButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			User.create(ViewHelpers.constructParamsMap("first_name", firstNameTxt.getText(), "last_name", lastNameTxt.getText(),
					"phone_number", phoneTxt.getText(), "email", txtEmail.getText(), "user_name", userTxt.getText(),
					"password", new String(passwordField.getPassword())));
		}
	});

       cancelButton.setText("Cancel");

       firstNameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
       firstNameLabel.setText("First Name");

       lastNameLabel.setText("Last Name");

       emailLabel.setText("Email");

       javax.swing.GroupLayout signUpPanelLayout = new javax.swing.GroupLayout(signUpPanel);
       signUpPanel.setLayout(signUpPanelLayout);
       signUpPanelLayout.setHorizontalGroup(
           signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(signUpPanelLayout.createSequentialGroup()
               .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(signUpPanelLayout.createSequentialGroup()
                       .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                       .addComponent(signUpButton)
                       .addGap(55, 55, 55)
                       .addComponent(cancelButton))
                   .addGroup(signUpPanelLayout.createSequentialGroup()
                       .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(signUpPanelLayout.createSequentialGroup()
                               .addGap(33, 33, 33)
                               .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(phoneLabel)
                                   .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                               .addGap(22, 22, 22)
                               .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                       .addComponent(txtEmail)
                                       .addComponent(phoneTxt)
                                       .addComponent(lastNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                       .addComponent(firstNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                                   .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                           .addGroup(signUpPanelLayout.createSequentialGroup()
                               .addGap(31, 31, 31)
                               .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(reTypePassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(passLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                               .addGap(22, 22, 22)
                               .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(verifyUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(reTypePasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                       .addGap(0, 0, Short.MAX_VALUE))
                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signUpPanelLayout.createSequentialGroup()
                       .addGap(0, 0, Short.MAX_VALUE)
                       .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(loginButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addComponent(checkPasswordMatchLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
               .addContainerGap())
       );
       signUpPanelLayout.setVerticalGroup(
           signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(signUpPanelLayout.createSequentialGroup()
               .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(signUpPanelLayout.createSequentialGroup()
                       .addContainerGap()
                       .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                       .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                       .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                           .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                   .addGroup(signUpPanelLayout.createSequentialGroup()
                       .addGap(14, 14, 14)
                       .addComponent(firstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(verifyUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(passLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
               .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(reTypePassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(reTypePasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(checkPasswordMatchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(18, 18, 18)
               .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
               .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(47, 47, 47))
       );

       logoLabel.setFont(new java.awt.Font("Script MT Bold", 3, 48)); // NOI18N
       logoLabel.setForeground(new java.awt.Color(255, 153, 204));
       logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
       logoLabel.setText("Kasoko POS");
       logoLabel.setOpaque(true);

       javax.swing.GroupLayout logoPanelLayout = new javax.swing.GroupLayout(logoPanel);
       logoPanel.setLayout(logoPanelLayout);
       logoPanelLayout.setHorizontalGroup(
           logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       );
       logoPanelLayout.setVerticalGroup(
           logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
       );

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(signUpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                   .addComponent(logoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(signUpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(logoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
       );

       pack();
   }// </editor-fold>

   private void loginButtonMouseEntered(java.awt.event.MouseEvent evt) {
       // TODO add your handling code here:
       loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
       //        loginButton.setText("<html><body style = \"text-decoration:none;\">Login if you already have an account</body></html>");
   }

   private void loginButtonMouseExited(java.awt.event.MouseEvent evt) {
       // TODO add your handling code here:
       loginButton.setText("<html><body style = \"text-decoration:underline;\">Login if you already have an account</body></html>");
   }

   private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
       controller.hideRegisterScreen();
       controller.displayLoginScreen();
   }

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
       /* Set the Nimbus look and feel */
       //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
       /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        */
//       try {
//           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//               if ("Nimbus".equals(info.getName())) {
//                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                   break;
//               }
//           }
//       } catch (ClassNotFoundException ex) {
//           java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//       } catch (InstantiationException ex) {
//           java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//       } catch (IllegalAccessException ex) {
//           java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//           java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//       }
       //</editor-fold>

       /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
//               new SignUp().setVisible(true);
           }
       });
   }
   // Variables declaration - do not modify
   private javax.swing.JButton cancelButton;
   private javax.swing.JLabel checkPasswordMatchLabel;
   private javax.swing.JLabel firstNameLabel;
   private javax.swing.JTextField firstNameTxt;
   private javax.swing.JLabel lastNameLabel;
   private javax.swing.JLabel emailLabel;
   private javax.swing.JLabel logoLabel;
   private javax.swing.JPanel logoPanel;
   private javax.swing.JTextField txtEmail;
   private javax.swing.JTextField lastNameTxt;
   private javax.swing.JButton loginButton;
   private javax.swing.JLabel passLabel;
   private javax.swing.JPasswordField passwordField;
   private javax.swing.JLabel phoneLabel;
   private javax.swing.JTextField phoneTxt;
   private javax.swing.JLabel reTypePassLabel;
   private javax.swing.JPasswordField reTypePasswordField;
   private javax.swing.JButton signUpButton;
   private javax.swing.JPanel signUpPanel;
   private javax.swing.JLabel userLabel;
   private javax.swing.JTextField userTxt;
   private javax.swing.JLabel verifyUsernameLabel;
   private ClientController controller;
   // End of variables declaration
}