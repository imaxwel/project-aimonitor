package per.wph.info.model.view;

import per.wph.engine.model.FaceFeature;

import java.util.List;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-03 17:40
 * =============================================
 */
public class OwnerRegistView {
    private Long oid;
    private String name;
    private String idnumber;
    private String phone;
    private Long cid;
    private Long bid;
    private String num;
    private List<Long> faceIdList;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public List<Long> getFaceIdList() {
        return faceIdList;
    }

    public void setFaceIdList(List<Long> faceIdList) {
        this.faceIdList = faceIdList;
    }
}
