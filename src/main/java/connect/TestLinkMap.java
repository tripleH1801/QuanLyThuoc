package connect;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import entity.Thuoc;

public class TestLinkMap {
	public static void main(String[] args) {
		Map<Thuoc, Integer> map1 = new LinkedHashMap<Thuoc, Integer>();
//		map1.put(new Thuoc("2312", 123), 10);
		map1.put(new Thuoc("1823"), 1);
//		System.out.println(map1.get));
//		map1.ent
		Set<Entry<Thuoc, Integer>> t = map1.entrySet();
		List<Entry<Thuoc, Integer>> targetList = new ArrayList<Entry<Thuoc, Integer>>(t);
		System.out.println(targetList.get(0).getValue());
		
	}
}
