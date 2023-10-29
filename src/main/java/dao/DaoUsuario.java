package dao;

import interfaces.InterfaceUsuario;
import models.TblUsuariocl2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DaoUsuario implements InterfaceUsuario {

	public TblUsuariocl2 Login(String usuario, String password) {
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("CLIIExamen");
		EntityManager emanager = conex.createEntityManager();
		emanager.getTransaction().begin();

		Query consulta = emanager.createQuery("SELECT c FROM TblUsuariocl2 c WHERE c.usuariocl2=:x and c.passwordcl2=:y", TblUsuariocl2.class);
		consulta.setParameter("x", usuario);
		consulta.setParameter("y", password);
		TblUsuariocl2 cl;
		try {
			System.out.println("esta todod buen");
			cl = (TblUsuariocl2) consulta.getSingleResult();
			System.out.println("esta paso buen");
		} catch (Exception e) {
			System.out.println("esta todod error");
			cl = null;
		}
		return cl;
	}

}
