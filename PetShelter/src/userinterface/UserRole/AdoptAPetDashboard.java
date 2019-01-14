/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.UserRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Enterprise.NgoEnterprise;
import Business.Network.Network;
import Business.POJO.Pet;
import Business.POJO.Users;
import Business.WorkQueue.PetAdoptionWorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author rishijatania
 */
public class AdoptAPetDashboard extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private Users users;
    EcoSystem business;
    Network network;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private final Logger logger = Logger.getLogger(this.getClass());
    /**
     * Creates new form AdoptAPetDashboard
     */
    public AdoptAPetDashboard(JPanel userProcessContainer, Users users, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.users = users;
        this.business=business;
        setCurrentNetwork();
        logger.info(users.getName() + " logged into AdoptAPetDashboard");
        ArrayList<Pet> petsList=business.getPetDirInstance().getListOfPets();
        if(petsList.size() <=  0){
            JOptionPane.showMessageDialog(null, "No pets currently available");
            requestTestJButton.setEnabled(false);
            return;
        }else{
            requestTestJButton.setEnabled(true);
        }
        
    }
    
    public void setCurrentNetwork(){
        network= business.getNetworkList().stream().filter(ntwk->ntwk.getName().equalsIgnoreCase(users.getCity()))
                                                                                .findFirst()
                                                                                .orElse(null);
    }
    
    public void populateRequestTable(){
        ArrayList<Pet> petsList=business.getPetDirInstance().getListOfPets();
        if(petsList.size() <=  0){
            JOptionPane.showMessageDialog(null, "No pets currently available");
            requestTestJButton.setEnabled(false);
            return;
        }else{
            requestTestJButton.setEnabled(true);
        }
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        DefaultTableModel model1 = (DefaultTableModel) adoptionRequestJTable.getModel();
        String requestType=viewReqFilter.getSelectedItem()!=null?viewReqFilter.getSelectedItem().toString():"";
        switch(requestType){
            case "Pet Adoption Request" : populateAdoptionReqTable(model);
                                         break;
            case "Pet Available For Adoption":populateAvailForAdoptTable(model1);
                                              break;
            default: populateAdoptionReqTable(model);
                    populateAvailForAdoptTable(model1);
        }
    }   
    
    public void populateAdoptionReqTable(DefaultTableModel model){
                                        model.setRowCount(0);
                                                    users.getWorkQueue().getWorkRequestList()
                                                       .stream().filter(wq->wq instanceof PetAdoptionWorkRequest)
                                                       .forEach(request->{
                                                           Object[] row = new Object[8];
                                                            row[0] = request;
                                                            row[1] = ((PetAdoptionWorkRequest)request).getPet();
                                                            row[2] = ((PetAdoptionWorkRequest)request).getUser();
                                                            row[3] =((PetAdoptionWorkRequest)request).getReceiver();
                                                            row[4] =((PetAdoptionWorkRequest)request).getStatus();
                                                            row[5] =((PetAdoptionWorkRequest)request).getRequestDate();
                                                            row[6] =((PetAdoptionWorkRequest)request).getResolveDate();
                                                            row[7] =((PetAdoptionWorkRequest)request).getComments();
                                                            model.addRow(row);
                                                         });
    }
    
    
    public void populateAvailForAdoptTable(DefaultTableModel model){
         model.setRowCount(0);
                                             business.getPetDirInstance().getPetsAvailableForAdoption().forEach(pet->{
                                                                                 Object[] row = new Object[5];
                                                                                 row[0] = pet;
                                                                                 row[1] = pet.getAnimalType();
                                                                                 row[2] = pet.getCurrentHealthStatus();
                                                                                 row[3] = pet.getNamePC();
                                                                                 row[4] = pet.getNameNGO();
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

        jCheckBox1 = new javax.swing.JCheckBox();
        requestTestJButton = new javax.swing.JButton();
        refreshTestJButton = new javax.swing.JButton();
        viewReqFilter = new javax.swing.JComboBox<>();
        backJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        adoptionRequestJTable = new javax.swing.JTable();

        jCheckBox1.setText("jCheckBox1");

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        requestTestJButton.setBackground(new java.awt.Color(0, 153, 255));
        requestTestJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        requestTestJButton.setText("Request for Adoption");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });
        add(requestTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 478, -1, 40));

        refreshTestJButton.setBackground(new java.awt.Color(0, 153, 255));
        refreshTestJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });
        add(refreshTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(764, 32, -1, 40));

        viewReqFilter.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        viewReqFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Pet Adoption Request", "Pet Available For Adoption" }));
        viewReqFilter.setSelectedIndex(-1);
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
        add(viewReqFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 34, 299, 40));

        backJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 478, 100, 40));

        workRequestJTable.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        workRequestJTable.setRowHeight(20);
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 822, 195));

        adoptionRequestJTable.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        adoptionRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PetId", "Animal Type", "Health Status", "Pet Center Name", "Ngo Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        adoptionRequestJTable.setRowHeight(20);
        jScrollPane2.setViewportView(adoptionRequestJTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 822, 145));
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed
        Integer selectedRow=adoptionRequestJTable.getSelectedRow();
        
        if(selectedRow>=0){
            
            Pet selectedPet=(Pet)adoptionRequestJTable.getValueAt(selectedRow, 0);
            PetAdoptionWorkRequest pa=new PetAdoptionWorkRequest();
            pa.setRequestId(users.getName()+users.getWorkQueue().getWorkRequestList().size()+1);
            pa.setPet(selectedPet);
            pa.setUser(users);
            pa.setSender(users);
            pa.setRequestDate(new Date());
            pa.setStatus("Raised");
            pa.getPet().setIsAvailableForAdoption(Boolean.FALSE);
            dB4OUtil.storeSystem(business);
            NgoEnterprise ngoEn=(NgoEnterprise)network.getEnterpriseDirectory().getEnterpriseList().stream()
                    .filter(ep->ep.getEnterpriseType().equals(EnterpriseType.Ngo))
                    .filter(ngo->ngo.getName().equalsIgnoreCase(selectedPet.getNameNGO()))
                    .findFirst().orElse(null);
            ngoEn.getOrganizationDirectory().getOrganizationList().stream()
                                    .filter(org->org.getName().equalsIgnoreCase(selectedPet.getNamePC()))
                                    .forEach(org->org.getWorkQueue().getWorkRequestList().add(pa));
            users.getWorkQueue().getWorkRequestList().add(pa);
            JOptionPane.showMessageDialog(null, "Request raised");
            logger.info(users.getName() + " requested for adoption");
                    
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row from pets Available for adoption table");
            logger.error(users.getName() + " Please select a row from pets Available for adoption table");
        }
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed
        populateRequestTable();
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void viewReqFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewReqFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewReqFilterActionPerformed

    private void viewReqFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_viewReqFilterItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_viewReqFilterItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable adoptionRequestJTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JComboBox<String> viewReqFilter;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
