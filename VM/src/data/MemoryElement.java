package data;

public class MemoryElement implements Data{
	
	private Byte content = 0;

	@Override
	public void alloc() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(Byte data) {
		content = data;
	}

	@Override
	public Byte get() {
		return content;
	}

	@Override
	public void free() {
		// TODO Auto-generated method stub
		
	}

}
