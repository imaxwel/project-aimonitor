package per.wph.engine.clib;

import com.sun.jna.Library;
import com.sun.jna.Native;
import per.wph.common.util.ResourceLoaderUtil;


public interface EngineDll extends Library{
    EngineDll INSTANCE = (EngineDll)
            Native.loadLibrary(ResourceLoaderUtil.getResourceFilePathWithPackage("dll","samplecode.dll"),
                    EngineDll.class);
    int engineInit();
    int engineUinit();
    FaceModel.ByValue getFeatureByImage(String filepath);
    FaceModel.ByValue getFeatureByData(byte[] data,int size);
    float compareImage(FaceModel.ByValue f1,FaceModel.ByValue f2);
}
