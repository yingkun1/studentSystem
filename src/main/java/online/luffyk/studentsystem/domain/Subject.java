package online.luffyk.studentsystem.domain;

import java.util.List;

public class Subject extends Entity {
    private Integer id;

    private String subjectName;

    private String college;

    private String remark;

    private List<Clazz> clazzList;

    public Subject() {
    }

    public Subject(Integer id, String subjectName, String college, String remark, List<Clazz> clazzList) {
        this.id = id;
        this.subjectName = subjectName;
        this.college = college;
        this.remark = remark;
        this.clazzList = clazzList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Clazz> getClazzList() {
        return clazzList;
    }

    public void setClazzList(List<Clazz> clazzList) {
        this.clazzList = clazzList;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", college='" + college + '\'' +
                ", remark='" + remark + '\'' +
                ", clazzList=" + clazzList +
                '}';
    }
}