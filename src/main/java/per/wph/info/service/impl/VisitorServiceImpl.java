package per.wph.info.service.impl;

import org.springframework.stereotype.Service;
import per.wph.common.service.BaseServiceImpl;
import per.wph.info.model.VisitorInfo;
import per.wph.info.model.relation.OwnerVisitor;
import per.wph.info.model.relation.VisitorFeature;
import per.wph.info.model.view.VisitorRegistView;
import per.wph.info.service.VisitorService;

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
    @Override
    public int saveVisitorRegistView(VisitorRegistView visitorRegistView) {
        return 0;
    }
}
