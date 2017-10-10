package data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StringMemory {
private static Map<String,String> allocated = new HashMap<String,String>();
	
	public StringMemory() {
		for(int i = 1; i < 127 ; i++) {
			allocated.put(Character.getName(i),new String(""+(char) i));
		}
	}

	public boolean allocate(String id) {
		if (allocated.containsKey(id))
			return false;
		allocated.put(id, new String());
		return true;
	}
	
	public synchronized boolean set(String id,String val) {
		if (allocated.containsKey(id)) {
			allocated.replace(id,new String(val));
			return true;	
		}
		return false;		
	}
	
	public String get(String id) {
		return allocated.get(id);
	}
	
	@Override
	public String toString() {
		String str = new String();
		Set<Entry<String, String>> strs = allocated.entrySet();
		Iterator<Entry<String, String>> itt = strs.iterator();
		while ( itt.hasNext()) {
			str += "|";
			for ( int i = 0 ; i < 4 && itt.hasNext() ; i++) {
				Entry<String, String> e = itt.next();
				str += e.getKey() + "->" + e.getValue() + "|";
			}
			str+="\n";
		}
		return str;
	}
}
