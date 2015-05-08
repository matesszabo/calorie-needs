package hu.unideb.inf.prt.calorie.Model;

public class Calorie {
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
