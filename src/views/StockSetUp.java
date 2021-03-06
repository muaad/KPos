package views;

/**
 *
 * @author Muaad
 */
public class StockSetUp extends javax.swing.JPanel {

    /**
     * Creates new form StockSetUp
     */
    public StockSetUp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        headerLabel = new javax.swing.JLabel();
        moreInstructionsLabel = new javax.swing.JLabel();
        importButton = new javax.swing.JButton();
        instructionsLabel = new javax.swing.JLabel();

        headerLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        headerLabel.setText("Upload Stock");

        moreInstructionsLabel.setText("<html><body>If you don't have your stock in an Excel file now, you can add them manually later once the application has been set up.");
        moreInstructionsLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        importButton.setText("Import File");

        instructionsLabel.setText("<html><body>If you have your stock in an Excel file, you can upload it here. Please make sure that your file is properly formartted and should include the following columns:<ul><li>name</li><li>quantity</li><li>units</li><li>buying_price</li><li>selling_price</li></ul></body></html>");
        instructionsLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(headerLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(moreInstructionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(importButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(366, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(instructionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel)
                .addGap(142, 142, 142)
                .addComponent(importButton)
                .addGap(18, 18, 18)
                .addComponent(moreInstructionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(instructionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(109, Short.MAX_VALUE)))
        );
    }// </editor-fold>
    // Variables declaration - do not modify
    private javax.swing.JLabel headerLabel;
    public javax.swing.JButton importButton;
    public javax.swing.JLabel instructionsLabel;
    public javax.swing.JLabel moreInstructionsLabel;
    // End of variables declaration
}
