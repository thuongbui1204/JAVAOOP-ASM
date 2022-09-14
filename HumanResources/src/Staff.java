abstract class Staff {
    private String id;
    private String name;
    private int age;
    private double salaryNumber;
    private String dayIn;
    private double vacation;
    private int department;

    public Staff(String id, String name, int age, double salaryNumber, String dayIn, double vacation, int department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salaryNumber = salaryNumber;
        this.dayIn = dayIn;
        this.department = department;
        this.vacation = vacation;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getSalaryNumber() {

        return this.salaryNumber;
    }
    public String getDayIn(){
        return this.dayIn;
    }
    public double getVacation(){
        return this.vacation;
    }
    public int getDepartment(){
        return this.department;
    }
    abstract void displayInformation();
    abstract double calculateSalary();

}
