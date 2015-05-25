package hu.unideb.inf.prt.calorie.Model;

import org.joda.time.DateTime;

public class Diet_diary {

	/**
	 * The id of the user.
	 */
	private int userId;
	/**
	 * The id of the food.
	 */
	private int foodId;
	/**
	 * The date when the user ate the food.
	 */
	private DateTime date;
	/**
	 * The quantity of the food.
	 */
	private double quantity;
	/**
	 * The unit of the quantity.
	 */
	private String unit;
	/**
	 * The meal type.
	 */
	private String meal;
	/**
	 * The calorie needs of user.
	 */
	private Calorie needs;
	/**
	 * Fulfilled calories of user.
	 */
	private Calorie remaining;
	/**
	 * Full constructor for Diet_diary class.
	 * @param userId of the user
	 * @param foodId of the food the user ate
	 * @param date when the user ate the food
	 * @param quantity of the food
	 * @param unit of the quantity
	 * @param meal type
	 * @param calorie needs of user
	 * @param fulfilled needs of user
	 */
	public Diet_diary(int userId, int foodId, DateTime date, double quantity,
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
	/**
	 * Empty constructor
	 */
	public Diet_diary() {
		super();
	}
	/**
	 * A method for getting user id.
	 * Returns the user id.
	 * @return the user id
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * A method for setting user id.
	 * @param userId that needs to be set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * A method for getting food id.
	 * Returns the food id.
	 * @return the food id
	 */
	public int getFoodId() {
		return foodId;
	}
	/**
	 * A method for setting food id.
	 * @param foodId that needs to be set
	 */
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	/**
	 * A method for getting the date
	 * Returns the date.
	 * @return the date
	 */
	public DateTime getDate() {
		return date;
	}
	/**
	 * A method for setting the date.
	 * @param date that needs to be set.
	 */
	public void setDate(DateTime date) {
		this.date = date;
	}
	/**
	 * A method for getting quantity.
	 * Returns the quantity.
	 * @return the quantity
	 */
	public double getQuantity() {
		return quantity;
	}
	/**
	 * A method for setting quantity.
	 * @param quantity that needs to be set
	 */
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	/**
	 * A method for getting unit.
	 * Returns the unit of quantity.
	 * @return the unit of quantity
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * A method for setting the unit.
	 * @param unit that needs to be set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * A method for getting the meal type.
	 * Returns the meal type.
	 * @return the meal type
	 */
	public String getMeal() {
		return meal;
	}
	/**
	 * A method for setting the meal type.
	 * @param meal type that needs to be set
	 */
	public void setMeal(String meal) {
		this.meal = meal;
	}
	/**
	 * A method for getting calorie needs of user.
	 * Returns the calorie needs.
	 * @return the calorie needs
	 */
	public Calorie getNeeds() {
		return needs;
	}
	/**
	 * A method for setting calorie needs of user.
	 * @param needs that needs to be set
	 */
	public void setNeeds(Calorie needs) {
		this.needs = needs;
	}
	/**
	 * A method for getting fulfilled calories.
	 * Returns the fulfilled calories.
	 * @return the fulfilled calories
	 */
	public Calorie getRemaining() {
		return remaining;
	}
	/**
	 * A method for setting fulfilled calories.
	 * @param fulfilled calories that needs to be set
	 */
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
