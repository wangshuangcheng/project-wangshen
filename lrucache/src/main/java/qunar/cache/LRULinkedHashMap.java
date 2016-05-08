package qunar.cache;

import java.util.*;

/**
 * 参考网上的写法，他写的太好了，能改的实在不多。。。。，但是基本原理都懂了，也去看了LinkedHashMap的源码
 * <p/>
 * Created by shuangchengwang on 16-3-11.
 */
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;    //设置什么时候扩展
    private static final Integer DEFAULT_CAPACITY_SIZE = 16;
    private static LRULinkedHashMap<Object, Object> map = null;
    private final int maxCapacity;    //空间大小


    //设置成true以后就会按访问顺序排序
    private LRULinkedHashMap(int maxCapacity) {
        super(maxCapacity, DEFAULT_LOAD_FACTOR, true);
        this.maxCapacity = maxCapacity;
    }

    private LRULinkedHashMap() {
        super(DEFAULT_CAPACITY_SIZE, DEFAULT_LOAD_FACTOR, true);
        this.maxCapacity = DEFAULT_CAPACITY_SIZE;
    }

    /**
     * 简单的单列
     *
     * @param maxCapacity
     * @return
     */
    public static LRULinkedHashMap<Object, Object> create(int maxCapacity) {
        if (map == null) {
            map = new LRULinkedHashMap<Object, Object>(maxCapacity);
        }
        return map;
    }

    /**
     * 如果size比制定的最大长度大，则删除最老的元素,如果不重写默认为false，就永远也不会移除最久的元素
     *
     * @param eldest
     * @return
     */
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        return size() > maxCapacity;
    }


    public boolean containsKey(Object key) {
        return super.containsKey(key);
    }


    public V get(Object key) {
        return super.get(key);

    }


    public V put(K key, V value) {
        return super.put(key, value);

    }

    public int size() {
        return super.size();

    }

    public void clear() {
        super.clear();

    }

    public Collection<Map.Entry<K, V>> getAll() {
        return new ArrayList<Map.Entry<K, V>>(super.entrySet());
    }

    /**
     * 缓存的刷新时间
     * @param minutes
     */
    public void flash(int minutes) {
        Timer timer = new Timer();
        timer.schedule(new FlushThread(map),minutes*1000);
    }

}