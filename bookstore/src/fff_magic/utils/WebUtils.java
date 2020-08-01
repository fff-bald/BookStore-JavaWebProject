package fff_magic.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    /** 把 Map 中的值注入到对应的 JavaBean 属性中。
     *  @param value
     *  @param bean
     */
    public static <T> T copyParamToBean(Map value , T bean ){
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /*** 将字符串转换成为 int 类型的数据
     *  @param strInt
     *  @param defaultValue
     *  @return
     */
    public static int parseInt(String strInt,int defaultValue) {
        if(strInt!=null){
            try {
                return Integer.parseInt(strInt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            return defaultValue;
    }
}
