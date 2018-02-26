package com.bwf.car_manage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.bwf.admin.SystemManager;
import com.bwf.rental_manage.DateHelper;
import com.bwf.rental_manage.RentalRecord;
import com.bwf.uitools.UiTools;

/**
 * CarMgr类是对系统中“汽车相关操作的抽象”，该类是整个系统中最复杂的类，它对汽车入库、报废、浏览，汽车的租借、归还、租赁记录浏览，
 * 而支持这些操作的底层就是对汽车信息和租赁信息的读取和存储。
 * 
 * @author bwfadmin
 */
public class CarMgr {
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Car> carList = new ArrayList<Car>(); // 汽车列表
	private ArrayList<RentalRecord> recordList = new ArrayList<RentalRecord>(); // 租赁记录列表
	private SystemManager sys; // 系统管理对象，通过CarMgr的构造方法传入

	public CarMgr(SystemManager systemManager) {
		load();
		loadRecord();
		sys = systemManager;
	}

	/*
	 * 加载汽车信息
	 */
	@SuppressWarnings("unchecked")
	private void load() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("data"+File.separator+"car.txt"));
			carList = (ArrayList<Car>) ois.readObject();
			ois.close();
		}catch (Exception e) {
			System.out.println("加载Car对象信息异常");
		}
	}

	/*
	 * 存储汽车信息
	 */
	public boolean save() {
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

	/*
	 * 显示“汽车管理”菜单
	 */
	public void showCarMenu() {
		String choose = null;
		do{
			UiTools.printStar(150);
			System.out.println();
			UiTools.printBlack();
			UiTools.printSolid(39);
			System.out.println();
			UiTools.printBlack();
			System.out.println("-  汽车租赁系统>>>>>>后台管理>>>>>>汽车信息管理     -");
			UiTools.printBlack();
			System.out.println("-              1-新车入库                                                -");
			UiTools.printBlack();
			System.out.println("-              2-汽车报废                                                -");
			UiTools.printBlack();
			System.out.println("-              3-汽车信息浏览                                        -");
			UiTools.printBlack();
			UiTools.printSolid(39);
			System.out.println();
			UiTools.printLine();
			System.out.print("请输入菜单编号进行选择，按其他键返回上一级菜单:");
			choose = sc.nextLine();
			switch (choose) {
			case "1":
				carAdd();
				break;
			case "2":
				carStop();
				break;
			case "3":
				carView();
				break;
			default:
				//			save();	//在退出汽车管理模块的时候保存汽车信息
				//直接退出选择，结束方法，返回上一级菜单。
				break;
			}
		}while(choose.equals("1") || choose.equals("2") || choose.equals("3"));
	}

	/*
	 * 汽车信息浏览
	 */
	private void carView() {
		UiTools.printStar(150);
		System.out.println();
		System.out.print("\t\t\t\t\t");
		UiTools.printSolid(43);
		System.out.println();
		System.out.println("\t\t\t\t\t-汽车租赁系统>>>>后台管理>>>>汽车信息管理>>>>汽车信息浏览-");
		System.out.print("\t\t\t\t\t");
		UiTools.printSolid(43);
		System.out.println();
		for(Car car : carList){
			UiTools.printLine(140);
			System.out.println();
			System.out.println(car);
			UiTools.printLine(140);
			System.out.println();
		}
		UiTools.printLine();
		System.out.print("按任意非空格键返回上一级菜单：");
		sc.nextLine();
	}

	/*
	 * 汽车入库
	 */
	private void carAdd() {
		UiTools.printStar(150);
		System.out.println();
		System.out.print("\t\t\t\t\t");
		UiTools.printSolid(41);
		System.out.println();
		System.out.println("\t\t\t\t\t-汽车租赁系统>>>>后台管理>>>>汽车信息管理>>>>新车入库-");
		System.out.print("\t\t\t\t\t");
		UiTools.printSolid(41);
		System.out.println();
		UiTools.printLine();
		System.out.print("请输入汽车发动牌号:");
		String licenseNumber = sc.nextLine();
		UiTools.printLine();
		System.out.print("请输入汽车发动机号:");
		String engineNumber = sc.nextLine();
		UiTools.printLine();
		System.out.print("请输入汽车车名:");
		String carName = sc.nextLine();
		UiTools.printLine();
		System.out.print("请输入汽车颜色:");
		String color = sc.nextLine();
		UiTools.printLine();
		System.out.print("请输入汽车出厂日期:");
		String productionDate = sc.nextLine();
		UiTools.printLine();
		System.out.print("请输入汽车行驶里程:");
		int mileage = sc.nextInt();
		sc.nextLine();
		UiTools.printLine();
		System.out.print("请输入汽车使用燃油类型:");
		String fuelType = sc.nextLine();
		UiTools.printLine();
		System.out.print("请输入汽车租车押金:");
		double rentalMoney = sc.nextDouble();
		UiTools.printLine();
		System.out.print("请输入汽车租车日租金:");
		double dailyRent = sc.nextDouble();
		UiTools.printLine();
		System.out.print("请输入选择汽车类型(1-载客车\t2-载货车):");
		int carType = sc.nextInt();
		if(carType == 1){
			UiTools.printLine();
			System.out.print("请输入载客人数:");
			int seatCapacity = sc.nextInt();
			sc.nextLine();
			Coach coach = new Coach(licenseNumber, engineNumber, carName, color, productionDate,
					mileage, fuelType, rentalMoney, dailyRent,Car.TYPE_ZAIKECHE,seatCapacity);
			if(carList.add(coach)){
				System.out.println("新车信息入库成功");
				//				save();	//将添加后的carList重新写入文件中，覆盖原carList
			}
			else
				System.out.println("新车信息入库失败");
		}
		else if(carType == 2){
			UiTools.printLine();
			System.out.print("请输入载货数:");
			int weight = sc.nextInt();
			sc.nextLine();
			Truck truck = new Truck(licenseNumber, engineNumber, carName, color, productionDate,
					mileage, fuelType, rentalMoney, dailyRent,Car.TYPE_ZAIHUOCHE,weight);
			if(carList.add(truck)){
				System.out.println("新车信息入库成功");
				//				save();	//将添加后的carList重新写入文件中，覆盖原carList
			}
			else
				System.out.println("新车信息入库失败");
		}
		UiTools.printLine();
		System.out.print("按任意非空格键返回上一级菜单：");
		sc.nextLine();
//		sc.close();
	}

	/*
	 * 汽车报废
	 */
	private void carStop() {
		//		load();
		boolean isExit = false;
		do{
			UiTools.printStar(150);
			System.out.println();
			UiTools.printBlack();
			UiTools.printSolid(42);
			System.out.println();
			UiTools.printBlack();
			System.out.println("- 汽车租赁系统>>>>后台管理>>>>汽车信息管理>>>>汽车报废 -");
			UiTools.printBlack();
			UiTools.printSolid(42);
			System.out.println();
			UiTools.printLine();
			System.out.print("请输入要报废的车牌号：");
			String licenseNumber = sc.nextLine();
			int stateIndex = 0;
			Car stateChangeedCar = null;
			boolean isFind = false;
			for(Car car : carList){
				if(licenseNumber.trim().equals(car.getLicenseNumber())){
					stateIndex = carList.indexOf(car);
					stateChangeedCar = car;
					isFind = true;

				}
			}

			if(isFind){
				if(stateChangeedCar.getState().equals(Car.STATE_BAOFEI)){
					System.out.println("该车已经报废！");
				}else if(stateChangeedCar.getState().equals(Car.STATE_YICHUZU)){
					System.out.println("该车已经出租，暂时不能报废！");
				}else{
					UiTools.printLine(140);
					System.out.println();
					System.out.println("请确认要报废的汽车信息："+stateChangeedCar);
					UiTools.printLine(140);
					System.out.println();
					UiTools.printLine();
					System.out.print("确认报废请输入y，按其他键取消报废：");
					if(sc.nextLine().trim().equals("y")){
						stateChangeedCar.setState(Car.STATE_BAOFEI);
						System.out.println("报废成功");
						carList.set(stateIndex, stateChangeedCar);
						//					save();
					}
					else
						System.out.println("报废取消");
				}
			}
			else
				System.out.println("未找到该车牌号！库存无此车");
			UiTools.printLine();
			System.out.print("按c键继续报废，按其他键返回上一级菜单：");
			if(sc.nextLine().trim().equalsIgnoreCase("c"))
				isExit = false;
			else
				isExit = true;
		}while(!isExit);
		//		sc.close();
	}

	/*
	 * 加载汽车租赁记录信息
	 */
	@SuppressWarnings("unchecked")
	private boolean loadRecord() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("data"+File.separator+"record.txt"));
			recordList = (ArrayList<RentalRecord>) ois.readObject();
			ois.close();
			return true;
		}catch (Exception e) {
			System.out.println("加载Record对象信息异常");
		}
		return false;
	}

	/*
	 * 存储汽车租赁记录信息
	 */
	public boolean saveRecord() {
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

	/*
	 * 显示“租赁管理”菜单
	 */
	public void showRentalMenu() {
		String choose = null;
		do{
			System.out.println();
			UiTools.printStar(150);
			System.out.println();
			UiTools.printBlack();
			UiTools.printSolid(39);
			System.out.println();
			UiTools.printBlack();
			System.out.println("-   汽车租赁系统>>>>>>后台管理>>>>>>租赁管理        -");
			UiTools.printBlack();
			System.out.println("-              1-新车出租                                                -");
			UiTools.printBlack();
			System.out.println("-              2-汽车归还                                                -");
			UiTools.printBlack();
			System.out.println("-              3-租赁记录信息浏览                                -");
			UiTools.printBlack();
			UiTools.printSolid(39);
			System.out.println();
			UiTools.printLine();
			System.out.print("请输入菜单编号进行选择，按其他键返回上一级菜单:");
			choose = sc.nextLine();
			switch (choose) {
			case "1":
				carRent();
				break;
			case "2":
				carReturn();
				break;
			case "3":
				recordView();
				break;
			default:
				//			saveRecord();
				//直接退出选择，结束方法，返回上一级菜单。
				break;
			}
		}while(choose.equals("1") || choose.equals("2") || choose.equals("3"));
	}

	/*
	 * 汽车出租
	 */
	public void carRent() {
		//		load();
		boolean isExit = false;
		do{
			UiTools.printStar(150);
			System.out.println();
			UiTools.printBlack();
			UiTools.printSolid(41);
			System.out.println();
			UiTools.printBlack();
			System.out.println("-  汽车租赁系统>>>>后台管理>>>>租赁管理>>>>汽车出租    -");
			UiTools.printBlack();
			UiTools.printSolid(41);
			System.out.println();
			UiTools.printLine();
			System.out.print("请输入要租借的汽车车牌号：");
			String carCph=sc.nextLine();
			boolean isFind = false;
			Car rentedCar = null;
			int rentedIndex = 0;
			for(Car car : carList){
				if(carCph.trim().equals(car.getLicenseNumber())){
					rentedIndex = carList.indexOf(car);
					rentedCar = car;
					isFind = true;
					break;
				}
			}
			if(isFind == false)
				System.out.println("未找到该车牌号！库存无此车");
			else{
				if(rentedCar.getState().equals(Car.STATE_BAOFEI)){
					System.out.println("车辆已报废，无法出租！");
				}else if(rentedCar.getState().equals(Car.STATE_YICHUZU)){
					System.out.println("车辆已出租");
				}else{
					System.out.println("请核对要租借的汽车信息：");
					UiTools.printLine(140);
					System.out.println();
					System.out.println(rentedCar);
					UiTools.printLine(140);
					System.out.println();
					UiTools.printLine();
					System.out.print("请确认是否租用此车(y/n)：");
					if(sc.nextLine().trim().equals("y")){
						UiTools.printLine();
						System.out.print("请输入租车人：");
						String customer = sc.nextLine();
						UiTools.printLine();
						System.out.print("请输入租车人身份证号码：");
						String pid = sc.nextLine();
						UiTools.printLine();
						System.out.print("请输入租车人联系电话：");
						String tel = sc.nextLine();
						double yj = 0.0;
						while(true){
							UiTools.printLine();
							System.out.print("请输入租车实缴押金：");
							yj = sc.nextDouble();
							if(yj >= rentedCar.getRentalMoney())
								break;
							else
								System.out.println("最低租金不够...");
						}
						UiTools.printLine();
						System.out.print("请输入租车天数：");
						int ts = sc.nextInt();
						sc.nextLine();
						RentalRecord rr = new RentalRecord(carCph, sys.getAdmin().getName(), customer, pid, tel, yj, ts);
						rr.setRentDate(DateHelper.getDate(new Date()));	//根据当天日期获取日期字符串
						recordList.add(rr);
						rentedCar.setState(Car.STATE_YICHUZU);
						System.out.println("租车成功！");
					}
				}
				carList.set(rentedIndex, rentedCar);
				//			save();
				//			saveRecord();
			}
			UiTools.printLine();
			System.out.print("继续出租请输入c,其他键返回上一级菜单：");
			if(sc.nextLine().trim().equalsIgnoreCase("c"))
				isExit=false;
			else
				isExit=true;	
		}while(!isExit);
		//		sc.close();
	}

	/*
	 * 汽车归还
	 */
	public void carReturn() {
		//		load();
		//		loadRecord();
		boolean isExit = false;
		do{
			UiTools.printLine();
			System.out.print("请输入要归还的汽车车牌号：");
			String carCph = sc.nextLine();
			Car car = null;
			RentalRecord rentalcord = null;
			int rentalRecordIndex = 0;	//对应的RentalRecord对象再recordList集合中的位置
			int carIndex = 0;		//对应的Car对象再carList集合中的位置
			for(RentalRecord record : recordList){
				if(record.getCarCph().equals(carCph)){
					rentalcord = record;
					rentalRecordIndex = recordList.indexOf(record);
					break;
				}
			}
			for(Car c : carList){
				if(c.getLicenseNumber().equals(carCph)){
					car = c;
					carIndex = carList.indexOf(c);
					break;
				}
			}
			if(car == null || rentalcord == null){
				System.out.println("没有被租用的该汽车");
			}else{
				UiTools.printBlack();
				System.out.println("请核对以下要归还的汽车信息：");
				UiTools.printBlack();
				UiTools.printSolid(20);
				System.out.println();
				UiTools.printBlack();
				System.out.println("-车牌号："+car.getLicenseNumber());
				UiTools.printBlack();
				System.out.println("-车名："+car.getCarName());
				UiTools.printBlack();
				System.out.println("-日租金："+car.getDailyRent());
				if(car.getType().equals(Car.TYPE_ZAIKECHE)){
					Coach coach = (Coach) car;
					UiTools.printBlack();
					System.out.println("-载客人数："+coach.getSeatCapacity());
				}else{
					Truck truck = (Truck) car;
					UiTools.printBlack();
					System.out.println("-载货重量："+truck.getWeight()+"吨");
				}
				UiTools.printBlack();
				System.out.println("-租车人："+rentalcord.getCustomer());
				UiTools.printBlack();
				System.out.println("-已缴纳押金："+rentalcord.getYj());
				UiTools.printBlack();
				System.out.println("-租车日期："+rentalcord.getRentDate());
				String returnDate = DateHelper.getDate(new Date());	//	归还当天日期
				rentalcord.setReturnDate(returnDate);
				UiTools.printBlack();
				System.out.println("-归还当天日期："+returnDate);	
				int dateDiff = DateHelper.getDayDiff(rentalcord.getRentDate(), returnDate);
				rentalcord.setSjts(dateDiff);
				UiTools.printBlack();
				System.out.println("-实际租车天数:"+dateDiff);
				if(car.getType().equals(Car.TYPE_ZAIKECHE)){
					Coach coach = (Coach) car;
					double rental = coach.calcRental(dateDiff);
					rentalcord.setSr(rental);
					UiTools.printBlack();
					System.out.println("-载客车租车费用： ￥"+rental);
				}else{
					Truck truck = (Truck) car;
					double rental =	truck.calcRental(dateDiff);
					rentalcord.setSr(rental);
					UiTools.printBlack();
					System.out.println("-载货车租车费用： ￥"+rental);
				}
				UiTools.printBlack();
				UiTools.printSolid(20);
				System.out.println();
				UiTools.printLine();
				System.out.print("请确认是否要将车归还？(y/n)：");
				if(sc.nextLine().trim().equals("y")){
					double payment =rentalcord.getSr()-rentalcord.getYj();
					double change = 0.0;
					while(true){
						UiTools.printLine();
						System.out.print("请付款（已扣除押金）： ￥"+payment +":");
						double actualPay = sc.nextDouble();
						if(actualPay < payment)
							System.out.println("付款失败，请重新付款");
						else{
							change = actualPay - payment;
							break;
						}
					}
					UiTools.printBlack();
					System.out.println("找零： ￥"+change);
					recordList.set(rentalRecordIndex, rentalcord);
					car.setState(Car.STATE_KONGXIAN);	//归还成功后，将Car的状态设置为空闲
					carList.set(carIndex, car);
					System.out.println("汽车归还成功！");
				}
			}
			//		saveRecord();
			//		save();
			sc.nextLine();
			UiTools.printLine();
			System.out.print("继续归还请输入c,其他键返回上一级菜单：");
			if(sc.nextLine().trim().equalsIgnoreCase("c"))
				isExit=false;
			else
				isExit=true;
		}while(!isExit);
		//		sc.close();
	}

	/*
	 * 租赁记录信息浏览
	 */
	public void recordView() {
		UiTools.printStar(150);
		System.out.println();
		UiTools.printBlack();
		UiTools.printSolid(43);
		System.out.println();
		UiTools.printBlack();
		System.out.println("-汽车租赁系统>>>>后台管理>>>>租赁管理>>>>租赁记录信息浏览-");
		UiTools.printBlack();
		UiTools.printSolid(43);
		System.out.println();
		for(RentalRecord record : recordList){
			UiTools.printLine(150);
			System.out.println();
			System.out.println(record);
			UiTools.printLine(150);
			System.out.println();
		}
		UiTools.printLine();
		System.out.print("按任意非空格键返回上一级菜单：");
		sc.nextLine();
	}

}
