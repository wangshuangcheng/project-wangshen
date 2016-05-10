package qunar;

import com.google.common.collect.Maps;
import org.junit.Test;
import qunar.cache.LRULinkedHashMap;

import javax.swing.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by shuangchengwang on 16-3-11.
 * shuangcheng.wang
 */
public class Main {

    @Test
    public void test1() throws InterruptedException {

        LRULinkedHashMap<Object,Object> map = LRULinkedHashMap.create(4);    //指定长度为4，如果大于四个则删除最老的元素
        map.put("aaa",1);
        map.put("bbb",2);
        map.put("ccc",3);
        map.put("ddd",4);
	map.put("wife",2);
	map.put("husband",2);

        map.flash(5);    //设置了缓存的有效时间，当时间到了自动清楚缓存
        Thread.sleep(7000);//为了看到效果，让主线程休息7秒钟，由于刷新时间为5秒，所以肯定没有了数据

        map.get("aaa");    //这样访问了之后，aaa就不会被删除了
        map.put("eee",5);


        for(Iterator<Map.Entry<Object, Object>> it=map.entrySet().iterator();it.hasNext();){
            System.out.println(it.next().getKey());
        }

    }
}
