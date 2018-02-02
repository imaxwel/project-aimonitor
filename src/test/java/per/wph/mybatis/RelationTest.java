package per.wph.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import per.wph.info.mapper.relation.BuildingOwnerMapper;
import per.wph.info.mapper.relation.CommunityBuildingMapper;
import per.wph.info.model.relation.BuildingOwner;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-01 12:01
 * =============================================
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RelationTest {

    @Autowired
    private BuildingOwnerMapper buildingOwnerMapper;
    @Autowired
    private CommunityBuildingMapper communityBuildingMapper;
    @Test
    public void ownerBuildingTest(){
        BuildingOwner buildingOwner = new BuildingOwner();
        buildingOwner.setBid(1L);
        buildingOwner.setOid(39L);
        buildingOwnerMapper.selectByOid(39L);

    }
    @Test
    public void setCommunityBuildingTest(){
        communityBuildingMapper.selectByCid(1L);
    }
}
