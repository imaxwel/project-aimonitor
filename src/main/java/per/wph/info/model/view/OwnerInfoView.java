package per.wph.info.model.view;

import per.wph.info.model.BuildingInfo;
import per.wph.info.model.OwnerInfo;

/**
 * =============================================
 * buildingInfo 和 ownerInfo 级联查询对象
 * @author wu
 * @create 2018-02-01 11:08
 * =============================================
 */
public class OwnerInfoView {
    private String username;
    private String name;
    private String phone;
    private String idnumber;
    private String communityName;
    private String buildingName;
    private String num;
    private Integer status;


    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
