package com.klu.tms.ongoingtenderbean;

import javax.ejb.Remote;

import com.klu.tms.ongoingtenderentity.OngoingTender;

@Remote
public interface OngoingTenderBean {
	public String ongoingTenderData(OngoingTender e) throws Exception;
}
