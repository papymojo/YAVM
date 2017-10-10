package instruction;

import data.Context;

public class MetaInstruction {
	public String label = null;
	public String op;
	public String memory;
	public String in1;
	public String in2;
	public String out;
	public String line;
	public Instruction instruction;
	
	public void compile(Context context,int adress) {
		try {
			instruction = (Instruction) (Class.forName("instruction.op."+op).newInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Byte decode(String s,Context context) {
		if (context.getRegisters().isRegister(s))
			return new Byte(context.getRegisters().get(s));
		else
			return Byte.parseByte(s);
	}
}
