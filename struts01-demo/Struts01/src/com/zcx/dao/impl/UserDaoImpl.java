package com.zcx.dao.impl;

import com.zcx.dao.UserDao;
import com.zcx.entity.User;
import com.zcx.tool.HibernateSessionFactory;
import com.zcx.tool.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transaction.CMTTransaction;

import java.util.List;

/**
 * @author zcx
 * @version 1.0
 * @date 2020/3/11 22:37
 */
public class UserDaoImpl implements UserDao {


    public static void main(String[] args) {
        System.out.println(Math.round(-11.5));
        String str = "123456789";
        // 从第几位截到第几位，不包括一开始截的那位 ，这也只截第三和第四位
        str =str.substring(2,4);
        System.out.println(str);
        int x=5*3;
        int y=x+5/x+3;
        System.out.println(y) ;
    }


    // 验证登录
    public User checkUser(User user) {
        Session session= HibernateUtil.opentSession();
        String hql="from User where name=:name and password=:password ";
        List<User> list = session.createQuery(hql)
                .setParameter("name",user.getName())
                .setParameter("password",user.getPassword()).list();
        return list!=null && list.size()>0?list.get(0):null;
    }

    // 展示全部
    public List<User> getUsers() {
        Session session= HibernateUtil.opentSession();
        try {
            String hql="from User";
            List<User> list = session.createQuery(hql).list();
//            session.clear();
            return list.size()>0?list:null;
        }  finally {
            HibernateUtil.closeSession();
        }
    }

    // 增加
    public int addUser(User user) {
        try {
            Session session= HibernateUtil.opentSession();
            Transaction tran =session.beginTransaction();
            int result = (Integer) session.save(user);
            tran.commit();
            return result;
        } catch (HibernateException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // 删除
    public int delUser(Integer id) {
        Session session= HibernateUtil.opentSession();
        try {
            Transaction tran =session.beginTransaction();
            User user1 =(User) session.load(User.class, id);
            session.delete(user1);
//        session.flush();
            tran.commit();
            return 1;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    // 查找
    public User getUser(Integer id) {
             Session session= HibernateUtil.opentSession();
            User user = (User) session.load(User.class,id);
            return user != null ? user :null;
    }

    // 修改
    public int updateUser(User user) {
        Session session= HibernateUtil.opentSession();
        try {
            Transaction tran =session.beginTransaction();
            session.update(user);
            tran.commit();
            return 1;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    // 查询
    public List<User> selctUser(Integer id) {
        Session session= HibernateUtil.opentSession();
        String hql="from User where id=:id ";
        List<User> list = session.createQuery(hql)
                .setParameter("id",id).list();
        return list;
    }


}
