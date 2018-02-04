package per.wph.info.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import per.wph.info.model.SysRole;

import java.util.Set;

@Mapper
@Repository
public interface SysRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    //根据id集合获得SysRole对象
    Set<SysRole> selectByPrimaryKeys(Set<Long> ids);


    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    int insertUserRole(@Param("uid") Long uid, @Param("roleId") Long roleId);
}