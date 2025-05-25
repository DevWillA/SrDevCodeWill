package com.devsenior.will.dao;

import java.util.List;

import com.devsenior.will.entity.Employee;
import com.devsenior.will.util.JpaUtil;

public class EmployeeDao {

    public void save(Employee employee) {
        var em = JpaUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();

        em.close();
    }

    public List<Employee> findAll() {
        var em = JpaUtil.getEntityManager();

        var jpql = em.createQuery("SELECT e FROM Employee Employee e", Employee.class);
        var response = jpql.getResultList();
        
        em.close();
        return response;
        
    }
}
