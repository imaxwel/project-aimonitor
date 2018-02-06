package per.wph.engine.controller;

import com.sun.deploy.net.HttpResponse;
import com.sun.tools.internal.ws.wsdl.document.Output;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import per.wph.common.ApiResult;
import per.wph.common.controller.BaseController;
import per.wph.common.exception.DllUnavailableException;
import per.wph.common.exception.ZeroFaceException;
import per.wph.common.generator.ApiResultGenerator;
import per.wph.engine.clib.EngineDllManager;
import per.wph.engine.clib.FaceModel;
import per.wph.engine.mapper.FaceFeatureMapper;
import per.wph.engine.model.FaceFeature;
import per.wph.engine.model.view.OwnerFaceFeatureView;
import per.wph.engine.servicce.FeatureService;
import per.wph.info.model.UserInfo;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;
import java.util.function.Function;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-02 18:04
 * =============================================
 */
@Controller
@RequestMapping("/eng")
public class EngineController extends BaseController{
    @Value("${fileUpload.path}")
    private String IMAGE_BUFF_PATH;

    /**
     *
     * @param fid
     * @param response
     * @throws IOException
     */
    @RequestMapping("/getImage")
    public void getImageByUsername( Long fid, HttpServletResponse response) throws IOException {
        Object username = SecurityUtils.getSubject().getPrincipal();
        if(username!=null){
            FaceFeature faceFeature = featureService.getFaceFeatureByFid(fid);
            OutputStream os = response.getOutputStream();
            os.write(faceFeature.getImage());
            os.close();
        }
    };

    @RequestMapping("/deleteImage")
    public @ResponseBody ApiResult deleteImageByUsername(Long fid){
        Object username = SecurityUtils.getSubject().getPrincipal();
        if(username!=null){
            featureService.deleteImageByFid(fid);
        }
        return ApiResultGenerator.succssResult("删除成功");
    };

    @RequestMapping("/checkFeature")
    @Transactional
    public @ResponseBody ApiResult uploadImage(@RequestParam("file") MultipartFile file, Integer mid ,HttpSession session) throws DllUnavailableException{
        String path = IMAGE_BUFF_PATH + session.getId() + mid;
        File mfile = new File(path);
        FaceFeature faceFeature = new FaceFeature();
        try {
            file.transferTo(mfile);
            FaceModel.ByValue faceModel = EngineDllManager.getFeatureByImage(path);
            Object faceIdMap =  session.getAttribute(FACE_MODEL_LIST);
            if(null == faceIdMap){
                faceIdMap = new HashMap<Integer,Long>();
                session.setAttribute(FACE_MODEL_LIST,faceIdMap);

            }
            faceFeature.setImage(FileUtil.readAsByteArray(mfile));
            faceFeature.setCreateTime(new Date());
            faceFeature.setFeature(faceModel.pbFeature.getByteArray(0,faceModel.lFeatureSize));
            featureService.saveFeatureInfo(faceFeature);
            ((HashMap<Integer,Long>)faceIdMap).put(mid,faceFeature.getFid());
        }catch (IOException e){
            return ApiResultGenerator.errorResult("文件读取异常",e);
        }catch (ZeroFaceException e){
            return ApiResultGenerator.errorResult("检测人脸失败",e);
        }catch (Exception e){
            throw e;
        }
        finally {
            if(mfile.exists()){
                mfile.delete();
            }
        }
        return ApiResultGenerator.succssResult(faceFeature.getFid());
    }


    @RequestMapping("/requestAccess")
    public @ResponseBody ApiResult checkAccess(@RequestParam("feature") MultipartFile file,Long bid,Long cid) throws DllUnavailableException, IOException {
//        File file = new File("test");
        InputStream is = file.getInputStream();
        File file1 = new File("test");
        FileOutputStream fos = new FileOutputStream(file1);
        byte[] bytes = new byte[20020];
        is.read(bytes);
        fos.write(bytes);
        fos.close();
        is.close();
        if(featureService.isAccess(file.getBytes(),cid,bid)) {
            return ApiResultGenerator.succssResult("识别成功");
        }else {
            return ApiResultGenerator.errorResult("识别失败",null);
        }
    }

}
