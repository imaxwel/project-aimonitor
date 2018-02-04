package per.wph.info.mapper;

import java.util.List;
import per.wph.info.model.RecordVisitorVisit;

public interface RecordVisitorVisitMapper {
    int deleteByPrimaryKey(Long rid);

    int insert(RecordVisitorVisit record);

    RecordVisitorVisit selectByPrimaryKey(Long rid);

    List<RecordVisitorVisit> selectAll();

    int updateByPrimaryKey(RecordVisitorVisit record);
}