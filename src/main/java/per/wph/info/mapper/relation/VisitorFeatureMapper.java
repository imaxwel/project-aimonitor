package per.wph.info.mapper.relation;

import java.util.List;
import per.wph.info.model.relation.VisitorFeature;

public interface VisitorFeatureMapper {
    int insert(VisitorFeature record);

    List<VisitorFeature> selectAll();
}