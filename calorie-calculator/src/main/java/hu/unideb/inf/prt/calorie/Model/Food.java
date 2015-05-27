package hu.unideb.inf.prt.calorie.Model;
/**
 * A class representing a food.
 * @author mates
 *
 */
public class Food {

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calorie == null) ? 0 : calorie.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(quantity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		result = prime * result + userId;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (calorie == null) {
			if (other.calorie != null)
				return false;
		} else if (!calorie.equals(other.calorie))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(quantity) != Double
				.doubleToLongBits(other.quantity))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	/**
	 * Id of the food.
	 */
	private int id;
	/**
	 * User who added food.
	 */
	private int userId;
	/**
	 * Name of the food.
	 */
	private String name;
	/**
	 * Calories in the food.
	 */
	private Calorie calorie;
	/**
	 * Quantity of the food.
	 */
	private double quantity;
	/**
	 * Unit of the quantity.
	 */
	private String unit;
	/**
	 * Constructor for Food class.
	 * @param id of the food
	 * @param userId who added food
	 * @param name of the food
	 * @param calorie in the food
	 * @param quantity of the food
	 * @param unit of the quantity
	 */
	public Food(int id,int userId, String name, Calorie calorie, double quantity,
			String unit) {
		super();
		this.id = id;
		this.userId=userId;
		this.name = name;
		this.calorie = calorie;
		this.quantity = quantity;
		this.unit = unit;
	}
	/**
	 * Empty constructor.
	 */
	public Food() {
		super();
	}
	/**
	 * A method for getting user id.
	 * Returns the user id.
	 * @return user id
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
	 * Returns food id.
	 * @return food id
	 */
	public int getId() {
		return id;
	}
	/**
	 * A method for setting food id.
	 * @param id that needs to be set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * A method for getting the food's name.
	 * Returns the food's name.
	 * @return the food's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * A method for setting the food's name.
	 * @param name that needs to be set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * A method for getting calories in food.
	 * Returns calories in food.
	 * @return calories in food
	 */
	public Calorie getCalorie() {
		return calorie;
	}
	/**
	 * A method for setting calories in food.
	 * @param calorie in food that needs to be set
	 */
	public void setCalorie(Calorie calorie) {
		this.calorie = calorie;
	}
	/**
	 * A method for getting quantity of food.
	 * Returns the quantity of food.
	 * @return quantity of food
	 */
	public double getQuantity() {
		return quantity;
	}
	/**
	 * A method for setting quantity of food.
	 * @param quantity that needs to be set
	 */
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	/**
	 * A method for getting the unit of quantity.
	 * Returns the unit of quantity.
	 * @return unit of quantity
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * A method for setting the unit of quantity.
	 * @param unit that needs to be set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", calorie=" + calorie
				+ ", quantity=" + quantity + ", unit=" + unit + "]";
	}
	
	
}
