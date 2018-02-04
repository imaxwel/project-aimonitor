package per.wph.info.mapper;

import java.util.List;
import per.wph.info.model.RecordStrangerVisit;

public interface RecordStrangerVisitMapper {
    int deleteByPrimaryKey(Long rid);

    int insert(RecordStrangerVisit record);

    RecordStrangerVisit selectByPrimaryKey(Long rid);

    List<RecordStrangerVisit> selectAll();

    int updateByPrimaryKey(RecordStrangerVisit record);
}