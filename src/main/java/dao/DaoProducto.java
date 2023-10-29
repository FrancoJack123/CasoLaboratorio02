package dao;

import interfaces.InterfaceProducto;
import models.Productocl2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DaoProducto implements InterfaceProducto {

	public List<Productocl2> ListarProducto() {
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("CLIIExamen");
		EntityManager emanager = conex.createEntityManager();
		emanager.getTransaction().begin();
		List<Productocl2> list = emanager.createQuery("SELECT c FROM Productocl2 c",Productocl2.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return list;
	}

	public Productocl2 BuscarProducto(Integer id) {
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("CLIIExamen");
		EntityManager emanager = conex.createEntityManager();
		emanager.getTransaction().begin();

		emanager.getTransaction().commit();
		emanager.close();
		return null;
	}

	public void AgregarProducto(Productocl2 productocl2) {
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("CLIIExamen");
		EntityManager emanager = conex.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(productocl2);
		emanager.getTransaction().commit();
		emanager.close();
	}

	public void ActualizarProducto(Productocl2 productocl2) {
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("CLIIExamen");
		EntityManager emanager = conex.createEntityManager();
		emanager.getTransaction().begin();
		emanager.merge(productocl2);
		emanager.getTransaction().commit();
		emanager.close();
		
	}

	public void EliminarProducto(Integer id) {
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("CLIIExamen");
		EntityManager emanager = conex.createEntityManager();
		emanager.getTransaction().begin();
		Productocl2 productocl2 = emanager.find(Productocl2.class,id);
		emanager.remove(productocl2);
		emanager.getTransaction().commit();
		emanager.close();
		
	}

}
