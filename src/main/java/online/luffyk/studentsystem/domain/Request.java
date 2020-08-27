package online.luffyk.studentsystem.domain;

import java.util.Date;

public class Request {
    private Integer id;

    private String title;

    private String type;

    private Date createDate;

    private Integer stuId;

    private Integer status;

    private String attach;

    private String result1;

    private String result2;

    private String reason;

    public Request() {
    }

    public Request(Integer id, String title, String type, Date createDate, Integer stuId, Integer status, String attach, String result1, String result2, String reason) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.createDate = createDate;
        this.stuId = stuId;
        this.status = status;
        this.attach = attach;
        this.result1 = result1;
        this.result2 = result2;
        this.reason = reason;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach == null ? null : attach.trim();
    }

    public String getResult1() {
        return result1;
    }

    public void setResult1(String result1) {
        this.result1 = result1 == null ? null : result1.trim();
    }

    public String getResult2() {
        return result2;
    }

    public void setResult2(String result2) {
        this.result2 = result2 == null ? null : result2.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", createDate=" + createDate +
                ", stuId=" + stuId +
                ", status=" + status +
                ", attach='" + attach + '\'' +
                ", result1='" + result1 + '\'' +
                ", result2='" + result2 + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}