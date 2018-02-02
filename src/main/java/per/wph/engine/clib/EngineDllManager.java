package per.wph.engine.clib;

import per.wph.common.exception.DllUnavailableException;

import java.io.FileNotFoundException;

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
        }catch (Exception e){
            available = Boolean.FALSE;
            engineDll.engineUinit();
        }
        if(res == 1){
            available = Boolean.TRUE;
        }
    }

    public static FaceModel.ByValue getFeatureByImage(String filepath) throws DllUnavailableException, FileNotFoundException {
        if(available){
            return engineDll.getFeatureByImage(filepath);
        }else{
            throw new DllUnavailableException("Dll unavailable");
        }
    };

    public static float compareImage(FaceModel.ByValue f1,FaceModel.ByValue f2) throws DllUnavailableException {
        if(available){
            return engineDll.compareImage(f1,f2);
        }else{
            throw new DllUnavailableException("Dll unavailable");
        }
    };

    public static void engineUinit() throws DllUnavailableException {
        if(engineDll.engineUinit() == 1){
            available = Boolean.FALSE;
        }else {
            throw new DllUnavailableException("Dll engine uinit fail");
        };
    };
}
