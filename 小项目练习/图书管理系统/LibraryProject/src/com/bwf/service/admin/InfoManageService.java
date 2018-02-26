package com.bwf.service.admin;

import java.util.ArrayList;

import com.bwf.entry.Info;

public interface InfoManageService {
	ArrayList<Info> findAll(Info info);
	ArrayList<Info> findAll();
	boolean saveInfo(Info info);
	boolean updateInfo(Info info);
	boolean removeInfo(Info info);
}
