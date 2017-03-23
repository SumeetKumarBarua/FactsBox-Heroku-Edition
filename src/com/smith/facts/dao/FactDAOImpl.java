package com.smith.facts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




import com.smith.facts.bean.Facts;
import com.smith.facts.resources.JDBCConnection;


public class FactDAOImpl implements FactDAO {
 
	@Override
	public List<Facts> getAllFacts() throws Exception {
		// TODO Auto-generated method stub
		List<Facts> result=new ArrayList<Facts>();
		Connection connection = JDBCConnection.jdbcConnection();
		Session session=null;
		try{			
			String sql="select * from fact_box";
	        PreparedStatement ps=connection.prepareStatement(sql);
	        ResultSet rs=ps.executeQuery();
	        
	        while(rs.next())
	        {	Facts f=new Facts();
	        	String desc=rs.getString("fact_description");
	        	String cat=rs.getString("fact_category");
	        	Integer id=rs.getInt("fact_id");
	        	f.setFactId(id);
	        	f.setFactDesc(desc);
	        	f.setFactCategory(cat);
	        	result.add(f);
	        }
	       
		}
		catch(Exception e)
		{e.printStackTrace();
			throw new Exception("DATABASE_TECHINAL_ERROR"); 
		}finally {
			if(connection!=null)
	        	 connection.close();
			if(session!=null)
				session.close();
		} 
				
			return result;
	}
	
	
	@Override
	public List<Facts> getFact(Integer factId) throws Exception {
		// TODO Auto-generated method stub
		List<Facts> result=new ArrayList<Facts>();
		Connection connection = JDBCConnection.jdbcConnection();
		Session session=null;
		try{			
			String sql="select * from fact_box where fact_Id=?";
	        PreparedStatement ps=connection.prepareStatement(sql);
	        ps.setInt(1, factId);
	        ResultSet rs=ps.executeQuery();
	        
	        while(rs.next())
	        {	Facts f=new Facts();
	        	String desc=rs.getString("fact_description");
	        	String cat=rs.getString("fact_category");
	        	Integer i=rs.getInt("fact_id");
	        	System.out.println(cat);
	        	f.setFactDesc(desc);
	        	f.setFactCategory(cat);
	        	result.add(f);
	        }
	        //System.out.println(result);
		}
		catch(Exception e)
		{e.printStackTrace();
			throw new Exception("DATABASE_TECHINAL_ERROR"); 
		}finally {
			if(connection!=null)
	        	 connection.close();
			if(session!=null)
				session.close();
		} 
				
			return result;
	}
	

	
	
	@Override
	public List<Facts> getFactsCategory(String category) throws Exception {
		
		//List<String> result=new ArrayList<String>();
		Connection connection = JDBCConnection.jdbcConnection();
		Session session=null;
		List<Facts> result=new ArrayList<Facts>();
		try{			
			String sql="select fact_description,fact_id from fact_box where fact_Category=?";
	        PreparedStatement ps=connection.prepareStatement(sql);
	        ps.setString(1, category.toUpperCase());
	        ResultSet rs=ps.executeQuery();
	        
	        while(rs.next())
	        {	Facts f=new Facts();
	        	String desc=rs.getString("fact_description");
	           	Integer id=rs.getInt("fact_id");
	        	
	        	f.setFactDesc(desc);
	        	f.setFactId(id);
	        	result.add(f);
	        	//result.add(desc)
	        
	        }
	        //System.out.println(result);
		}
		catch(Exception e)
		{e.printStackTrace();
			throw new Exception("DATABASE_TECHINAL_ERROR"); 
		}finally {
			if(connection!=null)
	        	 connection.close();
			if(session!=null)
				session.close();
		} 
				
			return result;
	}

	
	@Override
	public List<Integer> getCountCategories() throws Exception {
		Connection connection = JDBCConnection.jdbcConnection();
		Session session=null;
		FactDAOImpl dao=new FactDAOImpl();
		List<String> category= dao.getDistinctcatergories();
		List<Integer> cat = new ArrayList<>();
		try {
			for(int i=0;i<category.size();i++){
			String c=category.get(i);
			String sql="select count(*) from fact_box where fact_Category=?";
	        PreparedStatement ps=connection.prepareStatement(sql);
	        ps.setString(1, c);
	        ResultSet rs=ps.executeQuery();
	       // System.out.println("-"+rs);
	        
	        while(rs.next())
	        {  	int size=0;
	        	size=rs.getInt(1);
	           	cat.add(size);
	        }
	        
			}
			//System.out.println(cat);
			return cat;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("DATABASE_TECHINAL_ERROR");
		}finally {
			if(connection!=null)
	        	 connection.close();
			if(session!=null)
				session.close();
		} 
	}


	
	
	@Override
	public List<String> getDistinctcatergories() throws Exception {
		
		List<String> list=new ArrayList<String>();
		Connection connection = JDBCConnection.jdbcConnection();
		Session session=null;
		try {
			String sql="select distinct fact_category from fact_box order by fact_category";
	        PreparedStatement ps=connection.prepareStatement(sql);
	        ResultSet rs=ps.executeQuery();
	        
	        while(rs.next())
	        {	
	        	String s=rs.getString("fact_Category");
	        	list.add(s);
	        }
	       // System.out.println(list);
				return list;

			} catch (Exception exception) {
				exception.printStackTrace();
				throw new Exception("DATABASE_TECHINAL_ERROR");
			} finally {
				if(connection!=null)
		        	 connection.close();
				if(session!=null)
					session.close();
			} 
		}


	 public static void main(String[] args) {
		FactDAOImpl dao=new FactDAOImpl();
		try {
			//System.out.println(dao.getCountCategories());
			//System.out.println(dao.getFactsCategory("physics").get(14).getFactId());
			//System.out.println(dao.getDistinctcatergories());
			//System.out.println(dao.getFact(1001).get(0).getFactId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
}