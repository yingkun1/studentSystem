package online.luffyk.studentsystem.domain;

public class Teacher {
    private Integer id;

    private String teacherName;

    private String teacherPwd;

    private String remark;

    private String name;

    public Teacher() {
    }

    public Teacher(Integer id, String teacherName, String teacherPwd, String remark, String name) {
        this.id = id;
        this.teacherName = teacherName;
        this.teacherPwd = teacherPwd;
        this.remark = remark;
        this.name = name;
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
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherPwd() {
        return teacherPwd;
    }

    public void setTeacherPwd(String teacherPwd) {
        this.teacherPwd = teacherPwd == null ? null : teacherPwd.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPwd='" + teacherPwd + '\'' +
                ", remark='" + remark + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}