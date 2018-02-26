/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bwf.gui;

import com.bwf.car.Car;
import com.bwf.gui.service.ProcedureService;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CarDropFrame extends javax.swing.JFrame {
    private ProcedureService pService ;     //在各层之间控制行为的服务层
    private Car stateChangeedCar = null;
    private int index;
    public CarDropFrame(ProcedureService pService) {
    	this.pService = pService;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dropLicenseNumberField = new javax.swing.JTextField();
        dropCarMessagePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        
        tableModel = new DefaultTableModel(null,
            new String [] {
                "车牌号", "发动机号", "车名", "颜色", "出厂日期", "里程", "燃油类型", "租车押金", "日租金", "状况"
            });
        dropCarTable = new javax.swing.JTable();
        abandonDropButton = new javax.swing.JButton();
        ensurDropButton = new javax.swing.JButton();
        carSarchButton = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("汽车报废");

        jLabel1.setText("输入要报废的汽车车牌号：");

        dropCarMessagePanel.setToolTipText("报废车信息");

        dropCarTable.setModel(tableModel);
            
        dropCarTable.setRowHeight(25);
        jScrollPane1.setViewportView(dropCarTable);
        if (dropCarTable.getColumnModel().getColumnCount() > 0) {
            dropCarTable.getColumnModel().getColumn(0).setResizable(false);
            dropCarTable.getColumnModel().getColumn(1).setResizable(false);
            dropCarTable.getColumnModel().getColumn(2).setResizable(false);
            dropCarTable.getColumnModel().getColumn(3).setResizable(false);
            dropCarTable.getColumnModel().getColumn(4).setResizable(false);
            dropCarTable.getColumnModel().getColumn(5).setResizable(false);
            dropCarTable.getColumnModel().getColumn(6).setResizable(false);
            dropCarTable.getColumnModel().getColumn(7).setResizable(false);
        }

        abandonDropButton.setText("取消报废");

        ensurDropButton.setText("确认报废");
        ensurDropButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ensurDropButtonActionPerformed(evt);
            }
        });
        abandonDropButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abandonDropButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout dropCarMessagePanelLayout = new javax.swing.GroupLayout(dropCarMessagePanel);
        dropCarMessagePanel.setLayout(dropCarMessagePanelLayout);
        dropCarMessagePanelLayout.setHorizontalGroup(
            dropCarMessagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dropCarMessagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dropCarMessagePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ensurDropButton)
                .addGap(140, 140, 140)
                .addComponent(abandonDropButton)
                .addGap(137, 137, 137))
        );
        dropCarMessagePanelLayout.setVerticalGroup(
            dropCarMessagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropCarMessagePanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dropCarMessagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abandonDropButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ensurDropButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        carSarchButton.setText("搜索");
        carSarchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carSarchButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dropLicenseNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(carSarchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dropCarMessagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dropLicenseNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(carSarchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dropCarMessagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }
    
    private void abandonDropButtonMouseClicked(java.awt.event.MouseEvent evt) { 
    	this.dispose();
    }
    
    private void ensurDropButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ensurDropButtonActionPerformed
    	ArrayList<Car> carList = pService.getCarList();
    	if(stateChangeedCar != null){
    		stateChangeedCar.setState(Car.STATE_BAOFEI);
    		carList.set(index, stateChangeedCar);
    		pService.setCarList(carList);
    		JOptionPane.showMessageDialog(this, "报废成功！");
    	}
    }

    private void carSarchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carSarchButtonMouseClicked
        String licenseNumber =dropLicenseNumberField.getText();
        ArrayList<Car> carList = pService.getCarList();
        for(Car car : carList){
            if(licenseNumber.trim().equals(car.getLicenseNumber())){
            	index = carList.indexOf(car);
                stateChangeedCar = car;
            }
        }
        if(stateChangeedCar != null){
            if(stateChangeedCar.getState().equals(Car.STATE_BAOFEI)){
                JOptionPane.showMessageDialog(this, "该车已报废。。。");
            }else if(stateChangeedCar.getState().equals(Car.STATE_YICHUZU)){
            	JOptionPane.showMessageDialog(this, "该车已经出租，暂时不能报废！");
            }else{
                    //将信息显示到表格中
            	Object[] info = stateChangeedCar.returnInfo();
            	tableModel.addRow(info);
            }
        }
        else
        	JOptionPane.showMessageDialog(this, "未找到该车牌号！库存无此车");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abandonDropButton;
    private javax.swing.JButton carSarchButton;
    private javax.swing.JPanel dropCarMessagePanel;
    private javax.swing.JTable dropCarTable;
    private javax.swing.JTextField dropLicenseNumberField;
    private javax.swing.JButton ensurDropButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private DefaultTableModel tableModel ;
    // End of variables declaration//GEN-END:variables
}
