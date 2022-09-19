package entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "employment_history", schema = "resume")
public class EmploymentHistory {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "header")
    private String header;
    @Basic
    @Column(name = "begin_date")
    private Date beginDate;
    @Basic
    @Column(name = "end_date")
    private Date endDate;
    @Basic
    @Column(name = "job_description")
    private String jobDescription;
    @Basic
    @Column(name = "user_id")
    private int userId;

    public EmploymentHistory() {

    }

    public EmploymentHistory(int id, String header, Date beginDate, Date endDate, String jobDescription, int userId) {
        this.id = id;
        this.header = header;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmploymentHistory that = (EmploymentHistory) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (header != null ? !header.equals(that.header) : that.header != null) return false;
        if (beginDate != null ? !beginDate.equals(that.beginDate) : that.beginDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (jobDescription != null ? !jobDescription.equals(that.jobDescription) : that.jobDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (header != null ? header.hashCode() : 0);
        result = 31 * result + (beginDate != null ? beginDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (jobDescription != null ? jobDescription.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
}
