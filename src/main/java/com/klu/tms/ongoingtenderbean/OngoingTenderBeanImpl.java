package com.klu.tms.ongoingtenderbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

}
