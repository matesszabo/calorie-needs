package hu.unideb.inf.prt.calorie.Model;

import org.joda.time.DateTime;

public class Person_date {
	private DateTime date;
	private double weight;
	private int excercise;
	private double goal;
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getExcercise() {
		return excercise;
	}
	public void setExcercise(int excercise) {
		this.excercise = excercise;
	}
	public double getGoal() {
		return goal;
	}
	public void setGoal(double goal) {
		this.goal = goal;
	}
	public Person_date(DateTime date, double weight, int excercise, double goal) {
		super();
		this.date = date;
		this.weight = weight;
		this.excercise = excercise;
		this.goal = goal;
	}
	@Override
	public String toString() {
		return "Person_date [date=" + date + ", weight=" + weight
				+ ", excercise=" + excercise + ", goal=" + goal + "]";
	}
	public Person_date() {
		super();
	}
	
	
	

}
