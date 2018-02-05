package per.wph.info.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import per.wph.info.model.RecordStrangerVisit;

@Mapper
@Repository
public interface RecordStrangerVisitMapper {
    int deleteByPrimaryKey(Long rid);

    int insert(RecordStrangerVisit record);

    RecordStrangerVisit selectByPrimaryKey(Long rid);

    List<RecordStrangerVisit> selectAll();

    int updateByPrimaryKey(RecordStrangerVisit record);
}