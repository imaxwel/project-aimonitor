package per.wph.engine.clib;

import per.wph.common.exception.DllUnavailableException;
import per.wph.common.exception.ZeroFaceException;
import per.wph.engine.model.view.BaseFeatureView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-01 14:52
 * =============================================
 */
public class EngineDllManager {
    private static boolean available = Boolean.FALSE;
    private static EngineDll engineDll = EngineDll.INSTANCE;

    static {
        int res = 0;
        try {
            res = engineDll.engineInit();
        } catch (Exception e) {
            available = Boolean.FALSE;
            engineDll.engineUinit();
        }
        if (res == 1) {
            available = Boolean.TRUE;
        }
    }

    public static FaceModel.ByValue getFeatureByImage(String filepath) throws DllUnavailableException, FileNotFoundException, ZeroFaceException {
        if (available) {
            FaceModel.ByValue ret = engineDll.getFeatureByImage(filepath);
            if (ret == null || ret.lFeatureSize == 0) {
                throw new ZeroFaceException("No face found");
            }
            return ret;
        } else {
            throw new DllUnavailableException("Dll unavailable");
        }
    }

    ;

    private static float compareImage(FaceModel.ByValue f1, FaceModel.ByValue f2) throws DllUnavailableException {
        if (available) {
            return engineDll.compareImage(f1, f2);
        } else {
            throw new DllUnavailableException("Dll unavailable");
        }
    }

    ;

    private static float compareImageWithFeature(byte[] b1, byte[] b2) throws DllUnavailableException {
        if (available) {
            if(b1==null || b2==null){
                return 0;
            }
            float result = engineDll.compareFeature(b1,b1.length,b2,b2.length);
            return result;
        } else {
            throw new DllUnavailableException("Dll unavailable");
        }
    }

    ;

    public static List<BaseFeatureView> getConforming(List<? extends BaseFeatureView> views, byte[] feature, float passLine) throws DllUnavailableException {
        List<BaseFeatureView> retViews = new ArrayList<>();
        Iterator<? extends BaseFeatureView> iterator = views.iterator();
        float degree = 0;
        while (iterator.hasNext()) {
            BaseFeatureView i = iterator.next();
            degree = compareImageWithFeature(feature,i.getBytes());
            if(degree>passLine){
                i.setDegree(degree);
                retViews.add(i);
            };
        }
        return retViews;
    }

    public static void engineUinit() throws DllUnavailableException {
        if (engineDll.engineUinit() == 1) {
            available = Boolean.FALSE;
        } else {
            throw new DllUnavailableException("Dll engine uinit fail");
        }
        ;
    }

    ;


}
