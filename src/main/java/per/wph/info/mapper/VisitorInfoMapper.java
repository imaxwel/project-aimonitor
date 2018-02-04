package per.wph.info.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import per.wph.info.model.VisitorInfo;

@Mapper
@Repository
public interface VisitorInfoMapper {
    int deleteByPrimaryKey(Long vid);

    int insert(VisitorInfo record);

    VisitorInfo selectByPrimaryKey(Long vid);

    List<VisitorInfo> selectAll();

    int updateByPrimaryKey(VisitorInfo record);
}