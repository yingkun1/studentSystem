package online.luffyk.studentsystem.domain;

public class Clazz extends Entity{
    private Integer id;

    private String clazzName;

    private Integer subjectId;

    private String remark;

    private Subject subject;

    public Clazz() {
    }

    public Clazz(Integer id, String clazzName, Integer subjectId, String remark, Subject subject) {
        this.id = id;
        this.clazzName = clazzName;
        this.subjectId = subjectId;
        this.remark = remark;
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", clazzName='" + clazzName + '\'' +
                ", subjectId=" + subjectId +
                ", remark='" + remark + '\'' +
                ", subject=" + subject +
                '}';
    }
}