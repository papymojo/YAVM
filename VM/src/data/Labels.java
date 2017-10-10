package data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Labels {
	private Map<String,Integer> labels = new HashMap<String,Integer>();
	
	public boolean allocate(String id) {
		if (this.labels.containsKey(id))
			return false;
		this.labels.put(id, 0);
		return true;
	}
	
	public boolean set(String id,int address) {
		if (this.labels.containsKey(id)) {
			this.labels.replace(id,address);
			return true;	
		}
		return false;		
	}
	
	public int get(String id) {
		return this.labels.get(id).intValue();
	}
	
	public boolean isLabel(String id) {
		return labels.containsKey(id);
	}
	@Override
	public String toString() {
		String str = new String();
		Iterator<Entry<String, Integer>> itt = labels.entrySet().iterator();
		while(itt.hasNext()) {
			 Entry<String, Integer> e = itt.next();
			str += "|" + e.getKey() + "->"+e.getValue();
		}
		str +="|\r";
		return str;
	}
}
