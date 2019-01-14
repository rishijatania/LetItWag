/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.WardenRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.VetHospital;
import Business.Network.Network;
import Business.Organization.ClinicOrganization;
import Business.Organization.NgoOfficeOrganization;
import Business.Organization.Organization;
import Business.Organization.PetShelterOrganization;
import Business.POJO.Pet;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PetAdoptionWorkRequest;
import Business.WorkQueue.PetHealthCheckUpRequest;
import Business.WorkQueue.ReportStrayAnimalRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author rishijatania
 */
public class WardenDashBoardJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private PetShelterOrganization organization;
    private UserAccount account;
    private Enterprise enterprise;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Creates new form WardenDashBoardJPanel
     */
    public WardenDashBoardJPanel(JPanel userProcessContainer, UserAccount account, PetShelterOrganization organization, Enterprise enterprise, EcoSystem business) {
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
            case "Pet Adoption Request":
                reqApprovalBtn.setVisible(true);
                jButton1.setVisible(false);
                assignJBtn.setVisible(false);
                assignFieldworkerBtn.setVisible(false);
                organization.getWorkQueue().getWorkRequestList()
                        .stream().filter(wq -> wq instanceof PetAdoptionWorkRequest)
//                        .filter(wq -> filterStatus.getSelectedItem().toString().equalsIgnoreCase("All") ? true
//                        : wq.getStatus().equalsIgnoreCase(filterStatus.getSelectedItem().toString()))
                        .forEach(request -> {
                            Object[] row = new Object[8];
                            row[0] = request;
                            row[1] = ((PetAdoptionWorkRequest) request).getPet();
                            row[2] = ((PetAdoptionWorkRequest) request).getUser();
                            row[3] = ((PetAdoptionWorkRequest) request).getReceiver();
                            row[4] = ((PetAdoptionWorkRequest) request).getStatus();
                            row[5] = ((PetAdoptionWorkRequest) request).getRequestDate();
                            row[6] = ((PetAdoptionWorkRequest) request).getResolveDate();
                            row[7] = ((PetAdoptionWorkRequest) request).getComments();
                            model.addRow(row);
                        });
                break;
            case "Stray Animal Request":
                reqApprovalBtn.setVisible(false);
                jButton1.setVisible(false);
                assignJBtn.setVisible(true);
                assignFieldworkerBtn.setVisible(true);
                enterprise.getOrganizationDirectory().getOrganizationList().stream().filter((e) -> (e instanceof PetShelterOrganization)).forEachOrdered((e) -> {
                    e.getWorkQueue().getWorkRequestList().stream().filter(wq -> wq instanceof ReportStrayAnimalRequest)
                            .forEach(request -> {
                                Object[] row = new Object[10];
                                row[0] = ((ReportStrayAnimalRequest) request);
                                row[1] = ((ReportStrayAnimalRequest) request).getPet() == null ? "Not Assigned" : ((ReportStrayAnimalRequest) request).getPet();
                                row[2] = ((ReportStrayAnimalRequest) request).getSender();
                                row[3] = ((ReportStrayAnimalRequest) request).getReceiver();
                                row[4] = ((ReportStrayAnimalRequest) request).getStatus();
                                row[5] = ((ReportStrayAnimalRequest) request).getRequestDate();
                                row[6] = ((ReportStrayAnimalRequest) request).getResolveDate() == null ? "Not Resolved" : ((ReportStrayAnimalRequest) request).getResolveDate();
                                row[7] = ((ReportStrayAnimalRequest) request).getComments();
                                row[8] = ((ReportStrayAnimalRequest) request).getIssueType();
                                row[9] = ((ReportStrayAnimalRequest) request).getUrgencyType();
                                model.addRow(row);
                            });
                });
                break;
            case "Pet Health CheckUp Request":
                reqApprovalBtn.setVisible(false);
                jButton1.setVisible(true);
                assignJBtn.setVisible(true);
                assignFieldworkerBtn.setVisible(false);
                organization.getWorkQueue().getWorkRequestList()
                        .stream().filter(wq -> wq instanceof PetHealthCheckUpRequest)
//                        .filter(wq -> filterStatus.getSelectedItem().toString().equalsIgnoreCase("All") ? true
//                        : wq.getStatus().equalsIgnoreCase(filterStatus.getSelectedItem().toString()))
                        .forEach(request -> {
                            Object[] row = new Object[10];
                            row[0] = request;
                            row[1] = ((PetHealthCheckUpRequest) request).getPet();
                            row[2] = ((PetHealthCheckUpRequest) request).getSender();
                            row[3] = ((PetHealthCheckUpRequest) request).getReceiver();
                            row[4] = ((PetHealthCheckUpRequest) request).getStatus();
                            row[5] = ((PetHealthCheckUpRequest) request).getRequestDate();
                            row[6] = ((PetHealthCheckUpRequest) request).getResolveDate();
                            row[7] = ((PetHealthCheckUpRequest) request).getComments();
                            row[9] = ((PetHealthCheckUpRequest) request).getUrgency();
                            model.addRow(row);
                        });
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
        assignJBtn = new javax.swing.JButton();
        reqApprovalBtn = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        assignFieldworkerBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RequestId", "PetId", "Request Raised By", "Receiver", "Status", "Request Date", "Resolve Date", "Comments", "Issue", "Urgency "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        workRequestJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                workRequestJTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 177, 929, 196));

        refreshTestJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });
        add(refreshTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(859, 101, 105, 40));

        viewReqFilter.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        viewReqFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stray Animal Request", "Pet Adoption Request", "Pet Health CheckUp Request" }));
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
        add(viewReqFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 101, -1, 40));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel2.setText("Enterprise:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 24, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(226, 153, 0));
        jLabel3.setText("jLabel3");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 24, 320, -1));

        assignJBtn.setBackground(new java.awt.Color(0, 153, 255));
        assignJBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        assignJBtn.setText("Assign To me");
        assignJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJBtnActionPerformed(evt);
            }
        });
        add(assignJBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 414, 191, 41));

        reqApprovalBtn.setBackground(new java.awt.Color(0, 153, 255));
        reqApprovalBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        reqApprovalBtn.setText("Request for approval");
        reqApprovalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqApprovalBtnActionPerformed(evt);
            }
        });
        add(reqApprovalBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(767, 414, -1, 41));

        backJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 535, -1, 40));

        assignFieldworkerBtn.setBackground(new java.awt.Color(0, 153, 255));
        assignFieldworkerBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        assignFieldworkerBtn.setText("Assign Fieldworker");
        assignFieldworkerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignFieldworkerBtnActionPerformed(evt);
            }
        });
        add(assignFieldworkerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 414, -1, 41));

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton1.setText("Raise Request to Vet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 414, -1, 41));
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

    private void assignJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJBtnActionPerformed
        // TODO add your handling code here:
        String requestType = viewReqFilter.getSelectedItem() != null ? viewReqFilter.getSelectedItem().toString() : "";
        switch (requestType) {
            case "Pet Adoption Request":
                Integer selectedRow1 = workRequestJTable.getSelectedRow();
                if (selectedRow1 >= 0) {
                PetAdoptionWorkRequest pa = (PetAdoptionWorkRequest) workRequestJTable.getValueAt(selectedRow1, 0);
                    pa.setReceiver(account);
                    pa.setStatus("Assigned");
                    populateRequestTable();
                    dB4OUtil.storeSystem(business);
                    logger.info(" Request assigned to " + account);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row from table");
                    logger.error(" Please select a row from table");
                }
                break;
            case "Stray Animal Request":
                Integer selectedRow2 = workRequestJTable.getSelectedRow();
                if (selectedRow2 >= 0) {
                ReportStrayAnimalRequest reportAnimal = (ReportStrayAnimalRequest) workRequestJTable.getValueAt(selectedRow2, 0);
                
                    if(!reportAnimal.getStatus().equalsIgnoreCase("Request Forwarded")){
                       JOptionPane.showMessageDialog(null, "Request already assigned/processed"); 
                       return;
                    }
                    reportAnimal.setReceiver(account);
                    reportAnimal.setStatus("Warden Assigned");
                    populateRequestTable();
                    dB4OUtil.storeSystem(business);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row from table");
                    logger.error(" Please select a row from table");
                }
                break;
            case "Pet Health CheckUp Request":
                Integer selectedRow3 = workRequestJTable.getSelectedRow();
                if (selectedRow3 >= 0) {
                PetHealthCheckUpRequest animalHealth = (PetHealthCheckUpRequest) workRequestJTable.getValueAt(selectedRow3, 0);
                 if(animalHealth.getReceiver() != null){
                       JOptionPane.showMessageDialog(null, "Request already processed/assigned");
                       return;
                }
                
                    animalHealth.setReceiver(account);
                    animalHealth.setStatus("Warden Assigned");
                    dB4OUtil.storeSystem(business);
                    populateRequestTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row from table");
                    logger.error(" Please select a row from table");
                }
                break;
        }
    }//GEN-LAST:event_assignJBtnActionPerformed

    private void reqApprovalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqApprovalBtnActionPerformed
        // TODO add your handling code here:
        Integer selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow >= 0) {
        PetAdoptionWorkRequest pa = (PetAdoptionWorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            if(pa.getStatus().equalsIgnoreCase("Pending approval")){
                JOptionPane.showMessageDialog(null, "Request already sent to Office");
            return;
            }
            if(pa.getStatus().equalsIgnoreCase("Approved") || pa.getStatus().equalsIgnoreCase("Request Rejected")){
                JOptionPane.showMessageDialog(null, "request already processed");
                return;
            }
            pa.setStatus("Pending Approval");
            pa.setReceiver(account);
            enterprise.getOrganizationDirectory().getOrganizationList().stream().filter(item -> item instanceof NgoOfficeOrganization)
                    .forEach(item -> item.getWorkQueue().getWorkRequestList().add(pa));
            dB4OUtil.storeSystem(business);
            logger.info(" Request has been raised " + account);
             JOptionPane.showMessageDialog(null, "Request sent");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from pets Available for adoption table");
        }
    }//GEN-LAST:event_reqApprovalBtnActionPerformed

    private void workRequestJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workRequestJTableMouseClicked
        // TODO add your handling code here:
//        if (workRequestJTable.getValueAt(workRequestJTable.getSelectedRow(), 4).toString().equalsIgnoreCase("Pending Approval")) {
//            enableApprvBtn();
//        } else {
//            disableApprvBtn();
//        }
    }//GEN-LAST:event_workRequestJTableMouseClicked

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void assignFieldworkerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignFieldworkerBtnActionPerformed
        // TODO add your handling code here:

        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow >= 0) {
            WorkRequest workQ = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            if (workQ.getStatus().equalsIgnoreCase("Warden Assigned")) {
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                userProcessContainer.add("AssignFieldWorkerJPanel", new AssignFieldWorkerJPanel(userProcessContainer, account, organization, enterprise, business, workQ));
                layout.next(userProcessContainer);
            } else {
                JOptionPane.showMessageDialog(null, "Request already processed/assigned!");
                logger.error("Request already processed/assigned! ");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
        }
    }//GEN-LAST:event_assignFieldworkerBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       int selectedRow = workRequestJTable.getSelectedRow();
       if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table");
            return;
        }
       if (selectedRow >= 0) {
           PetHealthCheckUpRequest req = (PetHealthCheckUpRequest)workRequestJTable.getValueAt(selectedRow, 0);
           if (req.getStatus().equalsIgnoreCase("Request Forwarded")) {
               JOptionPane.showMessageDialog(null, "Request already forwarded");
               return;
           }
           if (req.getStatus().equalsIgnoreCase("Warden Assigned")) {
                req.setMessage("Can you Please look into the issue");
                req.setStatus("Request Forwarded");
                Network netwk=business.getNetworkList().stream().filter(item->item.getEnterpriseDirectory().getEnterpriseList().stream().anyMatch(item1->item1.getName().equalsIgnoreCase(enterprise.getName())))
                                                   .findFirst()
                                                    .orElse(null);
                netwk.getEnterpriseDirectory().getEnterpriseList().stream().filter(item->item instanceof VetHospital)
                                                                            .forEach(item->item.getOrganizationDirectory().getOrganizationList().stream().filter(org->org instanceof ClinicOrganization)
                                                                            .forEach(org->org.getWorkQueue().getWorkRequestList().add(req)));
                dB4OUtil.storeSystem(business);
                JOptionPane.showMessageDialog(null, "Request raised for vet!");
                userProcessContainer.remove(this);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.previous(userProcessContainer);
           }
           else{
               JOptionPane.showMessageDialog(null, "Please assign request first!");
               logger.error(" Please assign request first! ");
           }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void enableApprvBtn() {
        reqApprovalBtn.setVisible(true);
        assignJBtn.setVisible(false);
    }

    public void disableApprvBtn() {
        reqApprovalBtn.setVisible(false);
        assignJBtn.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignFieldworkerBtn;
    private javax.swing.JButton assignJBtn;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton reqApprovalBtn;
    private javax.swing.JComboBox<String> viewReqFilter;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
