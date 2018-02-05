package per.wph.info.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import per.wph.common.service.BaseServiceImpl;
import per.wph.info.model.view.RecordOwnerView;
import per.wph.info.service.RecordService;

import java.util.List;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-05 10:05
 * =============================================
 */
@Service
public class RecordServiceImpl extends BaseServiceImpl implements RecordService {

    @Override
    public List<RecordOwnerView> getAllOwnerRecordByUsername(String username, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return recordOwnerVisitMapper.selectAllRecordOwnerViewByUsername(username);
    }
}
