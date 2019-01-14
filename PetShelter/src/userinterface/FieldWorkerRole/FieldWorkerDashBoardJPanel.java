/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.FieldWorkerRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.PetShelterOrganization;
import Business.POJO.Pet;
import Business.Role.FieldWorkerRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PetAdoptionWorkRequest;
import Business.WorkQueue.PetHealthCheckUpRequest;
import Business.WorkQueue.ReportStrayAnimalRequest;
import Business.WorkQueue.WorkRequest;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.NgoStaffRole.ViewRequestJPanel;

/**
 *
 * @author rishijatania
 */
public class FieldWorkerDashBoardJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private PetShelterOrganization organization;
    private UserAccount account;
    private Enterprise enterprise;
    private WorkRequest workQ;
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private Pet pet;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();

    /**
     * Creates new form WardenDashBoardJPanel
     */
    public FieldWorkerDashBoardJPanel(JPanel userProcessContainer, UserAccount account, PetShelterOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        jLabel3.setText(enterprise.getName());
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.organization = organization;
        this.enterprise = enterprise;
        this.account = account;
        populateRequestTable();
    }

    public void populateRequestTable() {

        ArrayList<Pet> petsList = business.getPetDirInstance().getListOfPets();
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        String requestType = viewReqFilter.getSelectedItem() != null ? viewReqFilter.getSelectedItem().toString() : "";
        model.setRowCount(0);
        switch (requestType) {

//            case "Pet Adoption Request":
//                assignJBtn.setVisible(false);
//                reqApprovalBtn.setVisible(true);
//                for (UserAccount user : organization.getUserAccountDirectory().getUserAccountList()) {
//                    if (user.getRole() instanceof FieldWorkerRole) {
//                        if (user.getUsername().equals(account.getUsername())) {
//                            for (WorkRequest request : user.getWorkQueue().getWorkRequestList()) {
//                                if (request instanceof PetAdoptionWorkRequest) {
//                                    Object[] row = new Object[8];
//                                    row[0] = request;
//                                    row[1] = ((PetAdoptionWorkRequest) request).getPet();
//                                    row[2] = ((PetAdoptionWorkRequest) request).getUser();
//                                    row[3] = ((PetAdoptionWorkRequest) request).getReceiver();
//                                    row[4] = ((PetAdoptionWorkRequest) request).getStatus();
//                                    row[5] = ((PetAdoptionWorkRequest) request).getRequestDate();
//                                    row[6] = ((PetAdoptionWorkRequest) request).getResolveDate();
//                                    row[7] = ((PetAdoptionWorkRequest) request).getComments();
//                                    model.addRow(row);
//                                }
//                            }
//                        }
//                    }
//                }
//                break;

            case "Stray Animal Request":
//                assignJBtn.setVisible(false);
//                reqApprovalBtn.setVisible(false);
                processRequestBtn.setVisible(true);
                for (UserAccount user : organization.getUserAccountDirectory().getUserAccountList()) {
                    if (user.getRole() instanceof FieldWorkerRole) {
                        if (user.getUsername().equals(account.getUsername())) {
                            for (WorkRequest request : user.getWorkQueue().getWorkRequestList()) {
                                if (request instanceof ReportStrayAnimalRequest) {
                                    Object[] row = new Object[10];
                                    row[0] = ((ReportStrayAnimalRequest) request);
                                    row[2] = ((ReportStrayAnimalRequest) request).getSender();
                                    row[4] = ((ReportStrayAnimalRequest) request).getStatus();
                                    row[1] =  ((ReportStrayAnimalRequest) request).getPet() == null ? "Not Assigned" : ((ReportStrayAnimalRequest) request).getPet().getPetId();
                                    row[8] = ((ReportStrayAnimalRequest) request).getUrgencyType();
                                    row[9] = ((ReportStrayAnimalRequest) request).getIssueType();
                                    row[7] = ((ReportStrayAnimalRequest) request).getComments();
                                    row[3] = ((ReportStrayAnimalRequest) request).getReceiver();
                                    row[5] = ((ReportStrayAnimalRequest) request).getRequestDate();
                                    row[6] = ((ReportStrayAnimalRequest) request).getResolveDate() == null ? "Not Resolved" : ((ReportStrayAnimalRequest) request).getResolveDate();
                                    model.addRow(row);
                                }
                            }
                        }
                    }
                }
             break;   
            case "Pet Health CheckUp Request":
                processRequestBtn.setVisible(false);
                account.getWorkQueue().getWorkRequestList().forEach(request->{
                    if (request instanceof PetHealthCheckUpRequest) {
                        Object[] row = new Object[9];
                        row[0] = request;
                        row[1] = ((PetHealthCheckUpRequest) request).getPet();
                        row[2] = ((PetHealthCheckUpRequest) request).getSender();
                        row[3] = ((PetHealthCheckUpRequest) request).getReceiver();
                        row[4] = ((PetHealthCheckUpRequest) request).getStatus();
                        row[5] = ((PetHealthCheckUpRequest) request).getRequestDate();
                        row[6] = ((PetHealthCheckUpRequest) request).getResolveDate();
                        row[7] = ((PetHealthCheckUpRequest) request).getComments();
                        row[8] = ((PetHealthCheckUpRequest) request).getUrgency();
                        model.addRow(row);
        }
                });
                break;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        refreshTestJButton = new javax.swing.JButton();
        viewReqFilter = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        processRequestBtn = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Pet ID", "Request Raised By", "Receiver", "Status", "Request Date", "Resolve Date", "Comments", "Urgency", "Issue"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable.setRowHeight(20);
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 1030, 150));

        refreshTestJButton.setBackground(new java.awt.Color(0, 153, 255));
        refreshTestJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });
        add(refreshTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 90, -1, 30));

        viewReqFilter.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        viewReqFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stray Animal Request", "Pet Health CheckUp Request" }));
        viewReqFilter.setToolTipText("");
        viewReqFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                viewReqFilterItemStateChanged(evt);
            }
        });
        viewReqFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewReqFilterActionPerformed(evt);
            }
        });
        add(viewReqFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, -1, 30));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel2.setText("Enterprise:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 40));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(226, 153, 0));
        jLabel3.setText("jLabel3");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 150, 60));

        backJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, -1, 40));

        processRequestBtn.setBackground(new java.awt.Color(0, 153, 255));
        processRequestBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        processRequestBtn.setText("Process Request");
        processRequestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processRequestBtnActionPerformed(evt);
            }
        });
        add(processRequestBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 360, 190, 40));

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton1.setText("Raise Pet Health Checkup Request");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jTabbedPane1.addTab("Health Request:-", jButton1);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed
        populateRequestTable();
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void viewReqFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_viewReqFilterItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_viewReqFilterItemStateChanged

    private void viewReqFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewReqFilterActionPerformed
        // TODO add your handling code here:
        populateRequestTable();
    }//GEN-LAST:event_viewReqFilterActionPerformed

    private void filterStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterStatusActionPerformed
        // TODO add your handling code here:
        populateRequestTable();
    }//GEN-LAST:event_filterStatusActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("FieldWorkerPetHealthCheckUpJPanel", new FieldWorkerPetHealthCheckUpJPanel(userProcessContainer,account,organization,enterprise ,business));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed
    private void processRequestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processRequestBtnActionPerformed
        // TODO add your handling code here:
         Integer selectedRow = workRequestJTable.getSelectedRow();
         if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table");
            return;
        }
        WorkRequest registerwQ = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
        if (selectedRow >= 0) {
            if (!registerwQ. getStatus().equalsIgnoreCase("Resolved")) {
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                userProcessContainer.add("RegisterAnimalJPanel ", new RegisterAnimalJPanel(userProcessContainer, account, organization, enterprise, business, registerwQ));
                layout.next(userProcessContainer);
            } 
            if(registerwQ. getStatus().equalsIgnoreCase("Resolved")){
                JOptionPane.showMessageDialog(null, "Pet attended and registered");
                return;
            }
        }
    }//GEN-LAST:event_processRequestBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton processRequestBtn;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JComboBox<String> viewReqFilter;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
