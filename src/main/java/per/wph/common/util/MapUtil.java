package per.wph.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-04 9:44
 * =============================================
 */
public class MapUtil {

    public static<T> List<T> mapFiltByIds(Map<Integer,T> map, Integer[] ids){
        List<T> retList = new ArrayList<T>();
        Iterator<Map.Entry<Integer,T>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            for(Integer id : ids){
                Map.Entry<Integer,T> t = iterator.next();
                if(t.getKey().equals(id)){
                    retList.add(t.getValue());
                }
            }
        }
        return retList;
    }
}
