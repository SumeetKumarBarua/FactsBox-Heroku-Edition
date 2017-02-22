package com.smith.facts.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.smith.facts.bean.Facts;
import com.smith.facts.entity.FactsEntity;
import com.smith.facts.resources.HibernateUtility;

public class FactDAOImpl implements FactDAO {

	@Override
	public List<Facts> getFact(Integer factId) throws Exception {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=null;
		Session session=null;
		List<Facts> result=new ArrayList<Facts>();
		try{
			sessionFactory=HibernateUtility.createSessionFactory();
			session=sessionFactory.openSession();
			
			Query query=session.createQuery("select f from FactsEntity f where f.factId=?");
			query.setParameter(0, factId);
			
			
			
			@SuppressWarnings("unchecked")
			List<FactsEntity> facRes=query.list();
			
			Facts facts1 = new Facts();
			
		if (!facRes.isEmpty()) 
		{ 
			for (FactsEntity facts : facRes) {
			
			facts1.setFactDesc(facts.getFactDesc());
			facts1.setFactCategory(facts.getFactCategory());
			
		}
			result.add(facts1);
		}
		}
		catch(Exception e)
		{e.printStackTrace();
			throw new Exception("DATABASE_TECHINAL_ERROR"); 
		} 
		
		finally { 
			if (session.isOpen() || session != null) 
		{ session.close(); } 
		}
			return result;
	}

	
	@Override
	public List<Facts> getFactsCategory(String category) throws Exception {
		SessionFactory sessionFactory=null;
		Session session=null;
		List<Facts> result=new ArrayList<Facts>();
		try{
			sessionFactory=HibernateUtility.createSessionFactory();
			session=sessionFactory.openSession();
			
			Query query=session.createQuery("select f from FactsEntity f where f.factCategory=?"); 
			query.setParameter(0, category.toUpperCase());
			
			
			@SuppressWarnings("unchecked")
			List<FactsEntity> facRes=query.list();
			
			
			
		if (!facRes.isEmpty()) 
		{ 
			
			for (FactsEntity facts : facRes) {
				Facts facts1 = new Facts();
			facts1.setFactDesc(facts.getFactDesc());
			result.add(facts1);
				
		}
			
		}
		}
		catch(Exception e)
		{e.printStackTrace();
			throw new Exception("DATABASE_TECHINAL_ERROR"); 
		} 
		
		finally { 
			if (session.isOpen() || session != null) 
		{ session.close(); } 
		}
			return result;
	}

	

	@Override
	public List<String> getDistinctcatergories() throws Exception {
			SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
			Session session = null;

			try {

				session = sessionFactory.openSession();
				Query query = session
						.createQuery("select DISTINCT f.factCategory from FactsEntity f order by f.factCategory");

				List<String> cat = query.list();
					
				return cat;

			} catch (Exception exception) {
				throw new Exception("DATABASE_TECHINAL_ERROR");
			} finally {
				if (session.isOpen() || session != null) {
					session.close();
				}
			}
		}

	
	@Override
	public List<Integer> getCountCategories() throws Exception {
		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = null;

		FactDAOImpl dao=new FactDAOImpl();
		List<String> category= dao.getDistinctcatergories();
		List<Integer> cat = new ArrayList<>();
		List<Integer> cat1 = new ArrayList<>();
		
		try {

			session = sessionFactory.openSession();
			
			for (String c : category) {
				
			
			Query query = session
					.createQuery("select count(*) from FactsEntity f where f.factCategory=?)");
			query.setParameter(0, c);
			
			cat= query.list();
			
			cat1.addAll(cat);
			}
			return cat1;

		} catch (Exception e) {
			throw new Exception("DATABASE_TECHINAL_ERROR");
		} finally {
			if (session.isOpen() || session != null) {
				session.close();
			}
		}
	}


		
	/* For testing the class
	 * 
	 * public static void main(String[] args) {
		FactDAOImpl dao=new FactDAOImpl();
		try {
			//System.out.println(dao.getFact(1001));
			//System.out.println(dao.getFactsCategory("physics"));
			//System.out.println(dao.getDistinctcatergories());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}*/




}