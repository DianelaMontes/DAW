package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.TbUsuario;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("======JPA CRUD======");
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("JPA_clase01x");
		EntityManager em = fabrica.createEntityManager();
		
		 
		
		
		
		Query query = em.createNativeQuery("{call usp_validaAcceso(?,?)}", TbUsuario.class);
		query.setParameter(1, "U002@gmail.com");
		query.setParameter(2, "10002");
		TbUsuario u = (TbUsuario) query.getSingleResult();
		if(u!=null){		
		System.out.println("Bienvenido "+u.getNomUsua()+" "+u.getApeUsua());
     	System.out.println("Tus datos son : " + u);	
		} else{
			System.out.println("El usuario no existe");
		}
		//List<TbUsuario> lstUsuarios = query.getResultList();
		
		
	}

}
