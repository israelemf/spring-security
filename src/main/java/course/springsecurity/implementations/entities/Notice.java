package course.springsecurity.implementations.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "notices")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notice_id")
    private int noticeId;
    @Column(name = "notice_summary")
    private String noticeSummary;
    @Column(name = "notice_details")
    private String noticeDetails;
    @Column(name = "notice_begin_date")
    private LocalDateTime noticeBeginDate;
    @Column(name = "notice_end_date")
    private LocalDateTime noticeEndDate;
    @Column(name = "update_date")
    private LocalDateTime updateDate;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeSummary() {
        return noticeSummary;
    }

    public void setNoticeSummary(String noticeSummary) {
        this.noticeSummary = noticeSummary;
    }

    public String getNoticeDetails() {
        return noticeDetails;
    }

    public void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }

    public LocalDateTime getNoticeBeginDate() {
        return noticeBeginDate;
    }

    public void setNoticeBeginDate(LocalDateTime noticeBeginDate) {
        this.noticeBeginDate = noticeBeginDate;
    }

    public LocalDateTime getNoticeEndDate() {
        return noticeEndDate;
    }

    public void setNoticeEndDate(LocalDateTime noticeEndDate) {
        this.noticeEndDate = noticeEndDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
