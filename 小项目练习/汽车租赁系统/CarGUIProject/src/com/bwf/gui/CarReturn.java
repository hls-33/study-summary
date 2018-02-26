package com.bwf.gui;

import com.bwf.admin.Admin;
import com.bwf.gui.service.ProcedureService;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class CarReturn extends javax.swing.JFrame {
    private ProcedureService pService ;     //在各层之间控制行为的服务层
    public CarReturn(ProcedureService pService) {
    	this.pService = pService;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        returnLicenseNumberField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        returnCarTable = new javax.swing.JTable();
        ensurReturnButton = new javax.swing.JButton();
        abandonReturnButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tableModel = new DefaultTableModel(null,
                new String [] {
                    "车牌号", "发动机号", "车名", "颜色", "出厂日期", "里程", "燃油类型", "租车押金", "日租金", "状况","类型"
                });
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("输入要归还的汽车车牌号：");

        returnCarTable.setModel(tableModel);
        returnCarTable.setRowHeight(25);
        jScrollPane1.setViewportView(returnCarTable);

        ensurReturnButton.setText("确认归还");
        ensurReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ensurReturnButtonActionPerformed(evt);
            }
        });

        abandonReturnButton.setText("取消归还");

        jLabel2.setText("核对要归还的汽车信息：");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(returnLicenseNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(ensurReturnButton)
                        .addGap(79, 79, 79)
                        .addComponent(abandonReturnButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnLicenseNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abandonReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ensurReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void ensurReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	pService.returnPay();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abandonReturnButton;
    private javax.swing.JButton ensurReturnButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable returnCarTable;
    private javax.swing.JTextField returnLicenseNumberField;
    private DefaultTableModel tableModel ;
    // End of variables declaration//GEN-END:variables
}
