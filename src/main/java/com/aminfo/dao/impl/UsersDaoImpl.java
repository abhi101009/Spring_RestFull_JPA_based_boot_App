package com.aminfo.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.aminfo.dao.UsersDao;
import com.aminfo.dao.generic.impl.JPAServiceProvider;
import com.aminfo.model.usermanagement.Users;

/**
 * This class is used to access data for the User entity. Repository annotation
 * allows the component scanning support to find and configure the DAO wihtout
 * any XML configuration and also provide the Spring exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the method.
 * If exception occurs it will also call rollback().
 */
@Service
@Repository
@Transactional
public class UsersDaoImpl extends JPAServiceProvider implements UsersDao {

	public UsersDaoImpl() {
		super();
	}

	@Override
	public void deleteAllInBatch() {	}

	@Override
	public void deleteInBatch(Iterable<Users> arg0) {	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> findAll() {
		return (List<Users>) getEntityManager().createQuery("from Users").getResultList();
	}

	@Override
	public List<Users> findAll(Sort arg0) {
		return null;
	}

	@Override
	public List<Users> findAll(Iterable<Long> arg0) {
		return  null;
	}

	@Override
	public void flush() {	}

	@Override
	public Users getOne(Long id) {
		return getEntityManager().find(Users.class, id);
	}

	@Override
	public <S extends Users> List<S> save(Iterable<S> arg0) {
		return null;
	}

	@Override
	public <S extends Users> S saveAndFlush(S arg0) {
		return null;
	}

	@Override
	public Page<Users> findAll(Pageable arg0) {
		return null;
	}

	@Override
	public long count() {
		return (long) getEntityManager().createQuery("select count(u) from Users").getSingleResult();
	}

	@Override
	public void delete(Long id) {
		Users user = new Users(id);
		if (getEntityManager().contains(user))
			getEntityManager().remove(user);
		else
			getEntityManager().remove(getEntityManager().merge(user));
		return;
	}

	@Override
	public void delete(Users user) {
		if (getEntityManager().contains(user))
			getEntityManager().remove(user);
		else
			getEntityManager().remove(getEntityManager().merge(user));
		return;
	}

	@Override
	public void delete(Iterable<? extends Users> arg0) {}

	@Override
	public void deleteAll() {
		getEntityManager().createQuery("delete from Users").executeUpdate();
	}

	@Override
	public boolean exists(Long arg0) {
		return false;
	}

	@Override
	public Users findOne(Long id) {
		return getEntityManager().find(Users.class, id);
	}

	@Override
	public <S extends Users> S save(S arg0) {
		getEntityManager().persist(arg0);
		return arg0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getByEmail(String email) {
		return (List<Users>) getEntityManager().createNamedQuery("getUserByEmailID").setParameter("email", email).getResultList();
	}

	@Override
	public Users update(Users user) {
		return getEntityManager().merge(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> findByUserName(String userName) {
		return (List<Users>) getEntityManager().createQuery("select * from users where userName =:userName").setParameter("userName", userName).getResultList();
	}

}
