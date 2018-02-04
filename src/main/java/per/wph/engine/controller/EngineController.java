package per.wph.engine.controller;

import org.apache.ibatis.annotations.Param;
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

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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


    @RequestMapping("/checkFeature")
    @Transactional
    public @ResponseBody ApiResult uploadImage(@RequestParam("file") MultipartFile file, Integer mid ,HttpSession session) throws DllUnavailableException{
        String path = IMAGE_BUFF_PATH + session.getId() + mid;
        File mfile = new File(path);
        try {
            file.transferTo(mfile);
            FaceModel.ByValue faceModel = EngineDllManager.getFeatureByImage(path);
            Object faceIdMap =  session.getAttribute(FACE_MODEL_LIST);
            if(null == faceIdMap){
                faceIdMap = new HashMap<Integer,Long>();
                session.setAttribute(FACE_MODEL_LIST,faceIdMap);
            }

            FaceFeature faceFeature = new FaceFeature();
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
        return ApiResultGenerator.succssResult("图片有效");
    }

    @Autowired
    FaceFeatureMapper faceFeatureMapper;

    @RequestMapping("/test")
    public @ResponseBody ApiResult test() throws DllUnavailableException {
        FaceFeature faceFeature = faceFeatureMapper.selectAll().get(1);
        List<OwnerFaceFeatureView> ownerFaceFeatureViews = new ArrayList<OwnerFaceFeatureView>();
        if(featureService.isOwner(faceFeature.getFeature(),1L,1L,false,ownerFaceFeatureViews)) {
            return ApiResultGenerator.succssResult("识别成功");
        }else {
            return ApiResultGenerator.errorResult("识别失败",null);
        }
    }

}
