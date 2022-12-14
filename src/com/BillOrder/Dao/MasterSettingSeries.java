package com.BillOrder.Dao;

import java.sql.Date;

public class MasterSettingSeries {
	private int BranchId;
	private String BranchName;
	private String Prefix;
	private String CashSeries;
	private String CreditSeries;
	private String CrCardSeries;
	private String OnlineSeries;
	private int OpenClose;
	private int DefaultGodown;
	private int BillDate;
	private String type;
	private String SeriesName;
	private Date CreatedDate;
	private Date ModifiedDate;
	private int LUser;
	public int getBranchId() {
		return BranchId;
	}
	public void setBranchId(int branchId) {
		BranchId = branchId;
	}
	public String getBranchName() {
		return BranchName;
	}
	public void setBranchName(String branchName) {
		BranchName = branchName;
	}
	public String getPrefix() {
		return Prefix;
	}
	public void setPrefix(String prefix) {
		Prefix = prefix;
	}
	public String getCashSeries() {
		return CashSeries;
	}
	public void setCashSeries(String cashSeries) {
		CashSeries = cashSeries;
	}
	public String getCreditSeries() {
		return CreditSeries;
	}
	public void setCreditSeries(String creditSeries) {
		CreditSeries = creditSeries;
	}
	public String getCrCardSeries() {
		return CrCardSeries;
	}
	public void setCrCardSeries(String crCardSeries) {
		CrCardSeries = crCardSeries;
	}
	public String getOnlineSeries() {
		return OnlineSeries;
	}
	public void setOnlineSeries(String onlineSeries) {
		OnlineSeries = onlineSeries;
	}
	public int getOpenClose() {
		return OpenClose;
	}
	public void setOpenClose(int openClose) {
		OpenClose = openClose;
	}
	public int getDefaultGodown() {
		return DefaultGodown;
	}
	public void setDefaultGodown(int defaultGodown) {
		DefaultGodown = defaultGodown;
	}
	public int getBillDate() {
		return BillDate;
	}
	public void setBillDate(int billDate) {
		BillDate = billDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSeriesName() {
		return SeriesName;
	}
	public void setSeriesName(String seriesName) {
		SeriesName = seriesName;
	}
	public Date getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}
	public Date getModifiedDate() {
		return ModifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		ModifiedDate = modifiedDate;
	}
	public int getLUser() {
		return LUser;
	}
	public void setLUser(int lUser) {
		LUser = lUser;
	}
	
	
}
