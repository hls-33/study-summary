package com.bikesystem.txz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.BikeKind;
import com.bikesystem.hs.dao.BikeKindDaoImpl;
import com.bikesystem.txz.ipml.service.BikeKindServiceIpml;

import net.sf.json.JSONArray;

/**
 *查询所有的自行车种类信息
 */
@WebServlet("/allbikekind")
public class QueryAllBikeKindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BikeKindServiceIpml bikekindservice;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllBikeKindServlet() {
        super();
        bikekindservice=new BikeKindServiceIpml(new BikeKindDaoImpl());
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BikeKind> arr=bikekindservice.queryAllBikeKind();
		JSONArray jsarr=JSONArray.fromObject(arr);
		PrintWriter out=response.getWriter();
		out.write(jsarr.toString());
	}

}
