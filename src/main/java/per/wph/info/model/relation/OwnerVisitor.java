package per.wph.info.model.relation;

import java.util.Date;

public class OwnerVisitor {
    private Long oid;

    private Long vid;

    private Integer relationType;

    private Date allowBegin;

    private Date allowEnd;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public Integer getRelationType() {
        return relationType;
    }

    public void setRelationType(Integer relationType) {
        this.relationType = relationType;
    }

    public Date getAllowBegin() {
        return allowBegin;
    }

    public void setAllowBegin(Date allowBegin) {
        this.allowBegin = allowBegin;
    }

    public Date getAllowEnd() {
        return allowEnd;
    }

    public void setAllowEnd(Date allowEnd) {
        this.allowEnd = allowEnd;
    }
}