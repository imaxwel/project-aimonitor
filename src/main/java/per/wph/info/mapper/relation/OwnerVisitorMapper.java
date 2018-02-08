package per.wph.info.mapper.relation;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import per.wph.info.model.relation.OwnerVisitor;

@Repository
@Mapper
public interface OwnerVisitorMapper {
    int insert(OwnerVisitor record);

    List<OwnerVisitor> selectAll();
}