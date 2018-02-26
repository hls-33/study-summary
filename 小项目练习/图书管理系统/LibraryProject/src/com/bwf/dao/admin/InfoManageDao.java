package com.bwf.dao.admin;

import java.util.ArrayList;

import com.bwf.entry.Info;

public interface InfoManageDao {
	ArrayList<Info> findAll();
	ArrayList<Info> findAll(Info info);
	boolean saveInfo(Info info);
	boolean updateInfo(Info info);
	boolean removeInfo(Info info);
}
