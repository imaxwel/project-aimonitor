package per.wph.engine.model.view;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-03 19:01
 * =============================================
 */
public class VisitorFaceFeatureView implements BaseFeatureView{
    private Long vid;
    private byte[] feature;
    private float degree;

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public byte[] getFeature() {
        return feature;
    }

    public void setFeature(byte[] feature) {
        this.feature = feature;
    }

    @Override
    public Long getId() {
        return this.getVid();
    }

    @Override
    public byte[] getBytes() {
        return this.getFeature();
    }

    @Override
    public void setDegree(float degree) {
        this.degree = degree;
    }

    @Override
    public float getDegree() {
        return degree;
    }
}
