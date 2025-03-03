package org.example.SpringMVC.Dao;

import org.example.SpringMVC.model.Alien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class AlienDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Alien> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Alien> alienList = session.createQuery("from Alien", Alien.class).getResultList();
        return alienList;
    }

    @Transactional
    public void addAlien(Alien a) {
        Session session = sessionFactory.getCurrentSession();
        session.save(a);

    }

    @Transactional
    public Alien find(int aid) {
        Session session = sessionFactory.getCurrentSession();
        Alien a = session.get(Alien.class, aid);
        return a;
    }

}
