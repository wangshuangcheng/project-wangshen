package qunar.cache;

import java.util.HashMap;
import java.util.TimerTask;

/**
 * Created by shuangchengwang on 16-3-12.
 */
public class FlushThread<K extends Object,V extends Object> extends TimerTask {
    private HashMap< K, V> map;

    public FlushThread(HashMap<K, V> map) {
        this.map = map;
    }

    @Override
    public void run() {
        map.clear();
    }
}
