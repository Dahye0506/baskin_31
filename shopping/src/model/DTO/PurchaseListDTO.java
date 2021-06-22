package model.DTO;

public class PurchaseListDTO {
	String pordNum;
	String purchaseNum;
	String purchaseQty;
	String purchasePrice;
	
	public String getPordNum() {
		return pordNum;
	}
	public void setPordNum(String pordNum) {
		this.pordNum = pordNum;
	}
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getPurchaseQty() {
		return purchaseQty;
	}
	public void setPurchaseQty(String purchaseQty) {
		this.purchaseQty = purchaseQty;
	}
	public String getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

}
