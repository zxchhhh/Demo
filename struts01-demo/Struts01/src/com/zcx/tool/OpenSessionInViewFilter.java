package com.zcx.tool;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import java.io.IOException;


public class OpenSessionInViewFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		Session session = null;
		Transaction tx = null;
		try {
			// ���󵽴�ʱ����Session����������
			 session=HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			// ִ����������
			arg2.doFilter(request, response);
			// ������Ӧʱ���ύ����
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
