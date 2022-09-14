import java.text.DecimalFormat;

public class Manager extends Staff implements ICalculator{
    private int position;
    public Manager(String id, String name, int age, double salaryNumber,String dayIn,double vacation,int department, int position){
        super(id,name,age,salaryNumber,dayIn,vacation,department);
        this.position=position;
        HumanResources.departments.get(department-1).setNumberOfEmployee();//tăng số lượng nhân viên mỗi bộ phận sau mỗi lần khởi tạo
    };
    public int getPosition(){
        return this.position;
    }
    public void displayInformation(){
        //Hiển thị thông tin cấp quản lý
        System.out.print(getId());
        int length1=("Ma nhan vien   ").length()-getId().length();
        for(int i=0;i<length1;i++){
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.print(" "+getName());
        int length2=(" Ten nhan vien     ").length()-getName().length();
        for (int i=0;i<length2;i++){
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.print(" "+getAge());
        int length3=(" Tuoi  ").length()-(getAge()+"").length();
        for (int i=0;i<length3;i++){
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.print(" "+getSalaryNumber());
        int length4=(" HS luong  ").length()-(getSalaryNumber()+"").length();
        for (int i=0;i<length4;i++){
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.print(" "+getDayIn());
        int length5=(" Ngay vao lam  ").length()-(getDayIn()+"").length();
        for (int i=0;i<length5;i++){
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.print(" "+getVacation());
        int length6=(" Ngay nghi phep  ").length()-(getVacation()+"").length();
        for (int i=0;i<length6;i++){
            System.out.print(" ");
        }
        System.out.print("|");
        String dept="";
        if (getDepartment()==1){
            dept="HC - Hành chính nhân sự";
        } else if (getDepartment()==2) {
            dept="IT - Công nghệ thông tin";
        } else if (getDepartment()==3) {
            dept="MKT - Marketing";
        }
        System.out.print(" "+dept);
        int length7=(" Bộ phận                ").length()-dept.length();
        for (int i=0;i<length7;i++){
            System.out.print(" ");
        }
        System.out.print("|");
        String posit="";
        if (getPosition()==1){
            posit="Business Leader";
        }else if (getPosition()==2){
            posit="Project Leader";
        }else if (getPosition()==3){
            posit="Technical Leader";
        }
        System.out.print(" "+posit);
        int length8=(" So gio lam them/Chuc vu  ").length()-posit.length();
        for (int i=0;i<length8;i++){
            System.out.print(" ");
        }
        System.out.print("| ");
        DecimalFormat newFormat=new DecimalFormat("#,###.##");
        System.out.println(newFormat.format(calculateSalary()));
    }
    public double calculateSalary() {
        //trả về thông tin nhân viên cấp quản lý
        int positionSalary=0;
        if(this.position==1){
            positionSalary=8000000;
        } else if (this.position==2) {
            positionSalary=5000000;
        } else if (this.position==3) {
            positionSalary=6000000;
        }
        return getSalaryNumber() * 5000000 + positionSalary;
    }
}
