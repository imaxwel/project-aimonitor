package per.wph.common.generator;

import per.wph.common.ApiResult;

import java.util.List;
import java.util.Random;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-01-31 10:34
 * =============================================
 */
public class RandomGenerator {
    public static Integer idenCode(){
        Random random = new Random();
        return random.nextInt(90000) + 10000;
    }
}
