package hu.unideb.inf.prt.calorie.Model;

public class Calorie {
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(carbohydrate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(kcal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(protein);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Calorie other = (Calorie) obj;
		if (Double.doubleToLongBits(carbohydrate) != Double
				.doubleToLongBits(other.carbohydrate))
			return false;
		if (Double.doubleToLongBits(fat) != Double.doubleToLongBits(other.fat))
			return false;
		if (Double.doubleToLongBits(kcal) != Double
				.doubleToLongBits(other.kcal))
			return false;
		if (Double.doubleToLongBits(protein) != Double
				.doubleToLongBits(other.protein))
			return false;
		return true;
	}
	private double kcal;
	private double carbohydrate;
	private double protein;
	private double fat;
	public Calorie(double kcal) {
		super();
		this.kcal = kcal;
	}
	public Calorie(double kcal, double carbohydrate,double fat ,double protein ) {
		super();
		this.kcal = kcal;
		this.carbohydrate = carbohydrate;
		this.protein = protein;
		this.fat = fat;
	}
	
	
	
	public Calorie() {
		super();
	}
	public double getKcal() {
		return kcal;
	}
	public void setKcal(double kcal) {
		this.kcal = kcal;
	}
	public double getCarbohydrate() {
		return carbohydrate;
	}
	public void setCarbohydrate(double carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	@Override
	public String toString() {
		return "Calorie [kcal=" + kcal + ", carbohydrate=" + carbohydrate
				+ ", protein=" + protein + ", fat=" + fat + "]";
	}
	
	
}
