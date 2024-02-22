package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Usuario;

@Transactional
@Repository
public class UsuarioRepositoryImp implements IUsuarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Usuario consultarNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Usuario> myquery = this.entityManager.createQuery("SELECT u FROM Usuario u WHERE u.nombre=:nombre",
				Usuario.class);
		myquery.setParameter("nombre", nombre);
		return myquery.getSingleResult();
	}

}
