package per.wph.info.model;

import java.util.Date;

public class RecordOwnerVisit {
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

    private Long oid;

    private Long cid;

    private Long bid;

    private Date time;

    private Integer status;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
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