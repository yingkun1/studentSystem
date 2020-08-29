package online.luffyk.studentsystem.domain;

import java.util.Date;

public class Student extends Entity {
    private Integer id;

    private String stuNo;

    private String stuName;

    private String stuPwd;

    private String cardNo;

    private String gender;

    private Date birthday;

    private String phone;

    private String pname;

    private String telephone;

    private String addr;

    private Date joinDate;

    private String status;

    private Integer clazzId;

    private Integer subjectId;

    private Subject subject;

    private Clazz clazz;

    public Student() {
    }

    public Student(Integer id, String stuNo, String stuName, String stuPwd, String cardNo, String gender, Date birthday, String phone, String pname, String telephone, String addr, Date joinDate, String status, Integer clazzId, Integer subjectId, Subject subject, Clazz clazz) {
        this.id = id;
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuPwd = stuPwd;
        this.cardNo = cardNo;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.pname = pname;
        this.telephone = telephone;
        this.addr = addr;
        this.joinDate = joinDate;
        this.status = status;
        this.clazzId = clazzId;
        this.subjectId = subjectId;
        this.subject = subject;
        this.clazz = clazz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuPwd='" + stuPwd + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", pname='" + pname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", addr='" + addr + '\'' +
                ", joinDate=" + joinDate +
                ", status='" + status + '\'' +
                ", clazzId=" + clazzId +
                ", subjectId=" + subjectId +
                ", subject=" + subject +
                ", clazz=" + clazz +
                '}';
    }
}