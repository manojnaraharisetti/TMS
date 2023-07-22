package com.klu.tms.ongoingtendercontroller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.klu.tms.ongoingtenderbean.OngoingTenderBean;
import com.klu.tms.ongoingtenderentity.OngoingTender;


@ManagedBean(name = "ongoingtender", eager = true)
@RequestScoped
public class OngoingTenderData {
	private String tenderincharge;
	private String email;
	private String tendername;
	private String orgname;
	private String companyadd;
	private String contactno1;
	private String contactno2;
	private String amount;
	private String aadhaar;
	private String pan;
	private String gst;
	private String res_message;
	private List<OngoingTender> list;
	
	public List<OngoingTender> getList() {
		try {
			list = eb.getTenderData();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public void setList(List<OngoingTender> list) {
		this.list = list;
	}
	public String getTenderincharge() {
		return tenderincharge;
	}
	public void setTenderincharge(String tenderincharge) {
		this.tenderincharge = tenderincharge;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTendername() {
		return tendername;
	}
	public void setTendername(String tendername) {
		this.tendername = tendername;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getCompanyadd() {
		return companyadd;
	}
	public void setCompanyadd(String companyadd) {
		this.companyadd = companyadd;
	}
	public String getContactno1() {
		return contactno1;
	}
	public void setContactno1(String contactno1) {
		this.contactno1 = contactno1;
	}
	public String getContactno2() {
		return contactno2;
	}
	public void setContactno2(String contactno2) {
		this.contactno2 = contactno2;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getAadhaar() {
		return aadhaar;
	}
	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	public String getRes_message() {
		return res_message;
	}
	public void setRes_message(String res_message) {
		this.res_message = res_message;
	}
	
	
	@EJB(lookup = "java:global/TMS/OngoingTenderBeanImpl!com.klu.tms.ongoingtenderbean.OngoingTenderBean")
	private OngoingTenderBean eb;

	public String ongoingTender() {
		try {
			OngoingTender e = new OngoingTender();
			e.setTenderincharge(tenderincharge);
			e.setEmail(email);
			e.setTendername(tendername);
			e.setOrgname(orgname);
			e.setCompanyadd(companyadd);
			e.setContactno1(contactno1);
			e.setContactno2(contactno2);
			e.setAmount(amount);
			e.setAadhaar(aadhaar);
			e.setPan(pan);
			e.setGst(gst);
			res_message = eb.ongoingTenderData(e);
		} catch (Exception e1) {
			res_message = e1.getMessage();
		}
		return "ongoingtenders";
	}
	
}
