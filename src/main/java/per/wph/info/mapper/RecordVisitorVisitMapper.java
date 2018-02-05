package per.wph.info.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import per.wph.info.model.RecordVisitorVisit;

@Mapper
@Repository
public interface RecordVisitorVisitMapper {
    int deleteByPrimaryKey(Long rid);

    int insert(RecordVisitorVisit record);

    RecordVisitorVisit selectByPrimaryKey(Long rid);

    List<RecordVisitorVisit> selectAll();

    int updateByPrimaryKey(RecordVisitorVisit record);
}