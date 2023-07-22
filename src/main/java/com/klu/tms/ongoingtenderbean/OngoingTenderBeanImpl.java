package com.klu.tms.ongoingtenderbean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.TypedQuery;

import com.klu.tms.ongoingtenderentity.OngoingTender;

@Stateless
public class OngoingTenderBeanImpl implements OngoingTenderBean{

	@Override
	public String ongoingTenderData(OngoingTender e) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ep_Tms");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
		emf.close();

		return "OngoingTenderSaved";
	}

	@Override
	public List<OngoingTender> getTenderData() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ep_Tms");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<OngoingTender> query = em.createQuery("SELECT e FROM OngoingTender e", OngoingTender.class);
		List<OngoingTender> list = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return list;
		
	}

}
