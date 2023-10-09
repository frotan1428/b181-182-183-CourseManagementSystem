package com.tpe.repository;


import com.tpe.domain.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepositoryImpl  implements CourseRepository{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Course course) {

      Session session = sessionFactory.openSession();
       Transaction tx=  session.beginTransaction();
       session.saveOrUpdate(course);
       tx.commit();
       session.close();
    }

    @Override
    public List<Course> getAll() {
        Session session = sessionFactory.openSession();
        Transaction tx=  session.beginTransaction();

         List<Course> courseList = session.createQuery("FROM Course",Course.class).getResultList();
        tx.commit();
        session.close();
        return courseList;
    }

    @Override
    public Optional<Course> findById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx=  session.beginTransaction();

         Course course= session.get(Course.class,id);

         Optional<Course> otCourse= Optional.ofNullable(course);

         // if it take a null value it says throw an exceptions ,Instead of null ,an empty Optional is return;

         tx.commit();
         session.close();
         return otCourse;

    }

    @Override
    public void delete(Long id) {
         Session session = sessionFactory.openSession();
         Transaction tx=  session.beginTransaction();
          Course course=   session.load(Course.class,id);
          session.delete(course);
           tx.commit();
          session.close();


    }


}
