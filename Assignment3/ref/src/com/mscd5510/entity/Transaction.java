package com.mscd5510.entity;

import java.util.Date;

public class Transaction {
	private String ID;
	private String nameOnCard;
	private String cardNumber;
	private float UnitPrice;
	private int Quantity;
	private float TotalPrice;
	private String ExpDate;
	private String CreatedOn;
	private String CreatedBy;
	private String Cardtype;

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public void setUnitPrice(float UnitPrice) {
		this.UnitPrice = UnitPrice;
	}

	public float getUnitPrice() {
		return UnitPrice;
	}

	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}

	public float getQuantity() {
		return Quantity;
	}

	public void setTotalPrice(float TotalPrice) {
		this.TotalPrice = TotalPrice;
	}

	public float getTotalPrice() {
		return TotalPrice;
	}

	public void setCreatedOn(String CreatedOn) {
		this.CreatedOn = CreatedOn;
	}

	public String getCreatedOn() {
		return CreatedOn;
	}

	public void setExpDate(String ExpDate) {
		this.ExpDate = ExpDate;
	}

	public String getExpDate() {
		return ExpDate;
	}

	public void setCreatedBy(String CreatedBy) {
		this.CreatedBy = CreatedBy;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCardtype(String Cardtype) {
		this.Cardtype = Cardtype;
	}

	public String getCardtype() {
		return Cardtype;
	}

	public String toString() {

		String results = new String();

		results = "[NameOnCard: " + nameOnCard + ",CardNumber: " + cardNumber + ",UnitPrice: " + UnitPrice
				+ ",Quantity: " + Quantity + ",TotalPrice: " + TotalPrice + ",CreatedOn: " + CreatedOn + ",ExpDate: "
				+ ExpDate + ",CreatedBy: " + CreatedBy + ",Cardtype: " + Cardtype + "]";
		return results;

	}

}
