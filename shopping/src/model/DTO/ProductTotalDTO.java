package model.DTO;

public class ProductTotalDTO {
	String prodNum;
	String prodName;
	String prodPrice;
	String sumPrice;
	
	public String getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(String sumPrice) {
		this.sumPrice = sumPrice;
	}
	
	public String getProdNum() {
		return prodNum;
	}
	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}
	
	
}
