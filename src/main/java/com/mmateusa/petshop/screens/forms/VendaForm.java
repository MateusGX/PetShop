/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmateusa.petshop.screens.forms;

import com.mmateusa.petshop.Petshop;
import com.mmateusa.petshop.dao.Usuarios;
import com.mmateusa.petshop.dao.Vendas;
import com.mmateusa.petshop.screens.AdmDashboard;
import com.mmateusa.petshop.utils.FormaPagamento;
import com.mmateusa.petshop.utils.VendaStatus;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.decimal4j.util.DoubleRounder;

/**
 *
 * @author Mateus
 */
public class VendaForm extends javax.swing.JPanel {

    /**
     * Creates new form VendaForm
     */
    private int vendaID;
    private Usuarios user;
    private AdmDashboard admDashboard;
    private JDialog dialog;

    public VendaForm(int vendaID, Usuarios user, AdmDashboard admDashboard, JDialog dialog) {
        this.vendaID = vendaID;
        this.user = user;
        this.admDashboard = admDashboard;
        this.dialog = dialog;
        initComponents();
    }

    public VendaForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fPagamentoInpt = new javax.swing.JComboBox<>();
        descontoInpt = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        dinheiroInpt = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Forma de pagamento:");

        fPagamentoInpt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A Vista", "Cheque", "Credito" }));

        descontoInpt.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        jLabel2.setText("Desconto (%):");

        dinheiroInpt.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        jLabel3.setText("Dinheiro:");

        jButton1.setText("Finalizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fPagamentoInpt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(descontoInpt)
                    .addComponent(dinheiroInpt)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 274, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fPagamentoInpt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descontoInpt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dinheiroInpt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Vendas v = Petshop.entityManager.find(Vendas.class, vendaID);
        v.setFuncionario(user);
        v.setFormaPagamento(FormaPagamento.valueOf(fPagamentoInpt.getSelectedItem().toString().replace(" ", "").toLowerCase()));
        v.setData(new Timestamp(System.currentTimeMillis()));
        if(((double) descontoInpt.getValue()) != 0)
            v.setTotal(v.getTotal() - (v.getTotal() * (((double) descontoInpt.getValue()) / 100)));
        
        v.setStatus(VendaStatus.Finalizado);
        Petshop.entityManager.getTransaction().begin();
        Petshop.entityManager.merge(v);
        Petshop.entityManager.getTransaction().commit();
        double troco = ((double) dinheiroInpt.getValue()) - v.getTotal();
        JOptionPane.showConfirmDialog(this, "Venda finalizada!\nO troco ??: R$ " + DoubleRounder.round(troco, 2), "Finalizado", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        this.admDashboard.getVendas();
        this.dialog.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner descontoInpt;
    private javax.swing.JSpinner dinheiroInpt;
    private javax.swing.JComboBox<String> fPagamentoInpt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
