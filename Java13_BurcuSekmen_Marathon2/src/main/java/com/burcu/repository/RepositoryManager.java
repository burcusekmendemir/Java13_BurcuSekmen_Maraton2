package com.burcu.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositoryManager<T,ID> implements ICrud<T,ID>{

    private final EntityManagerFactory emf;
    private EntityManager em;
    private final T t;
    public RepositoryManager(T t){
        emf= Persistence.createEntityManagerFactory("CRM");
        em= emf.createEntityManager();
        this.t=t;
    }

    public void openSession(){
        em=emf.createEntityManager();
        em.getTransaction().begin();
    }

    public void closeSession(){
        em.getTransaction().commit();
        em.close();
    }
    @Override
    public T save(T entity) {
        try {
            openSession();
            em.persist(entity);
            closeSession();
        }catch (Exception e){
            if (em.isOpen()){
                closeSession();
            }
        }
        return entity;
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> entities) {
        try {
            openSession();
            entities.forEach(e -> {
                em.persist(e);
            });
            closeSession();
        }catch (Exception e){
            if (em.isOpen()){
                closeSession();
            }
        }
        return entities;
    }

    @Override
    public Optional<T> findById(ID id) {
        CriteriaBuilder criteriaBuilder= em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery= (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass()); // select * from tblsecmen where id=? ->
        Root<T> root= (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"),id));
        T t1;
        try {
            t1=em.createQuery(criteriaQuery).getSingleResult();
            return Optional.of(t1);
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<T> findByColumn(String column, Object value) {
        CriteriaBuilder criteriaBuilder= emf.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery= (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root= (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get(column),value));
        T t1;
        try {
            t1=em.createQuery(criteriaQuery).getSingleResult();
            return Optional.of(t1);
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public boolean existById(ID id) {
        CriteriaBuilder criteriaBuilder= em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery= (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root= (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"),id));
        try {
            em.createQuery(criteriaQuery).getSingleResult();
            return true;
        }catch (NoResultException e){
            return false;
        }
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder criteriaBuilder= em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery= (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root= (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<T> findByColumnAndValue(String column, Object value) {
        CriteriaBuilder criteriaBuilder= em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery= (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root= (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get(column),value));
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void deleteById(ID id) {
        CriteriaBuilder criteriaBuilder= em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery= (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root= (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"),id));
        T removeElement;
        try {
            removeElement=em.createQuery(criteriaQuery).getSingleResult();
        }catch (NoResultException e){
            removeElement=null;
        }
        try {
            openSession();
            em.remove(removeElement);
            closeSession();
        }catch (Exception e){
            if (em.isOpen()){
                closeSession();
            }
        }
    }

    @Override
    public List<T> findAllEntity(T entity) {
        List<T> list;
        Class<?> clazz=entity.getClass();
        Field[] fields= clazz.getDeclaredFields();
        CriteriaBuilder criteriaBuilder=em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery= (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root= (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        List<Predicate> predicateList=new ArrayList<>();
        for (int i = 0; i <fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                Object value=fields[i].get(entity);
                String column=fields[i].getName();
                if (value!=null)
                    if (value instanceof String){
                        predicateList.add(criteriaBuilder.like(root.get(column),"%"+value+"%"));
                    }else {
                        predicateList.add(criteriaBuilder.equal(root.get(column),value));
                    }
            }catch (Exception e){
                System.out.println("Hata oluştu..: " +e);
            }

        }
        criteriaQuery.where(predicateList.toArray(new Predicate[]{}));
        list=em.createQuery(criteriaQuery).getResultList();
        return list;
    }





}
