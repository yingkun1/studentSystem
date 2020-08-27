package online.luffyk.studentsystem.domain;

public class Job {
    private Integer id;

    private String compName;

    private String jobDate;

    private Integer salay;

    private String remark;

    private Integer stuId;

    public Job() {
    }

    public Job(Integer id, String compName, String jobDate, Integer salay, String remark, Integer stuId) {
        this.id = id;
        this.compName = compName;
        this.jobDate = jobDate;
        this.salay = salay;
        this.remark = remark;
        this.stuId = stuId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName == null ? null : compName.trim();
    }

    public String getJobDate() {
        return jobDate;
    }

    public void setJobDate(String jobDate) {
        this.jobDate = jobDate == null ? null : jobDate.trim();
    }

    public Integer getSalay() {
        return salay;
    }

    public void setSalay(Integer salay) {
        this.salay = salay;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", compName='" + compName + '\'' +
                ", jobDate='" + jobDate + '\'' +
                ", salay=" + salay +
                ", remark='" + remark + '\'' +
                ", stuId=" + stuId +
                '}';
    }
}