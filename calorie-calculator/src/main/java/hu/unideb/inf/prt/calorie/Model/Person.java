package hu.unideb.inf.prt.calorie.Model;

import org.joda.time.DateTime;

public class Person {
	private int id;
	private int height;
	private DateTime born;
	private Person_date daily;
	private String gender;
	private String uname;
	private String password;
	//private double weight_change;
	private double BMI;
	private double BMR;
	private Calorie needs;
	
	
	

	public Person(int id, String uname, String password) {
		super();
		this.id = id;
		this.uname = uname;
		this.password = password;
	}


	public Person() {
		super();
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	

	public String getGender() {
		return gender;
	}

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

	public DateTime getBorn() {
		return born;
	}


	public void setBorn(DateTime born) {
		this.born = born;
	}


	public Person_date getDaily() {
		return daily;
	}


	public void setDaily(Person_date daily) {
		this.daily = daily;
	}


	public double getBMI() {
		return BMI;
	}

	public void setBMI(double bMI) {
		BMI = bMI;
	}

	public double getBMR() {
		return BMR;
	}

	public void setBMR(double bMR) {
		BMR = bMR;
	}

	public Calorie getNeeds() {
		return needs;
	}

	public void setNeeds(Calorie needs) {
		this.needs = needs;
	}

	
	
	
	
	

}
