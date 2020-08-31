package online.luffyk.studentsystem.domain;

public class Section extends Entity{
    private Integer id;

    private Integer year;

    private String type;

    private Integer clazzId;

    private Integer teacherId;

    private Integer courseId;

    private String remark;

    public Section() {
    }

    public Section(Integer id, Integer year, String type, Integer clazzId, Integer teacherId, Integer courseId, String remark) {
        this.id = id;
        this.year = year;
        this.type = type;
        this.clazzId = clazzId;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", year=" + year +
                ", type='" + type + '\'' +
                ", clazzId=" + clazzId +
                ", teacherId=" + teacherId +
                ", courseId=" + courseId +
                ", remark='" + remark + '\'' +
                '}';
    }
}