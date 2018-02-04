package per.wph.engine.model.view;

import per.wph.engine.model.FaceFeature;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-03 19:01
 * =============================================
 */
public class OwnerFaceFeatureView implements BaseFeatureView {
    private Long oid;
    private byte[] feature;
    private float degree;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public byte[] getFeature() {
        return feature;
    }

    public void setFeature(byte[] feature) {
        this.feature = feature;
    }

    @Override
    public Long getId() {
        return this.getOid();
    }

    @Override
    public byte[] getBytes() {
        return this.getFeature();
    }

    @Override
    public void setDegree(float degree) {
        this.degree = degree;
    }

    public float getDegree() {
        return degree;
    }
}
