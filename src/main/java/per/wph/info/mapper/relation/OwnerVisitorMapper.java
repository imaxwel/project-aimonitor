package per.wph.info.mapper.relation;

import java.util.List;
import per.wph.info.model.relation.OwnerVisitor;

public interface OwnerVisitorMapper {
    int insert(OwnerVisitor record);

    List<OwnerVisitor> selectAll();
}