package org.student.entity;
                                                    //第三步， 根据数据表建立实体类
public class Student {
    private int sno;
    private String sname;
    private int sage;
    private String saddress;

    @Override
    public String toString() {
        return "Student{" + "sno=" + sno +
                        ", sname='" + sname + '\'' +
                        ", sage=" + sage +
                        ", saddress='" + saddress + '\'' +
                        '}';
                         }

    public Student(){

    }

    public Student(int sage, String saddress){
        this.sage = sage;
        this.saddress = saddress;
    }

    public Student(int sno, String sname, int sage, String saddress){
        this.sno = sno;
        this.sname = sname;
        this.sage = sage;
        this.saddress = saddress;
    }

    public int getSno() {
        return sno;
    }
    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

}