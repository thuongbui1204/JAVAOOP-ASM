import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public abstract class HumanResources {
    public static int choice = 1;
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Staff> staffs = new ArrayList<Staff>();
    public static ArrayList<Department> departments = new ArrayList<Department>();

    public static void main(String[] args) {
        Department hc = new Department("HC", "Hành chính nhân sự");
        departments.add(hc);
        Department it = new Department("IT", "Công nghệ thông tin");
        departments.add(it);
        Department mkt = new Department("MKT", "Marketing");
        departments.add(mkt);
        while (choice != 0) {
            setChoice();
        }

    }

    public static void setChoice() {
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty.");
        System.out.println("2. Hiển thị các bộ phận trong công ty.");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận.");
        System.out.println("4. Thêm nhân viên mới vào công ty.");
        System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.");
        System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty theo thứ tự giảm dần.");
        System.out.println("7. Hiển thị bảng lương mới của nhân viên theo thứ tự tăng.");
        System.out.println("0. Thoát chương trình.");
        System.out.print("Lựa chọn của bạn: ");
        choice = input.nextInt();
        switch (choice) {
            case 1:
                choice1();
                break;
            case 2:
                choice2();
                break;
            case 3:
                choice3();
                break;
            case 4:
                choice4();
                break;
            case 5:
                choice5();
                break;
            case 6:
                choice6();
                break;
            case 7:
                choice7();
                break;
        }
        System.out.println("---***---");

    }

    public static void title() {
        System.out.println("Mã nhân viên   | Tên nhân viên      | Tuổi   | HS lương   | Ngày vào làm   "
                + "| Ngày nghỉ phép   | Bộ phận                 | Số giờ làm thêm/Chức vụ   | Lương   ");
    }

    public static void choice1() {
        //Hiển thị danh sách nhân viên
        title();
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < staffs.size(); i++) {
            staffs.get(i).displayInformation();
        }
    }

    public static void choice2() {
        //Hiển thị số lượng nhân viên của tất cả bộ phận
        System.out.println(" Mã bộ phận | Tên bộ phận         | Số lượng nhân viên hiện tại ");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < departments.size(); i++) {
            System.out.println(departments.get(i).toString());
        }
    }

    public static void choice3() {
        //Hiển thị danh sách nhân viên theo từng bộ phận
        for (int i = 0; i < departments.size(); i++) {
            System.out.println("");
            System.out.println(departments.get(i).getDeptName());
            System.out.println("------------------------------------------------------------");
            title();
            for (int j = 0; j < staffs.size(); j++) {
                if (staffs.get(j).getDepartment() == (i + 1)) staffs.get(j).displayInformation();
            }
        }
    }

    public static void choice4() {
        //Nhập thông tin nhân viên vào ArrayList Staff
        System.out.println("1. Thêm nhân viên thông thường ");
        System.out.println("2. Thêm nhân viên là cấp quản lý (có thêm chức vụ) ");
        System.out.print("Bạn chọn: ");
        int choiceAdding = input.nextInt();
        System.out.print("Nhập mã nhân viên: ");
        String id = input.next();
        input.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        String name = input.nextLine();
        System.out.print("Nhập tuổi nhân viên: ");
        int age = input.nextInt();
        System.out.print("Nhập hệ số lương của nhân viên: ");
        double salaryNumber = input.nextDouble();
        System.out.print("Nhập ngày vào làm của nhân viên: ");
        String dayIn = input.next();
        System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
        double vacation = input.nextDouble();
        System.out.println("1. HC - Hành chính nhân sự");
        System.out.println("2. IT - Công nghệ thông tin");
        System.out.println("3. MKT - Marketing");
        System.out.print("Bạn chọn bộ phận: ");
        int department = input.nextInt();
        switch (choiceAdding) {
            case 1:
                System.out.print("Nhập số giờ làm thêm: ");
                double overTime = input.nextDouble();
                Employee employee = new Employee(id, name, age, salaryNumber, dayIn, vacation, department, overTime);
                staffs.add(employee);
                break;
            case 2:
                System.out.println("Chức danh: ");
                System.out.println("1. Business Leader");
                System.out.println("2. Project Leader");
                System.out.println("3. Technical Leader ");
                System.out.print("Nhập chức danh: ");
                int position = input.nextInt();
                Manager manager = new Manager(id, name, age, salaryNumber, dayIn, vacation, department, position);
                staffs.add(manager);
                break;
        }

    }

    public static void choice5() {
        //Tìm thông tin nhân viên theo tên hoặc mã nhân viên
        System.out.println("1. Tìm nhân viên bằng tên:");
        System.out.println("2. Tìm nhân viên bằng mã nhân viên:");
        System.out.print("Bạn chọn: ");
        int searchChoice = input.nextInt();
        int count=0;
        switch (searchChoice) {
            case 1:
                input.nextLine();
                System.out.println("Nhập tên nhân viên cần tìm: ");
                String searchName = input.nextLine().toUpperCase();
                title();
                for (int i = 0; i < staffs.size(); i++) {
                    String staffName=staffs.get(i).getName().toUpperCase();
                    String[] splitStaffName=staffName.split(" ");
                    if (splitStaffName[splitStaffName.length-1].equals(searchName)) {
                        staffs.get(i).displayInformation();
                        count++;
                    }
                }
                if (count==0) System.out.println("Không tồn tại nhân viên có tên như yêu cầu. ");


        break;
        case 2:
        System.out.println("Nhập mã nhân viên: ");
        String searchId = input.next().toUpperCase();

        title();

        for (int i = 0; i < staffs.size(); i++) {
            if (staffs.get(i).getId().toUpperCase().equals(searchId)) {
                staffs.get(i).displayInformation();
                count++;
            }
        }
            if(count==0) System.out.println("Không tồn tại nhân viên có ID như yêu cầu. ");
        break;

    }

}

    public static void choice6() {
        //Sắp xếp nhân viên theo thứ tự lương giảm dần
        title();
        Double[] salaryList = new Double[staffs.size()];
        for (int i = 0; i < staffs.size(); i++) {
            salaryList[i] = staffs.get(i).calculateSalary();
        }

        Arrays.sort(salaryList, Collections.reverseOrder());
        ArrayList<Double> salaryListRemoveDouble = new ArrayList<Double>();
        salaryListRemoveDouble.add(salaryList[0]);
        for (int i = 1; i < salaryList.length; i++) {
            if (!salaryList[i].equals(salaryList[i - 1])) salaryListRemoveDouble.add(salaryList[i]);
        }

        for (int i = 0; i < salaryListRemoveDouble.size(); i++) {
            for (int j = 0; j < staffs.size(); j++) {
                if (salaryListRemoveDouble.get(i) == staffs.get(j).calculateSalary()) {
                    staffs.get(j).displayInformation();
                }

            }

        }
    }
    public static void choice7(){
        //sắp xếp nhân viên theo thứ tự tăng dần
        title();
        double[] salaryList=new double[staffs.size()];
        for(int i=0;i< staffs.size();i++){
            salaryList[i]=staffs.get(i).calculateSalary();
        }

        Arrays.sort(salaryList);
        ArrayList<Double>salaryListRemoveDouble=new ArrayList<Double>();
        salaryListRemoveDouble.add(salaryList[0]);
        for(int i=1;i<salaryList.length;i++){
            if(salaryList[i]!=salaryList[i-1]) salaryListRemoveDouble.add(salaryList[i]);
        }

        for(int i=0;i< salaryListRemoveDouble.size();i++){
            for(int j=0;j< staffs.size();j++){
                if(salaryListRemoveDouble.get(i)==staffs.get(j).calculateSalary()){
                    staffs.get(j).displayInformation();
                }
            }

        }

    }


}


