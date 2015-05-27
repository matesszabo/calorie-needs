package hu.unideb.inf.prt.calorie.Model;

import org.joda.time.DateTime;
/**
 * A class representing a person.
 * @author mates
 *
 */
public class Person {
	/**
	 * Id of the person.
	 */
	private int id;
	/**
	 * Height of the person.
	 */
	private int height;
	/**
	 * The date when the person born.
	 */
	private DateTime born;
	/**
	 * Actual information about the person.
	 */
	private Person_date daily;
	/**
	 * Gender of the person.
	 */
	private String gender;
	/**
	 * Username of the person.
	 */
	private String uname;
	/**
	 * Password of the person.
	 */
	private String password;
	//private double weight_change;
	/**
	 * BMI of the person.
	 */
	private double BMI;
	/**
	 * BMR of the person.
	 */
	private double BMR;
	/**
	 * Calorie needs of person.
	 */
	private Calorie needs;
	
	
	

	/**
	 * Constructor for login.
	 * Unused.
	 * @param id of the user
	 * @param uname of the user
	 * @param password of the user
	 */
	public Person(int id, String uname, String password) {
		super();
		this.id = id;
		this.uname = uname;
		this.password = password;
	}

	/**
	 * Empty constructor.
	 */
	public Person() {
		super();
	}
	
	/**
	 * A method for getting password.
	 * Returns the password.
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * A method for setting password.
	 * @param password that needs to be set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * A method for getting username.
	 * Returns username.
	 * @return username
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * A method for setting username.
	 * @param uname that needs to be set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * A method for getting user id.
	 * Returns user id.
	 * @return user id
	 */
	public int getId() {
		return id;
	}
	/**
	 * A method for setting user id.
	 * @param id that needs to be set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * A method for getting height of user.
	 * Returns height.
	 * @return height of user
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * A method for setting height of user.
	 * @param height of user
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	
	/**
	 * A method for getting the gender.
	 * Returns the gender.
	 * @return gender of user
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * A method for setting the gender.
	 * @param gender that needs to be set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	

	@Override
	public String toString() {
		return "Person [id=" + id + ", height=" + height + ", born=" + born
				+ ", daily=" + daily + ", gender=" + gender + ", uname="
				+ uname + ", password=" + password + ", BMI=" + BMI + ", BMR="
				+ BMR + ", needs=" + needs + "]";
	}

	/**
	 * Constructor for registering user.
	 * @param id of the user
	 * @param height of the user
	 * @param born date of user
	 * @param daily information of user
	 * @param gender of user
	 * @param uname of user
	 * @param password of user
	 */
	public Person(int id, int height, DateTime born, Person_date daily,
			String gender, String uname, String password) {
		super();
		this.id = id;
		this.height = height;
		this.born = born;
		this.daily = daily;
		this.gender = gender;
		this.uname = uname;
		this.password = password;
	}

	/**
	 * Full constructor.
	 * @param id of user
	 * @param height of user
	 * @param born date of user
	 * @param daily information of user
	 * @param gender of user
	 * @param uname of user
	 * @param password of user
	 * @param bMI of user
	 * @param bMR of user
	 * @param needs in kcal,carbohydrate,fat,protein of user
	 */
	public Person(int id, int height, DateTime born, Person_date daily,
			String gender, String uname, String password, double bMI,
			double bMR, Calorie needs) {
		super();
		this.id = id;
		this.height = height;
		this.born = born;
		this.daily = daily;
		this.gender = gender;
		this.uname = uname;
		this.password = password;
		BMI = bMI;
		BMR = bMR;
		this.needs = needs;
	}


	/*public double getWeight_change() {
		return weight_change;
	}

	public void setWeight_change(double weight_change) {
		this.weight_change = weight_change;
	}*/
	/**
	 * A method for getting the date when the user born.
	 * Returns the date when the user born.
	 * @return date when the user born
	 */
	public DateTime getBorn() {
		return born;
	}

	/**
	 * A method for setting the date when the user born.
	 * @param born date of user
	 */
	public void setBorn(DateTime born) {
		this.born = born;
	}

	/**
	 * A method for getting current information of user.
	 * Returns current information.
	 * @return current information
	 */
	public Person_date getDaily() {
		return daily;
	}

	/**
	 * A method for setting current information of user.
	 * @param daily is the current information that needs to be set
	 */
	public void setDaily(Person_date daily) {
		this.daily = daily;
	}

	/**
	 * A method for getting the user's bmi value.
	 * Returns BMI value.
	 * @return BMI value
	 */
	public double getBMI() {
		return BMI;
	}
	/**
	 * A method for setting the user's bmi value.
	 * @param bMI that needs to be set
	 */
	public void setBMI(double bMI) {
		BMI = bMI;
	}
	/**
	 * A method for getting the user's bmr value.
	 * Returns BMR value.
	 * @return BMR value
	 */
	public double getBMR() {
		return BMR;
	}
	/**
	 * A method for setting the user's bmr value.
	 * @param bMR value that needs to be set
	 */
	public void setBMR(double bMR) {
		BMR = bMR;
	}
	/**
	 * A method for getting the daily needs of user.
	 * Returns the daily needs.
	 * @return daily needs
	 */
	public Calorie getNeeds() {
		return needs;
	}
	/**
	 * A method for setting the daily needs of user.
	 * @param needs that need to be set
	 */
	public void setNeeds(Calorie needs) {
		this.needs = needs;
	}

	
	
	
	
	

}
