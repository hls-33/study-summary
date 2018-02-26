package com.bwf.gui;

import com.bwf.car.Car;
import java.util.ArrayList;
import com.bwf.gui.service.ProcedureService;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BackStaeManagement extends javax.swing.JFrame {

    private ProcedureService pService;     //在各层之间控制行为的服务层

    public BackStaeManagement(ProcedureService pService) {
        this.pService = pService;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        carViewPanel = new javax.swing.JPanel();
        carViewScrollPane = new javax.swing.JScrollPane();
        tableModel = new DefaultTableModel(null,
        new String [] {
            "车牌号", "发动机号", "车名", "颜色", "出厂日期", "里程", "燃油类型", "租车押金", "日租金", "状况","汽车类型"
        });
        dropCarTable = new javax.swing.JTable(tableModel);
        jLabel1 = new javax.swing.JLabel();
        backstate = new javax.swing.JMenuBar();
        AdminManageMenu = new javax.swing.JMenu();
        modifyPswMenuItem = new javax.swing.JMenuItem();
        carManageMenu = new javax.swing.JMenu();
        addNewCarMenuItem = new javax.swing.JMenuItem();
        dropCarMenuItem = new javax.swing.JMenuItem();
        carViewMenuItem = new javax.swing.JMenuItem();
        rentalManageMenu = new javax.swing.JMenu();
        carRentMenuItem = new javax.swing.JMenuItem();
        carReturnMenuItem = new javax.swing.JMenuItem();
        rentalViewMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("汽车租赁系统后台管理");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        dropCarTable.setRowHeight(25);
        carViewScrollPane.setViewportView(dropCarTable);

        javax.swing.GroupLayout carViewPanelLayout = new javax.swing.GroupLayout(carViewPanel);
        carViewPanel.setLayout(carViewPanelLayout);
        carViewPanelLayout.setHorizontalGroup(
            carViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(carViewScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );
        carViewPanelLayout.setVerticalGroup(
            carViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(carViewScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        );

        jLabel1.setText("尊敬的"+pService.getAdminList().get(0).getName() +"先生，欢迎您登陆汽车租赁系统");

        AdminManageMenu.setText("账号管理");

        modifyPswMenuItem.setText("修改密码");
        modifyPswMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyPswMenuItemActionPerformed(evt);
            }
        });
        AdminManageMenu.add(modifyPswMenuItem);

        backstate.add(AdminManageMenu);

        carManageMenu.setText("汽车管理");

        addNewCarMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        addNewCarMenuItem.setText("新车入库");
        addNewCarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewCarMenuItemActionPerformed(evt);
            }
        });
        carManageMenu.add(addNewCarMenuItem);

        dropCarMenuItem.setText("汽车报废");
        dropCarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropCarMenuItemActionPerformed(evt);
            }
        });
        carManageMenu.add(dropCarMenuItem);

        carViewMenuItem.setText("汽车信息浏览");
        carViewMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carViewMenuItemActionPerformed(evt);
            }
        });
        carManageMenu.add(carViewMenuItem);

        backstate.add(carManageMenu);

        rentalManageMenu.setText("租赁管理");

        carRentMenuItem.setText("汽车租借");
        carRentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carRentMenuItemActionPerformed(evt);
            }
        });
        rentalManageMenu.add(carRentMenuItem);

        carReturnMenuItem.setText("汽车归还");
        carReturnMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carReturnMenuItemActionPerformed(evt);
            }
        });
        rentalManageMenu.add(carReturnMenuItem);

        rentalViewMenuItem.setText("租赁信息浏览");
        rentalViewMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentalViewMenuItemActionPerformed(evt);
            }
        });
        rentalManageMenu.add(rentalViewMenuItem);

        backstate.add(rentalManageMenu);

        setJMenuBar(backstate);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
            .addComponent(carViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void dropCarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        pService.dropCar();
    }

    private void modifyPswMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        pService.modifyPsw();
    }

    private void carViewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        //遍历carList，显示其信息
        ArrayList<Car> carList = pService.getCarList();
        if(carList == null)
        	JOptionPane.showMessageDialog(this, "没有任何信息");
        else{
        	 for (Car car : carList) {
             	Object[] info = car.returnInfo();
             	tableModel.addRow(info);
             }
        }
    }

    private void addNewCarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        pService.addNewCar();
    }
    
    //租赁管理事件
    private void carRentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                                
    	pService.rentCar();
    	
    }
    private void carReturnMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    	pService.returnCar();
    	
    }                                                 

    private void rentalViewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                                   
    	pService.rentalView();
    	
    }  
    
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {
    	int confirm = JOptionPane.showConfirmDialog(this, "需要保存么？");
    	if(confirm == JOptionPane.YES_OPTION){
    		pService.carSave(); //关闭窗口时保存数据，防止程序异常关闭而数据未保存
    		pService.recordSave();
    		JOptionPane.showMessageDialog(this, "保存成功！");
    	}
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AdminManageMenu;
    private javax.swing.JMenuItem addNewCarMenuItem;
    private javax.swing.JMenuBar backstate;
    private javax.swing.JMenu carManageMenu;
    private javax.swing.JMenuItem carRentMenuItem;
    private javax.swing.JMenuItem carReturnMenuItem;
    private javax.swing.JMenuItem carViewMenuItem;
    private javax.swing.JPanel carViewPanel;
    private javax.swing.JScrollPane carViewScrollPane;
    private javax.swing.JMenuItem dropCarMenuItem;
    private javax.swing.JTable dropCarTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem modifyPswMenuItem;
    private javax.swing.JMenu rentalManageMenu;
    private javax.swing.JMenuItem rentalViewMenuItem;
    private DefaultTableModel tableModel ;
    // End of variables declaration//GEN-END:variables
}
