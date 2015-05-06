package hu.unideb.inf.prt.calorie.Model;

import org.joda.time.DateTime;

public class Diet_diary {

	private int userId;
	private int foodId;
	private DateTime date;
	private int quantity;
	private String unit;
	private String meal;
	private Calorie needs;
	private Calorie remaining;
	public Diet_diary(int userId, int foodId, DateTime date, int quantity,
			String unit, String meal, Calorie needs, Calorie remaining) {
		super();
		this.userId = userId;
		this.foodId = foodId;
		this.date = date;
		this.quantity = quantity;
		this.unit = unit;
		this.meal = meal;
		this.needs = needs;
		this.remaining = remaining;
	}
	public Diet_diary() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public Calorie getNeeds() {
		return needs;
	}
	public void setNeeds(Calorie needs) {
		this.needs = needs;
	}
	public Calorie getRemaining() {
		return remaining;
	}
	public void setRemaining(Calorie remaining) {
		this.remaining = remaining;
	}
	@Override
	public String toString() {
		return "Diet_diary [userId=" + userId + ", foodId=" + foodId
				+ ", date=" + date + ", quantity=" + quantity + ", unit="
				+ unit + ", meal=" + meal + ", needs=" + needs + ", remaining="
				+ remaining + "]";
	}
	
	
	
}
