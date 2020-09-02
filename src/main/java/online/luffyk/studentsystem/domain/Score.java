package online.luffyk.studentsystem.domain;

import java.math.BigDecimal;

public class Score extends Entity {
    private Integer id;

    private Integer sectionId;

    private Integer courseId;

    private Integer stuId;

    private BigDecimal score;

    private Section section;

    private Course course;

    private Student student;

    public Score() {
    }

    public Score(Integer id, Integer sectionId, Integer courseId, Integer stuId, BigDecimal score, Section section, Course course, Student student) {
        this.id = id;
        this.sectionId = sectionId;
        this.courseId = courseId;
        this.stuId = stuId;
        this.score = score;
        this.section = section;
        this.course = course;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", sectionId=" + sectionId +
                ", courseId=" + courseId +
                ", stuId=" + stuId +
                ", score=" + score +
                ", section=" + section +
                ", course=" + course +
                ", student=" + student +
                '}';
    }
}