package com.sj.entity;

public class ResultBean {

	String resultCode;
	Object resultObject;
	String total;
	
	public ResultBean(){
		this.resultCode = "";
		this.resultObject = null;
		this.total = "";

	}
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public Object getResultObject() {
		return resultObject;
	}
	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
	}
	
}
