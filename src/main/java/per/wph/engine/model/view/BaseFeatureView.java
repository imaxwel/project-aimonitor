package per.wph.engine.model.view;

public interface BaseFeatureView {
    Long getId();
    byte[] getBytes();
    float getDegree();
    void setDegree(float degree);
}
