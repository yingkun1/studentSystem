package online.luffyk.studentsystem.domain;

public class Clazz {
    private Integer id;

    private String clazzName;

    private Integer subjectId;

    private String remark;

    public Clazz() {
    }

    public Clazz(Integer id, String clazzName, Integer subjectId, String remark) {
        this.id = id;
        this.clazzName = clazzName;
        this.subjectId = subjectId;
        this.remark = remark;
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
        this.clazzName = clazzName == null ? null : clazzName.trim();
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
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", clazzName='" + clazzName + '\'' +
                ", subjectId=" + subjectId +
                ", remark='" + remark + '\'' +
                '}';
    }
}