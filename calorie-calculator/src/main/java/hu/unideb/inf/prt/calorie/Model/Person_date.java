package hu.unideb.inf.prt.calorie.Model;

import org.joda.time.DateTime;
/**
 * A class for user's changeable data.
 * @author mates
 *
 */
public class Person_date {
	/**
	 * The date when the information changed.
	 */
	private DateTime date;
	/**
	 * The new weight.
	 */
	private double weight;
	/**
	 * The new excercise level.
	 */
	private int excercise;
	/**
	 * The new goal.
	 */
	private double goal;
	/**
	 * A method for getting date of change.
	 * Returns the date.
	 * @return date of change
	 */
	public DateTime getDate() {
		return date;
	}
	/**
	 * A method for setting date of change.
	 * @param date that needs to be set
	 */
	public void setDate(DateTime date) {
		this.date = date;
	}
	/**
	 * A method for getting new weight.
	 * Returns new weight.
	 * @return weight as new weight
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * A method for setting the new weight.
	 * Returns new weight.
	 * @param weight as new weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/**
	 * A method for getting excercise level.
	 * Returns the excercise level.
	 * @return excercise level
	 */
	public int getExcercise() {
		return excercise;
	}
	/**
	 * A method for setting excercise level.
	 * @param excercise level that needs to be set.
	 */
	public void setExcercise(int excercise) {
		this.excercise = excercise;
	}
	/**
	 * A method for getting new goal.
	 * Returns new goal.
	 * @return new goal
	 */
	public double getGoal() {
		return goal;
	}
	/**
	 * A method for setting new goal.
	 * @param goal that needs to be set.
	 */
	public void setGoal(double goal) {
		this.goal = goal;
	}
	/**
	 * Full constructor for new Person_date class.
	 * @param date of the data change
	 * @param weight of the person
	 * @param excercise level of the person
	 * @param goal of the person
	 */
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
	/**
	 * Empty constructor.
	 */
	public Person_date() {
		super();
	}
	
	
	

}
