package data;

import java.util.HashMap;
import java.util.Map;

public class Memory {
	private static Map<String,MemoryElement> allocated = new HashMap<String,MemoryElement>();
	
	public boolean allocate(String id) {
		if (allocated.containsKey(id))
			return false;
		MemoryElement e = new MemoryElement();
		e.alloc();
		e.set(new Byte((byte) 0));
		allocated.put(id, e);
		return true;
	}
	
	public synchronized boolean set(String id,Byte val) {
		if (allocated.containsKey(id)) {
			allocated.get(id).set(val);;
			return true;	
		}
		return false;		
	}
	
	public Byte get(String id) {
		return allocated.get(id).get();
	}
	public boolean allocate(String id,int nbelements) {
		if (allocated.containsKey(id))
			return false;
		MemoryArray e = new MemoryArray();
		e.alloc(nbelements);
		for(int i = 0; i < nbelements;i++) {
			e.set(new Byte((byte) 0),i);
		}
		allocated.put(id, e);
		return true;
	}
	
	public synchronized boolean set(String id,Byte val,int i) {
		if (allocated.containsKey(id)) {
			((MemoryArray) allocated.get(id)).set(val,i);
			return true;	
		}
		return false;		
	}
	
	public Byte get(String id,int n) {
		return ((MemoryArray) allocated.get(id)).get();
	}
}
