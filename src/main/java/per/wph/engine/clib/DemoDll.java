package per.wph.engine.clib;

import com.sun.jna.Library;
import com.sun.jna.Native;
import per.wph.common.util.ResourceLoaderUtil;

/**
 * =============================================
 * Demo.dll的jna接口
 * @author wu
 * @create 2018-01-27 23:10
 * =============================================
 */
public interface DemoDll extends Library{
    DemoDll INSTANCE = (DemoDll) Native.loadLibrary(ResourceLoaderUtil
            .getResourceFilePathWithPackage("dll","Demo.dll"),DemoDll.class);
    int init();
    int uninit();
    int load(String path);
}
