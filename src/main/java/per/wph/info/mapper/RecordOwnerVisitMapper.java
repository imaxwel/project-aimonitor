package per.wph.info.mapper;

import java.util.List;
import per.wph.info.model.RecordOwnerVisit;

public interface RecordOwnerVisitMapper {
    int deleteByPrimaryKey(Long rid);

    int insert(RecordOwnerVisit record);

    RecordOwnerVisit selectByPrimaryKey(Long rid);

    List<RecordOwnerVisit> selectAll();

    int updateByPrimaryKey(RecordOwnerVisit record);
}