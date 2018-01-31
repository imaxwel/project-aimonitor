package per.wph.engine.clib;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-01-31 15:13
 * =============================================
 */
public class FaceModel extends Structure{

    public static class ByReference extends FaceModel implements Structure.ByReference{
    }
    public static class ByValue extends FaceModel implements Structure.ByValue{
    }

    public Pointer pbFeature;
    public int lFeatureSize;
    @Override
    protected List getFieldOrder() {
        List<String> list = new ArrayList<String>();
        list.add("pbFeature");
        list.add("lFeatureSize");
        return list;
    }
}
