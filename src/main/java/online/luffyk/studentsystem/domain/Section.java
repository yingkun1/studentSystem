package online.luffyk.studentsystem.domain;

public class Section extends Entity{
    private Integer id;

    private Integer year;

    private String type;

    private Integer clazzId;

    private Integer teacherId;

    private Integer courseId;

    private String remark;

    private Course course;

    private Teacher teacher;

    private Clazz clazz;

    private Integer selectNum;

    public Section() {
    }

    public Section(Integer id, Integer year, String type, Integer clazzId, Integer teacherId, Integer courseId, String remark, Course course, Teacher teacher, Clazz clazz, Integer selectNum) {
        this.id = id;
        this.year = year;
        this.type = type;
        this.clazzId = clazzId;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.remark = remark;
        this.course = course;
        this.teacher = teacher;
        this.clazz = clazz;
        this.selectNum = selectNum;
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
        this.type = type;
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
        this.remark = remark;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Integer getSelectNum() {
        return selectNum;
    }

    public void setSelectNum(Integer selectNum) {
        this.selectNum = selectNum;
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
                ", course=" + course +
                ", teacher=" + teacher +
                ", clazz=" + clazz +
                ", selectNum=" + selectNum +
                '}';
    }
}