package com.bwf.gui.service;
import com.bwf.admin.*;
import com.bwf.car.*;
import com.bwf.gui.*;
import com.bwf.rental.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class ProcedureService {
    
    //gui的类控制
    private Login login = null;
    private AddNewCarFrame addNewCar = null;
    private BackStaeManagement bsManagement = null;
    private CarDropFrame carDrop = null;
    private CarRent carRent = null;
    private CarReturn carReturn = null;
    private CarReturnPay  carReturnPay = null;
    private ModifyPsw modifyPsw = null;
    //car的类控制
    private Car car = null;
    private Coach coach = null;
    private Truck truck = null;
    //admin的类控制
    private Admin loginAdmin = null;
    //renral的类控制
    private RentalRecord rentalRecord = null;
    //adminList、carList、rentalList
    private ArrayList<Admin> adminList = new ArrayList<>();
    private ArrayList<Car> carList =  new ArrayList<>(); 
    private ArrayList<RentalRecord> recordList =  new ArrayList<>();
    
    public ProcedureService(Login login){
        this.login = login;
    }
    
    //提供adminList、carList、rentalList三个信息集合的getter和setter，方便服务器在各层之间传输数据
    public ArrayList<Car> getCarList() {
        return this.carList;
    }
    public void setCarList(ArrayList<Car> carList) {
        this.carList = carList;
    }
    public ArrayList<RentalRecord> getRecordList() {
        return recordList;
    }
    public void setRecordList(ArrayList<RentalRecord> recordList) {
        this.recordList = recordList;
    }
    public void setAdminList(ArrayList<Admin> adminList) {
        this.adminList = adminList;
    }
    public ArrayList<Admin> getAdminList() {
        return adminList;
    }
    
    //租赁管理之租借
    public void rentCar() {
    	carRent = new CarRent(this);
    	carRent.setVisible(true);
	}
    //租赁管理之归还
	public void returnCar() {
		carReturn = new CarReturn(this);
		carReturn.setVisible(true);
	}
	//租赁管理之查看租借信息
	public void rentalView() {
		
	}
	//租赁管理之归还付款
	public void returnPay(){
		carReturnPay = new CarReturnPay(this);
		carReturnPay.setVisible(true);
				
	}
    
    //汽车管理之汽车报废
    public void dropCar() {
    	carDrop = new CarDropFrame(this);
    	carDrop.setVisible(true);
	}
    
    //汽车管理之新车入库
    public void addNewCar(){
        addNewCar = new AddNewCarFrame(this);
        addNewCar.setVisible(true);
    }
    
    
    //后台界面控制之修改密码
    public void modifyPsw(){
        modifyPsw = new ModifyPsw(this);
        modifyPsw.setVisible(true);
    }
    
    
    //控制登录验证
    public boolean Login(String loginId , String longPsw){
        //在程序启动时，加载文件信息
        adminLoad();
        carLoad();
        recordLoad();
        this.loginAdmin = adminList.get(0);
        if(loginAdmin.getLoginId().trim().equals(loginId) && loginAdmin.getLoginPsw().trim().equals(longPsw)){
            this.login.setVisible(false);;
            bsManagement = new BackStaeManagement(this);
            bsManagement.setVisible(true);
            return true;
        }else{
            JOptionPane.showMessageDialog(login, "用户名或密码错误，GG思密达");
        }
        return false;
    }
    
    //admin文件信息加载
    private  boolean adminLoad() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("data"+File.separator+"admin.txt"));
			ArrayList<Admin> list = (ArrayList<Admin>) ois.readObject();
			if(list != null)
				adminList = list;
			ois.close();
			return true;
		}catch (Exception e) {
			System.out.println("加载Admin对象信息异常");
		} 
		return false;
	}
        //admin文件信息存储
	public boolean adminSave() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("data"+File.separator+"admin.txt"));
			oos.writeObject(adminList);
			oos.flush();
			oos.close();
			return true;
		}catch (Exception e) {
			System.out.println("加载Admin对象信息异常");
		} 
		return false;
	} 
        //car文件信息加载
        @SuppressWarnings("unchecked")
	private void carLoad() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("data"+File.separator+"car.txt"));
			ArrayList<Car> list =  (ArrayList<Car>) ois.readObject();
			if(list != null)
				carList = list;
			ois.close();
		}catch (Exception e) {
			System.out.println("加载Car对象信息异常");
		}
	}
        //car文件信息存储
        public boolean carSave() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("data"+File.separator+"car.txt"));
			oos.writeObject(carList);
			oos.flush();
			oos.close();
			return true;
		}catch (Exception e) {
			System.out.println("存储Car对象信息异常");
		} 
		return false;
	}
        //record文件信息加载
        @SuppressWarnings("unchecked")
	private boolean recordLoad() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("data"+File.separator+"record.txt"));
			ArrayList<RentalRecord> list =  (ArrayList<RentalRecord>) ois.readObject();
			if(list != null)
				recordList = list;
			ois.close();
			return true;
		}catch (Exception e) {
			System.out.println("加载Record对象信息异常");
		}
		return false;
	}
        //record文件信息存储
        public boolean recordSave() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("data"+File.separator+"record.txt"));
			oos.writeObject(recordList);
			oos.flush();
			oos.close();
			return true;
		}catch (Exception e) {
			System.out.println("存储Record对象信息异常");
		} 
		return false;
	}

		

		

		
}
