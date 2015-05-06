package hu.unideb.inf.prt.calorie.Model;

public class Own_recipes {
	private int id;
	private int userId;
	private String name;
	private Calorie calorie;
	private double quantity;
	private String unit;
	public Own_recipes(int id, int userId, String name, Calorie calorie,
			double quantity, String unit) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.calorie = calorie;
		this.quantity = quantity;
		this.unit = unit;
	}
	public Own_recipes() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
		return "Own_recipes [id=" + id + ", userId=" + userId + ", name="
				+ name + ", calorie=" + calorie + ", quantity=" + quantity
				+ ", unit=" + unit + "]";
	}
	
	

}
