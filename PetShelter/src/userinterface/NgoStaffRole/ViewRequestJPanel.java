package userinterface.NgoStaffRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.NgoOfficeOrganization;
import Business.Organization.PetShelterOrganization;
import Business.POJO.Users;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PetAdoptionWorkRequest;
import Business.WorkQueue.PetHealthCheckUpRequest;
import Business.WorkQueue.ReportStrayAnimalRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rishijatania
 */
public class ViewRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private NgoOfficeOrganization ngoOfficeOrganization;
    private EcoSystem business;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    /**
     * Creates new form ViewReportedAnimalsJPanel
     */
    public ViewRequestJPanel(JPanel userProcessContainer, UserAccount account, NgoOfficeOrganization ngoOfficeOrganization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ngoOfficeOrganization = ngoOfficeOrganization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
        valueLabel.setText(enterprise.getName());
    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        model.setRowCount(0);
        DefaultTableModel model1 = (DefaultTableModel) workRequestJTable1.getModel();
        model1.setRowCount(0);
        String requestType = viewReqFilter.getSelectedItem() != null ? viewReqFilter.getSelectedItem().toString() : "";
       
        registerAnimalBtn.setEnabled(true);
        switch (requestType) {
            case "Stray Animal Request":
                 populateStrayReq(model);
                break;
            case "Pet Adoption Request":
                petAdoptionReq(model1);
                break;
            default:
                populateStrayReq(model);
                petAdoptionReq(model1);
        }
    }
    
    public void petAdoptionReq(DefaultTableModel model){
        model.setRowCount(0);
         registerAnimalBtn.setEnabled(false);
                ngoOfficeOrganization.getWorkQueue().getWorkRequestList().stream()
                        .filter(wq -> wq instanceof PetAdoptionWorkRequest)
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
    }
    
    public void populateStrayReq(DefaultTableModel model){
        model.setRowCount(0);
         registerAnimalBtn.setEnabled(true);
                enterprise.getWorkQueue().getWorkRequestList()
                        .stream().filter(wq -> wq instanceof ReportStrayAnimalRequest)
                        .forEach(request -> {
                            Object[] row = new Object[12];
                            row[0] = ((ReportStrayAnimalRequest) request).getComments();
                            row[1] = ((ReportStrayAnimalRequest) request);
                            row[2] = request.getStatus();
                            row[3] = ((ReportStrayAnimalRequest) request).getStreet();
                            row[4] = ((ReportStrayAnimalRequest) request).getCity();
                            row[5] = ((ReportStrayAnimalRequest) request).getIssueType();
                            row[6] = ((ReportStrayAnimalRequest) request).getUrgencyType();
                            row[7] = ((ReportStrayAnimalRequest) request).getAnimalType();
                            row[8] = ((ReportStrayAnimalRequest) request).getFieldWorkerAssigned() == null ? "Not Assigned" : ((ReportStrayAnimalRequest) request).getFieldWorkerAssigned();
                            row[9] = ((ReportStrayAnimalRequest) request).getComments();
                            row[10] = ((ReportStrayAnimalRequest) request).getSender();
//                                                                    getReportedByUser()==null?"":((ReportStrayAnimalRequest) request).getReportedByUser();
                            row[11] = ((ReportStrayAnimalRequest) request).getReceiver() == null ? "Not Assigned" : ((ReportStrayAnimalRequest) request).getReceiver();
                            model.addRow(row);
                        });
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
        registerAnimalBtn = new javax.swing.JButton();
        refreshTestJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        viewReqFilter = new javax.swing.JComboBox<>();
        backJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable1 = new javax.swing.JTable();
        reqApprovalBtn = new javax.swing.JButton();
        filterStatus = new javax.swing.JComboBox<>();
        rejectBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Comments", "RequestId", "Req Status", "Street", "City", "Animal status", "Req Type", "Animal type", "FW Name", "Result", "Request Raised By", "Receiver"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 71, 808, 139));

        registerAnimalBtn.setBackground(new java.awt.Color(0, 153, 255));
        registerAnimalBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        registerAnimalBtn.setText("Forward Request");
        registerAnimalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerAnimalBtnActionPerformed(evt);
            }
        });
        add(registerAnimalBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 241, -1, 45));

        refreshTestJButton.setBackground(new java.awt.Color(0, 153, 255));
        refreshTestJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });
        add(refreshTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 27, -1, -1));

        enterpriseLabel.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 28, 127, 30));

        valueLabel.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        valueLabel.setForeground(new java.awt.Color(226, 153, 0));
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 27, 158, 26));

        viewReqFilter.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        viewReqFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Stray Animal Request", "Pet Adoption Request", " " }));
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
        add(viewReqFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 29, 275, -1));

        backJButton.setBackground(new java.awt.Color(0, 153, 255));
        backJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 531, -1, 45));

        workRequestJTable1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        workRequestJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RequestId", "PetId", "Request Raised By", "Receiver", "Status", "Request Date", "Resolve Date", "Comments"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable1.setRowHeight(20);
        jScrollPane2.setViewportView(workRequestJTable1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 353, 808, 139));

        reqApprovalBtn.setBackground(new java.awt.Color(0, 153, 255));
        reqApprovalBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        reqApprovalBtn.setText("Approve");
        reqApprovalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqApprovalBtnActionPerformed(evt);
            }
        });
        add(reqApprovalBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 531, 108, 45));

        filterStatus.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        filterStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Raised", "Processed", "Pending Approval", "Approved", " " }));
        filterStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterStatusActionPerformed(evt);
            }
        });
        add(filterStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 290, -1, -1));

        rejectBtn.setBackground(new java.awt.Color(0, 153, 255));
        rejectBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rejectBtn.setText("Reject");
        rejectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectBtnActionPerformed(evt);
            }
        });
        add(rejectBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 531, 105, 45));
    }// </editor-fold>//GEN-END:initComponents

    private void registerAnimalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerAnimalBtnActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow <= 0) {
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
            return;
        }
        if (selectedRow >= 0) {
            WorkRequest workQ = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 1);
            if(workQ.getStatus().equalsIgnoreCase("New Request")){
            enterprise.getOrganizationDirectory().getOrganizationList().stream().filter((e) -> e instanceof PetShelterOrganization).forEachOrdered((e) -> {
                e.getWorkQueue().getWorkRequestList().add(workQ);
                workQ.setReceiver(userAccount);
                workQ.setStatus("Request Forwarded");
                populateRequestTable();
                System.out.println(e.getWorkQueue().getWorkRequestList());
            });
            JOptionPane.showMessageDialog(null, "Request Sent!");
            dB4OUtil.storeSystem(business);
        }
            else {
                JOptionPane.showMessageDialog(null, "Request already processed at our end!");
                return;
            }
        }
        
    }//GEN-LAST:event_registerAnimalBtnActionPerformed

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed
        populateRequestTable();
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_backJButtonActionPerformed

    private void viewReqFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewReqFilterActionPerformed
        // TODO add your handling code here:
        populateRequestTable();
    }//GEN-LAST:event_viewReqFilterActionPerformed

    private void viewReqFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_viewReqFilterItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_viewReqFilterItemStateChanged

    private void reqApprovalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqApprovalBtnActionPerformed
        // TODO add your handling code here:
        Integer selectedRow = workRequestJTable1.getSelectedRow();
         if (selectedRow >= 0) {
        PetAdoptionWorkRequest pa = (PetAdoptionWorkRequest) workRequestJTable1.getValueAt(selectedRow, 0);
        if(pa.getStatus().equalsIgnoreCase("Approved") || pa.getStatus().equalsIgnoreCase("Request Rejected")){
            JOptionPane.showMessageDialog(null, "request already processed");
        return;
        }
            pa.setStatus("Approved");
            pa.setReceiver(userAccount);
            pa.getPet().setCurrentOwner((Users) pa.getSender());
            pa.getPet().setIsAdopted(true);
            pa.getPet().setIsAvailableForAdoption(Boolean.FALSE);
            pa.getPet().setIsStray(false);
            pa.setResolveDate(new Date());
            Map a = new HashMap<String, String>();
            a.put("Approval Comment", "Congratulations and thankyou for adopting the pet.");
            pa.setComments(a);
            JOptionPane.showMessageDialog(null, "Congratulations and thankyou for adopting the pet.");
            dB4OUtil.storeSystem(business);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from pets Available for adoption table");
        }
    }//GEN-LAST:event_reqApprovalBtnActionPerformed

    private void filterStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterStatusActionPerformed
        // TODO add your handling code here:
        populateRequestTable();
    }//GEN-LAST:event_filterStatusActionPerformed

    private void rejectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectBtnActionPerformed
        // TODO add your handling code here:
         Integer selectedRow = workRequestJTable1.getSelectedRow();
        if (selectedRow >= 0) {
        PetAdoptionWorkRequest pa = (PetAdoptionWorkRequest) workRequestJTable1.getValueAt(selectedRow, 0);
        if(pa.getStatus().equalsIgnoreCase("Request Rejected") || pa.getStatus().equalsIgnoreCase("Approved request")){
            JOptionPane.showMessageDialog(null, "request already processed");
        return;
        }
            pa.setStatus("Request Rejected");
            pa.getPet().setIsAvailableForAdoption(Boolean.TRUE);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from pets Available for adoption table");
        }
    }//GEN-LAST:event_rejectBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JComboBox<String> filterStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton registerAnimalBtn;
    private javax.swing.JButton rejectBtn;
    private javax.swing.JButton reqApprovalBtn;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JComboBox<String> viewReqFilter;
    private javax.swing.JTable workRequestJTable;
    private javax.swing.JTable workRequestJTable1;
    // End of variables declaration//GEN-END:variables
}
