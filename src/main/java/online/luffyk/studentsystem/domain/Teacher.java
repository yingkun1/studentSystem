package online.luffyk.studentsystem.domain;

public class Teacher extends Entity {
    private Integer id;

    private String teacherName;

    private String teacherPwd;

    private String remark;

    private String name;

    private Section section;

    private Clazz clazz;

    private Course course;


    public Teacher() {
    }

    public Teacher(Integer id, String teacherName, String teacherPwd, String remark, String name, Section section, Clazz clazz, Course course) {
        this.id = id;
        this.teacherName = teacherName;
        this.teacherPwd = teacherPwd;
        this.remark = remark;
        this.name = name;
        this.section = section;
        this.clazz = clazz;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPwd() {
        return teacherPwd;
    }

    public void setTeacherPwd(String teacherPwd) {
        this.teacherPwd = teacherPwd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPwd='" + teacherPwd + '\'' +
                ", remark='" + remark + '\'' +
                ", name='" + name + '\'' +
                ", section=" + section +
                ", clazz=" + clazz +
                ", course=" + course +
                '}';
    }
}