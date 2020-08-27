package online.luffyk.studentsystem.domain;

import java.math.BigDecimal;

public class Score {
    private Integer id;

    private Integer sectionId;

    private Integer courseId;

    private Integer stuId;

    private BigDecimal score;

    public Score() {
    }

    public Score(Integer id, Integer sectionId, Integer courseId, Integer stuId, BigDecimal score) {
        this.id = id;
        this.sectionId = sectionId;
        this.courseId = courseId;
        this.stuId = stuId;
        this.score = score;
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

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", sectionId=" + sectionId +
                ", courseId=" + courseId +
                ", stuId=" + stuId +
                ", score=" + score +
                '}';
    }
}