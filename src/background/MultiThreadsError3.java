package background;

import java.util.HashMap;
import java.util.Map;

/**
 * 逸出
 * @author gelong
 * @date 2019/12/23 23:06
 */
public class MultiThreadsError3 {

    private Map<String, String> states = new HashMap<>();

    public MultiThreadsError3() {
        states.put("1", "周一");
        states.put("2", "周二");
        states.put("3", "周三");
        states.put("4", "周四");
    }

    public Map<String, String> getStates() {
        return states;
    }

    public static void main(String[] args) {
        MultiThreadsError3 multiThreadsError3 = new MultiThreadsError3();
        Map<String, String> states = multiThreadsError3.getStates();
        System.out.println(states.get("1"));
        states.remove(1);
        System.out.println(states.get(1));
    }

}
