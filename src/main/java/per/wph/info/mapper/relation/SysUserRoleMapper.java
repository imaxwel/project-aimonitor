package per.wph.info.mapper.relation;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import per.wph.info.model.relation.SysUserRole;

@Mapper
@Repository
public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Long uid);

    int insert(SysUserRole record);

    SysUserRole selectByPrimaryKey(Long uid);

    List<SysUserRole> selectAll();

    int updateByPrimaryKey(SysUserRole record);
}