package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Lugar;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
@Transactional
public class LugarRepositorioImpl implements LugarRepositorio {

    private final SessionFactory sessionFactory;

    @Autowired
    public LugarRepositorioImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Lugar> findByNombreContaining(String nombre) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Lugar> query = cb.createQuery(Lugar.class);
        Root<Lugar> root = query.from(Lugar.class);
        query.select(root).where(cb.like(root.get("nombre"), "%" + nombre + "%"));
        return session.createQuery(query).getResultList();
    }

    public Lugar guardar(Lugar lugar) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(lugar);
        return lugar;
    }


    public Lugar buscarPorId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Lugar.class, id);
    }


    public List<Lugar> buscarTodos() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Lugar> query = cb.createQuery(Lugar.class);
        query.select(query.from(Lugar.class));
        return session.createQuery(query).getResultList();
    }


    public void eliminar(Lugar lugar) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(lugar);
    }


    @Override
    public List<Lugar> findAll() {
        return List.of();
    }

    @Override
    public List<Lugar> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Lugar> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Lugar> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Lugar entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Lugar> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Lugar> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Lugar> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Lugar> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Lugar> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Lugar> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Lugar> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Lugar getOne(Long aLong) {
        return null;
    }

    @Override
    public Lugar getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Lugar> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Lugar> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Lugar> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Lugar> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Lugar> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Lugar> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Lugar, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}