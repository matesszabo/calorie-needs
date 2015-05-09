package hu.unideb.inf.prt.calorie.Model;

public class Person {
	private int id;
	private int height;
	private double weight;
	private int year;
	private int excercise;
	private String gender;
	private int goal;
	private String uname;
	private String password;
	//private double weight_change;
	private double BMI;
	private double BMR;
	private Calorie needs;
	
	public Person(int id,String uname,String password, int height, double weight, int year, int excercise,
			String gender, int goal) {
		super();
		this.id=id;
		this.height = height;
		this.weight = weight;
		this.year = year;
		this.excercise = excercise;
		this.gender = gender;
		this.goal = goal;
		this.uname=uname;
		this.password=password;
		
		//this.weight_change = weight_change;
	}
	

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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getExcercise() {
		return excercise;
	}

	public void setExcercise(int excercise) {
		this.excercise = excercise;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	/*public double getWeight_change() {
		return weight_change;
	}

	public void setWeight_change(double weight_change) {
		this.weight_change = weight_change;
	}*/

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

	@Override
	public String toString() {
		return "Person [id=" + id + ", height=" + height + ", weight=" + weight
				+ ", year=" + year + ", excercise=" + excercise + ", gender="
				+ gender + ", goal=" + goal + ", BMI=" + BMI + ", BMR=" + BMR + ", needs="
				+ needs + "]";
	}
	
	
	
	

}
