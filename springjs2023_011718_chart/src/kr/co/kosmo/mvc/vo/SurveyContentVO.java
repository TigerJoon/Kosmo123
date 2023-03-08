package kr.co.kosmo.mvc.vo;

public class SurveyContentVO {

	private String subtype;
	private int subcode;
	private String surveytitle;
	private int surveycnt;
	private int surveytotal;
	public String getSubtype() {
		return subtype;
	}
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	public int getSubcode() {
		return subcode;
	}
	public void setSubcode(int subcode) {
		this.subcode = subcode;
	}
	public String getSurveytitle() {
		return surveytitle;
	}
	public void setSurveytitle(String surveytitle) {
		this.surveytitle = surveytitle;
	}
	public int getSurveycnt() {
		return surveycnt;
	}
	public void setSurveycnt(int surveycnt) {
		this.surveycnt = surveycnt;
	}
	public int getSurveytotal() {
		return surveytotal;
	}
	public void setSurveytotal(int surveytotal) {
		this.surveytotal = surveytotal;
	}
	
	
}
