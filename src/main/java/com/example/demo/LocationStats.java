package com.example.demo;

public class LocationStats {
	
	
	
public String id;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String hasc;
 public String States;
 private String Totalcases;
public String getHasc() {
	return hasc;
}
public void setHasc(String hasc) {
	this.hasc = hasc;
}
public String getState() {
	return States;
}
public void setState(String states) {
	States = states;
}
@Override
public String toString() {
	return "LocationStats [ hasc=" + hasc + ", States=" + States + ", Totalcases=" + Totalcases + "]";
}
public String getTotalcases() {
	return Totalcases;
}
public void setTotalcases(String totalcases) {
	Totalcases = totalcases;
}
public String CasesReported;
public String getCasesReported() {
	return CasesReported;
}
public void setCasesReported(String casesReported) {
	CasesReported = casesReported;
}
}
