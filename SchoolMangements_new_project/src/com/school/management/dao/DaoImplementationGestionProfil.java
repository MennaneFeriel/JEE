package com.school.management.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.school.management.entities.Membre;
import com.school.management.entities.ParentEleve;
import com.school.management.entities.ResetPasswordToken;

@ApplicationScoped
//@TransactionManagement(TransactionManagementType.CONTAINER)
public class DaoImplementationGestionProfil implements DaoInterfaceGestionProfil<Long, Membre> {
	public static final String Membre_findAll = "findAllMembrees";
	public static final String Membre_findByEnseignant = "Membre.findByEnseignant";
	public static final String Membre_findByDirecteur = "Membre.findByDirecteur";
	public static final String Membre_connexion = "Membre.connexion"; 
	public static final String Membre_findByEleve = "Membre.findByEleve"; 
	public static final String Membre_findOneById = "Membre.findOneById";
	public static final String Membre_searchByQuery = "Membre.searchByQuery";
	public static final String Membre_ResetPasswordTokenFindOne = "Membre.ResetPasswordToken.find";
	public static final String Membre_ResetPasswordTokenFindAll = "Membre.ResetPasswordToken.findAll";

	// @Inject
	@PersistenceContext(name = "SchoolMangements_new_project")
	private EntityManager em;

	@Override
	// @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Membre addMembre(Membre o) {

		try {
			// em.getTransaction().begin();
			em.persist(o);
			// em.getTransaction().commit();
			return o;
		} catch (Throwable t) {
			// em.getTransaction().rollback();
			return null;
		} finally {
			// em.close();
		}

	}

	@Override
	public boolean deleteMembre(Long id) {
		if (em.find(Membre.class, id) != null) {
			em.remove(em.find(Membre.class, id));
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<Membre> getAllgetMembr() {
		try {
			TypedQuery<Membre> myquuery = em.createQuery("SELECT m FROM Membre m", Membre.class);
			List<Membre> membres = myquuery.getResultList();
			return membres;
		} finally {
			//em.close();
		}
	}

	@Override
	public Membre getMembreByEmail(String findMembreByEmail) {
		TypedQuery<Membre> typeQ = em.createNamedQuery("findMembreByEmail", Membre.class);
		typeQ.setParameter("nomparam", findMembreByEmail);
		return typeQ.getSingleResult();
	}

	@Override
	public Membre updateMembre(Membre m) {
		Object result = null;
		try {
		result =  em.merge(m);
		return (Membre) result;
		} finally {
			//em.close();
		}
	}

	@Override
	public Membre connexionProfil(String email, String Password) {
		TypedQuery<Membre> typeQ = em.createNamedQuery("Membre.connexion", Membre.class);
		typeQ.setParameter("loginMembre", email);
		typeQ.setParameter("passewordMembre", Password);
	return typeQ.getSingleResult();
  }

	@Override
	public Long addParant(ParentEleve p) {

			try {
				// em.getTransaction().begin();
				em.persist(p);
				// em.getTransaction().commit();
				return p.getIdParent();
			} catch (Throwable t) {
				// em.getTransaction().rollback();
				return -1L;
			} finally {
				// em.close();
			}

		}

	@Override
	public void saveOrUpdateResetPasswordToken(Membre m) throws Exception
	{
		em.merge(m);
	}

	@Override
	public Membre findResetPasswordToken(String login,String token) throws Exception
	{
		try
		{
			Query query = em.createNamedQuery("Membre.ResetPasswordToken.find");
			query.setParameter("token", token);
			query.setParameter("login", login);
			return (Membre) query.getSingleResult();
		} catch (NoResultException ex)
		{
			return null;
		} finally
		{
//			if (em.isOpen())
//			{
//				em.close();
//			}
		}
	}

	@Override
	public List<ResetPasswordToken> findAllResetPasswordTokens() 
	{
		try
		{
			Query query = em.createNamedQuery("ResetPasswordToken.findAll");
			return ((List<ResetPasswordToken>) query.getSingleResult());
		} catch (NoResultException ex)
		{
			return null;
		} finally
		{
//			if (em.isOpen())
//			{
//				em.close();
//			}
		}
	}


	@Override
	public Membre rechercherMemebre(String motclet1,String motclet2,String motclet3) {
		try
		{
			Query query = em.createNamedQuery("Membre.rechercherMemebre.motclet");
			query.setParameter("motclet1", motclet1);
			query.setParameter("motclet2", motclet2);
			query.setParameter("motclet3", motclet3);
			return (Membre) query.getSingleResult();
		} catch (Throwable t) {
			// em.getTransaction().rollback();
			return null;
		} finally {
			// em.close();
		}

	}

	@Override
	public Membre updateResetPasswordToken(String login) throws Exception {

			try
		{
			Query query = em.createNamedQuery("Membre.fogetPasswordToken.find");
			query.setParameter("login", login);
			return (Membre) query.getSingleResult();
		} catch (Throwable t) {
			// em.getTransaction().rollback();
			return null;
		} finally {
			// em.close();
		
		}
	}
}
