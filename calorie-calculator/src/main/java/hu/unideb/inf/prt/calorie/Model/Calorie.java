package hu.unideb.inf.prt.calorie.Model;
/**
 * A class representing calorie,carbohydrate,fat,protein.
 * @author mates
 *
 */
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
	/**
	 * A double representing kcal.
	 */
	private double kcal;
	/**
	 * A double representing carbohydrate.
	 */
	private double carbohydrate;
	/**
	 * A double representing protein.
	 */
	private double protein;
	/**
	 * A double representing fat.
	 */
	private double fat;
	/**
	 * Constructor for a person.
	 * @param calorie needs in kcal
	 */
	public Calorie(double kcal) {
		super();
		this.kcal = kcal;
	}
	/**
	 * Constructor for food
	 * @param kcal in food
	 * @param carbohydrate in food
	 * @param fat in food
	 * @param protein in food
	 */
	public Calorie(double kcal, double carbohydrate,double fat ,double protein ) {
		super();
		this.kcal = kcal;
		this.carbohydrate = carbohydrate;
		this.protein = protein;
		this.fat = fat;
	}
	
	
	/**
	 * Empty constructor
	 */
	public Calorie() {
		super();
	}
	/**
	 * A method for getting kcal value.
	 * Returns kcal value.
	 * @return kcal value
	 */
	public double getKcal() {
		return kcal;
	}
	/**
	 * A method for setting kcal value.
	 * @param kcal value that needs to be set.
	 */
	public void setKcal(double kcal) {
		this.kcal = kcal;
	}
	/**
	 * A method for getting carbohydrate value.
	 * Returnds carbohydrate value.
	 * @return carbohydrate value.
	 */
	public double getCarbohydrate() {
		return carbohydrate;
	}
	/**
	 * A method for setting carbohydrate value
	 * @param carbohydrate value that needs to be set.
	 */
	public void setCarbohydrate(double carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
	/**
	 * A method for getting protein value.
	 * Returns the protein value.
	 * @return protein value.
	 */
	public double getProtein() {
		return protein;
	}
	/**
	 * A method for setting protein value.
	 * @param protein value that needs to be set.
	 */
	public void setProtein(double protein) {
		this.protein = protein;
	}
	/**
	 * A method for getting fat value.
	 * Returns the fat value.
	 * @return fat value
	 */
	public double getFat() {
		return fat;
	}
	/**
	 * A method for setting fat value.
	 * @param fat value that needs to be set
	 */
	public void setFat(double fat) {
		this.fat = fat;
	}
	@Override
	public String toString() {
		return "Calorie [kcal=" + kcal + ", carbohydrate=" + carbohydrate
				+ ", protein=" + protein + ", fat=" + fat + "]";
	}
	
	
}
