public class Department {
    private String deptCode;
    private String deptName;
    private int numberOfEmployee=0;

    public Department(String deptCode, String deptName){
        this.deptCode=deptCode;
        this.deptName=deptName;
    };
    public String getDeptName(){
        return this.deptName;
    }
    public void setNumberOfEmployee(){
        this.numberOfEmployee++;
    }//tăng số lượng nhân viên lên 1 sau mỗi lần khởi tạo
    public String toString(){
        String answer=" ";
        answer+=this.deptCode;
        if (deptCode.equals("HC")||deptCode.equals("IT")){
            for (int i=0;i<9;i++)answer+=" ";
        }
        if (deptCode.equals("MKT")){
            for (int i=0;i<8;i++)answer+=" ";
        }
        answer+="| ";
        answer+=deptName;
        for(int i=0;i<20-deptName.length();i++){
            answer+=" ";
        }
        answer+="| ";
        answer+=this.numberOfEmployee;
        return answer;
    }
}
