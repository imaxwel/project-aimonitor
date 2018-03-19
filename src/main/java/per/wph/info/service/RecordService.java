package per.wph.info.service;

import per.wph.info.model.view.RecordOwnerView;

import java.util.List;

public interface RecordService extends BaseService {
    List<RecordOwnerView> getAllOwnerRecordByUsername(String username,int pageNum,int pageSize);

    List<RecordOwnerView> getAllOwnerRecordByUsername(String username);
}
