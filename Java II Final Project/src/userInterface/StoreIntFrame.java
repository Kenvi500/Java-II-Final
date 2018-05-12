package userInterface;

/**
 *
 * @author Kelvin Bonilla
 */
public class StoreIntFrame extends javax.swing.JFrame
{

    private final MainMenuFrame mainMenu;
    
    /**
     * Creates new form StoreIntFrame
     */
    public StoreIntFrame(MainMenuFrame mainMenu) {
        initComponents();
        this.mainMenu = mainMenu;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        intToStoreLbl = new javax.swing.JLabel();
        intNameLbl = new javax.swing.JLabel();
        intNameTxtField = new javax.swing.JTextField();
        enterIntTxtField = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Store An Integer");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                windowClosingEvt(evt);
            }
        });

        intToStoreLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        intToStoreLbl.setText("Integer To Store:");
        intToStoreLbl.setToolTipText("The integer that is to be stored in the Main Menu");

        intNameLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        intNameLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        intNameLbl.setText("Name of The Integer:");
        intNameLbl.setToolTipText("The name that this integer will be associated with in the Main Menu");

        intNameTxtField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        intNameTxtField.setText("[Enter Name Here]");
        intNameTxtField.setToolTipText("The field used to type the name that this integer will use");
        intNameTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldFocusGained(evt);
            }
        });
        intNameTxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                enterKeyPressed2(evt);
            }
        });

        enterIntTxtField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        enterIntTxtField.setText("[Enter Int Here]");
        enterIntTxtField.setToolTipText("The field used for typing the integer");
        enterIntTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldFocusGained(evt);
            }
        });
        enterIntTxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                enterKeyPressed1(evt);
            }
        });

        backBtn.setText("Back");
        backBtn.setToolTipText("Closes this window and brings you to the \"Array or Integer?\" window");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        submitBtn.setText("Submit");
        submitBtn.setToolTipText("Stores the integer into the Main Menu");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitBtn)
                        .addGap(18, 18, 18)
                        .addComponent(backBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(intNameLbl)
                            .addComponent(intToStoreLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(intNameTxtField)
                            .addComponent(enterIntTxtField))))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(intToStoreLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterIntTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(intNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(intNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(submitBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldFocusGained
        if (evt.getComponent() instanceof javax.swing.JTextField)
        {
            javax.swing.JTextField tf = (javax.swing.JTextField) evt.getComponent();
            tf.selectAll();
        }
    }//GEN-LAST:event_txtFieldFocusGained

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        TitleFrameApp.displayFrame(new Array_Integer_Popup(mainMenu), this);
        dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        Integer theNum = null;
        try 
        {
            theNum = Integer.parseInt(enterIntTxtField.getText());
            if(theNum < 0)
                throw new NumberFormatException();
        } 
        catch (NumberFormatException e)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error! Entry must be a non-negative integer.", "Entry Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            enterIntTxtField.requestFocusInWindow();
            return;
        }
        String theName = intNameTxtField.getText();
        
        mainMenu.addData(theName, theNum); // shouldn't be null, unless something goes wrong
        
        javax.swing.JOptionPane.showMessageDialog(this, theName + " has been stored.", "Integer Submitted", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        enterIntTxtField.setText("[Enter Int Here]");
        enterIntTxtField.requestFocusInWindow();
        intNameTxtField.setText("Enter Name Here]");
    }//GEN-LAST:event_submitBtnActionPerformed

    private void enterKeyPressed1(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enterKeyPressed1
        if(evt.getExtendedKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
            intNameTxtField.requestFocusInWindow();
    }//GEN-LAST:event_enterKeyPressed1

    private void enterKeyPressed2(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enterKeyPressed2
        if(evt.getExtendedKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
            submitBtn.doClick();
    }//GEN-LAST:event_enterKeyPressed2

    private void windowClosingEvt(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowClosingEvt
        backBtn.doClick();
    }//GEN-LAST:event_windowClosingEvt

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField enterIntTxtField;
    private javax.swing.JLabel intNameLbl;
    private javax.swing.JTextField intNameTxtField;
    private javax.swing.JLabel intToStoreLbl;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}
