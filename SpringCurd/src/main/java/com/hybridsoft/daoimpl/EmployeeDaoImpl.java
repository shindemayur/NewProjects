package com.hybridsoft.daoimpl;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybridsoft.bean.Emplyoee;
import com.hybridsoft.idao.*;

public class EmployeeDaoImpl  implements IEmplyoeeDao {

	@Autowired
	private SessionFactory hibernateSessionFactory;
	
	

	public void setHibernateSessionFactory(SessionFactory sf)
	{
		this.hibernateSessionFactory = sf;
	}


	public void addEmplyee(Emplyoee e)
	{
		// TODO Auto-generated method stub
		Session session = hibernateSessionFactory.openSession();
		session.saveOrUpdate(e);
		System.out.println("done");
			
	}


	public ArrayList<Emplyoee> getlist() 
	{
		// TODO Auto-generated method stub
		
		Session session=hibernateSessionFactory.openSession();
		ArrayList<Emplyoee> Emplist=new ArrayList<Emplyoee>();
		Criteria cr=session.createCriteria(Emplyoee.class);
		Emplist=(ArrayList<Emplyoee>)cr.list();
		return Emplist;
	}

	
	public ArrayList<Emplyoee> getpagination(int page, int recordePerPage)
	{
		 
		Session session=hibernateSessionFactory.openSession();
		Transaction tr = null;
		try {
		    tr = session.beginTransaction();
		    Criteria cr = session.createCriteria(Emplyoee.class);
		    cr.setFirstResult((page - 1) * recordePerPage);
		    cr.setMaxResults(recordePerPage);
		    ArrayList<Emplyoee> Emplist =(ArrayList<Emplyoee>) cr.list();
		    tr.commit();

		    /*if (Emplist.isEmpty()) {
			if (log.isDebugEnabled()) {
			    log.debug("Admin users are not exist");
			}
			return null;
		    } else {
			if (log.isDebugEnabled()) {
			    log.debug("Found " + Emplist.size() + " Admin users");
			}
			*/
			return Emplist;
		  //  }
		
		} catch (RuntimeException ex) {
		  //  log.error(ex);
		    if (tr != null) {
			tr.rollback(); // roll back the transaction due to runtime error
		    }
		    return null;
		}
	 }


	

	public void deletedata(int a) {
		// TODO Auto-generated method stub
		
		
	}


	
}
