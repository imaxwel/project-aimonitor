package per.wph.info.model;

import java.util.Date;

public class RecordVisitorVisit {
    public enum RecordStatus{
        ACCESS(100),UNACCESS(-100);
        private Integer status;
        private RecordStatus(Integer status){
            this.status = status;
        }
        public Integer status(){
            return this.status;
        }
        public String value(){
            return this.name();
        }
    }
    private Long rid;

    private Long cid;

    private Long bid;

    private Long vid;

    private Date time;

    private Integer status;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}