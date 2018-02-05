package per.wph.info.mapper;

import java.security.Signature;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import per.wph.info.model.RecordOwnerVisit;
import per.wph.info.model.view.RecordOwnerView;

@Mapper
@Repository
public interface RecordOwnerVisitMapper {
    int deleteByPrimaryKey(Long rid);

    int insert(RecordOwnerVisit record);

    RecordOwnerVisit selectByPrimaryKey(Long rid);

    List<RecordOwnerVisit> selectAll();

    int updateByPrimaryKey(RecordOwnerVisit record);

    List<RecordOwnerView> selectAllRecordOwnerViewByUsername(String username);
}