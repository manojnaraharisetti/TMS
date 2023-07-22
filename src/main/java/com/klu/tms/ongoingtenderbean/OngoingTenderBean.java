package com.klu.tms.ongoingtenderbean;

import java.util.List;

import javax.ejb.Remote;

import com.klu.tms.ongoingtenderentity.OngoingTender;

@Remote
public interface OngoingTenderBean {
	public String ongoingTenderData(OngoingTender e) throws Exception;
	public List<OngoingTender> getTenderData() throws Exception;
}
