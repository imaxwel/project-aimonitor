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
public class OwnerView {
    private OwnerInfo ownerInfo;
    private BuildingInfo buildingInfo;

    public OwnerInfo getOwnerInfo() {
        return ownerInfo;
    }

    public void setOwnerInfo(OwnerInfo ownerInfo) {
        this.ownerInfo = ownerInfo;
    }

    public BuildingInfo getBuildingInfo() {
        return buildingInfo;
    }

    public void setBuildingInfo(BuildingInfo buildingInfo) {
        this.buildingInfo = buildingInfo;
    }
}
