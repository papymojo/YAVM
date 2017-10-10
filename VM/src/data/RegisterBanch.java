package data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RegisterBanch {

	private Map<String,Register> banch = new HashMap<String,Register>();
	
	public RegisterBanch(int size,String[] name) {
		for(int i = 0 ; i < name.length ; i++) {
			Register register = new Register();
			register.alloc();
			register.set(new Byte((byte) 0));
			banch.put(name[i], register);
		}
	}
	public boolean set(String id,Byte val) {
		if (this.banch.containsKey(id)) {
			Register e = new Register();
			e.alloc();
			e.set(val);
			this.banch.replace(id,e);
			return true;	
		}
		return false;		
	}
	public boolean isRegister(String name) {
		return this.banch.containsKey(name);
	}
	
	public Byte get(String id) {
		return this.banch.get(id).get();
	}
	@Override
	public String toString() {
		String string = new String();
		Set<Entry<String, Register>> registers = banch.entrySet();
		Iterator<Entry<String, Register>> it = registers.iterator();
		while (it.hasNext()) {
			Entry<String, Register> entry = it.next();
			string += "|"+ entry.getKey() + "->"+entry.getValue().get();
		}
		return string;
	}
}
