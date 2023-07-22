package com.klu.tms.ongoingtenderentity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ongoingtender")
public class OngoingTender implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	@Column(nullable = false)
	private String tenderincharge;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String tendername;
	@Column(nullable = false)
	private String orgname;
	@Column(nullable = false)
	private String companyadd;
	@Column(length = 10,nullable = false)
	private String contactno1;
	@Column(length = 10,nullable = false)
	private String contactno2;
	@Column(nullable = false)
	private String amount;
	@Column(length = 16,nullable = false)
	private String aadhaar;
	@Column(length = 10,nullable = false)
	private String pan;
	@Column(length = 15,nullable = false)
	private String gst;
	
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
	
	
}
