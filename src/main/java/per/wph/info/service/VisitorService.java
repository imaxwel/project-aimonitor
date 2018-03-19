package per.wph.info.service;

import per.wph.info.model.VisitorInfo;
import per.wph.info.model.relation.OwnerVisitor;
import per.wph.info.model.relation.VisitorFeature;
import per.wph.info.model.view.VisitorRegistView;
import sun.reflect.generics.visitor.Visitor;

import java.util.List;

public interface VisitorService extends BaseService{
    int saveVisitorRegistView(VisitorRegistView visitorRegistView);


    /**
     * 判断访客是否在可用期限内
     * @param vid
     * @return
     */
    boolean visitorAvailable(Long vid);

    List<VisitorInfo> getVisitorInfoListByAdminUsername(String username);
}
