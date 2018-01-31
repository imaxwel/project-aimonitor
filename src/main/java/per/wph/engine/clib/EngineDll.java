package per.wph.engine.clib;

import com.sun.jna.Library;
import com.sun.jna.Native;
import per.wph.common.util.ResourceLoaderUtil;


public interface EngineDll extends Library{
    EngineDll INSTANCE = (EngineDll)
            Native.loadLibrary(ResourceLoaderUtil.getResourceFilePathWithPackage("dll","samplecode.dll"),
                    EngineDll.class);
    int loadimage(int id,String filepath);
    int FDinit();
    int FD(int id);
    int FDclean(int id);
    int FDuinit();
    int FRinit();
    int FR(int id);
    int FRFactMatch(int id1,int id2);
    String Feature(int id);
    int FRclean(int id);
    int FRuinit();

    int engineInit();
    int engineUinit();
    FaceModel.ByValue getFeatureByImage(String filepath);
    float compareImage(FaceModel.ByValue f1,FaceModel.ByValue f2);
}
