package data;

public class MemoryArray extends MemoryElement implements Data {
	
	private Byte content[] = null;

	@Override
	public void alloc() {
		// TODO Auto-generated method stub
		content =  new Byte[1];
	}
	
	public void alloc(int nbelement) {
		// TODO Auto-generated method stub
		content =  new Byte[nbelement];
	}

	@Override
	public void set(Byte data) {
		content[0] = data;
	}
	
	public void set(Byte data,int n) {
		content[n] = data;
	}

	@Override
	public Byte get() {
		return content[0];
	}
	
	public Byte get(int n) {
		return content[n];
	}

	@Override
	public void free() {
		// TODO Auto-generated method stub
		
	}

}
