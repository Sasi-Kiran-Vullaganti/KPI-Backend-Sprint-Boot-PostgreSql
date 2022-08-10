package com.KPI.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Records")
public class Records {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String GroupName;
	private int NoOfDefects;
	private double PLMKPI1;
	private String PartName;
	private String ProjectCode;
	private String SQA;
	private String TeamName;
	private double TimeTaken;
	private String Y21ProjectName;
	
	
	public Records() {
		super();
	}
	public Records(String projectCode, String y21ProjectName, String teamName, String groupName, String partName,
			String sQA, double pLMKPI1, int noOfDefects, double timeTaken) {
		super();
		ProjectCode = projectCode;
		Y21ProjectName = y21ProjectName;
		TeamName = teamName;
		GroupName = groupName;
		PartName = partName;
		SQA = sQA;
		PLMKPI1 = pLMKPI1;
		NoOfDefects = noOfDefects;
		TimeTaken = timeTaken;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProjectCode() {
		return ProjectCode;
	}
	public void setProjectCode(String projectCode) {
		ProjectCode = projectCode;
	}
	public String getY21ProjectName() {
		return Y21ProjectName;
	}
	public void setY21ProjectName(String y21ProjectName) {
		Y21ProjectName = y21ProjectName;
	}
	public String getTeamName() {
		return TeamName;
	}
	public void setTeamName(String teamName) {
		TeamName = teamName;
	}
	public String getGroupName() {
		return GroupName;
	}
	public void setGroupName(String groupName) {
		GroupName = groupName;
	}
	public String getPartName() {
		return PartName;
	}
	public void setPartName(String partName) {
		PartName = partName;
	}
	public String getSQA() {
		return SQA;
	}
	public void setSQA(String sQA) {
		SQA = sQA;
	}
	public double getPLMKPI1() {
		return PLMKPI1;
	}
	public void setPLMKPI1(double pLMKPI1) {
		PLMKPI1 = pLMKPI1;
	}
	public int getNoOfDefects() {
		return NoOfDefects;
	}
	public void setNoOfDefects(int noOfDefects) {
		NoOfDefects = noOfDefects;
	}
	public double getTimeTaken() {
		return TimeTaken;
	}
	public void setTimeTaken(double timeTaken) {
		TimeTaken = timeTaken;
	}
	

}
