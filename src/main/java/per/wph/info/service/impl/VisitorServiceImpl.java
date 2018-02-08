package per.wph.info.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import per.wph.common.annotation.UnTest;
import per.wph.common.service.BaseServiceImpl;
import per.wph.info.model.OwnerInfo;
import per.wph.info.model.VisitorInfo;
import per.wph.info.model.relation.*;
import per.wph.info.model.view.VisitorRegistView;
import per.wph.info.service.VisitorService;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-04 14:52
 * =============================================
 */
@Service
public class VisitorServiceImpl extends BaseServiceImpl implements VisitorService {
    @UnTest
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveVisitorRegistView(VisitorRegistView visitorRegistView) {
        VisitorInfo visitorInfo = new VisitorInfo();
        visitorInfo.setPhone(visitorRegistView.getPhone());
        visitorInfo.setName(visitorRegistView.getName());
        visitorInfo.setIdnumber(visitorRegistView.getIdnumber());
        visitorInfo.setCreatTime(new Date());
        visitorInfoMapper.insert(visitorInfo);
        //关联业主访客对象
        OwnerVisitor ownerVisitor = new OwnerVisitor();
        ownerVisitor.setAllowBegin(visitorRegistView.getAllowBegin());
        ownerVisitor.setAllowEnd(visitorRegistView.getAllowEnd());
        ownerVisitor.setOid(visitorRegistView.getOid());
        ownerVisitor.setVid(visitorInfo.getVid());
        ownerVisitor.setRelationType(visitorRegistView.getRelationType());
        ownerVisitorMapper.insert(ownerVisitor);
        return 1;
    }

    @Override
    public boolean visitorAvailable(Long vid) {
        return false;
    }
}
