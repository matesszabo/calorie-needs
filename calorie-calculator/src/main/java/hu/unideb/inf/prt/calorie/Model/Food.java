package hu.unideb.inf.prt.calorie.Model;

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
	private int id;
	private int userId;
	private String name;
	private Calorie calorie;
	private double quantity;
	private String unit;
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
	public Food() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Calorie getCalorie() {
		return calorie;
	}
	public void setCalorie(Calorie calorie) {
		this.calorie = calorie;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", calorie=" + calorie
				+ ", quantity=" + quantity + ", unit=" + unit + "]";
	}
	
	
}
