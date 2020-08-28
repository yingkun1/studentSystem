package online.luffyk.studentsystem.domain;

public class Subject extends Entity {
    private Integer id;

    private String subjectName;

    private String college;

    private String remark;

    public Subject() {
    }

    public Subject(Integer id, String subjectName, String college, String remark) {
        this.id = id;
        this.subjectName = subjectName;
        this.college = college;
        this.remark = remark;
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
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", college='" + college + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}