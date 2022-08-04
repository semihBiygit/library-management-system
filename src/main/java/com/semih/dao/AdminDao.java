package com.semih.dao;

import java.util.List;

import org.hibernate.Session;

import com.semih.entity.Admin;

import jakarta.persistence.TypedQuery;

public class AdminDao implements Crud<Admin> {

	@Override
	public void create(Admin entity) {
		Session session = null;

		try {
			session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Admin data is added to DB.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding admin data.");
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(long id) {
		Session session = null;
		try {
			Admin deleteAdmin = find(id);
			if (deleteAdmin != null) {
				session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deleteAdmin);
				session.getTransaction().commit();
				System.out.println("Admin data is deleted from DB.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while deleting Admin data.");
		} finally {
			session.close();
		}

	}

	@Override
	public void update(long id, Admin entity) {
		Session session = null;
		try {
			Admin admin = find(id);
			if (admin != null) {
				admin.setUsername(entity.getUsername());
				admin.setPassword(entity.getPassword());

				session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(admin);
				session.getTransaction().commit();
				System.out.println("Admin data is succesfully updated.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while updating Admin data.");
		} finally {
			session.close();
		}

	}

	@Override
	public List<Admin> listAll() {

		Session session = databaseConnectionHibernate();
		String query = "select admin from Admin as admin";
		TypedQuery<Admin> typedQuery = session.createQuery(query, Admin.class);
		List<Admin> adminList = typedQuery.getResultList();

		for (Admin admin : adminList) {
			System.out.println(admin);
		}
		return adminList;
	}

	@Override
	public Admin find(long id) {

		Session session = databaseConnectionHibernate();
		Admin admin;

		try {
			admin = session.find(Admin.class, id);

			if (admin != null) {
				System.out.println("Admin fount : " + admin);
				return admin;
			} else {
				System.out.println("Admin not found!");
				return admin;
			}

		} catch (Exception e) {
			System.out.println("Some problem has accured admin find operation.");
		} finally {
			session.close();
		}
		return null;
	}

}
