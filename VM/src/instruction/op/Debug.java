package instruction.op;

import data.Context;
import instruction.Instruction;
import instruction.MetaInstruction;

public class Debug implements Instruction{
	MetaInstruction meta;
	@Override
	public boolean compile(MetaInstruction meta) {
		this.meta = meta;
		return true;
	}

	@Override
	public boolean run(Context context) {
		System.out.println("PID : "+context.getPid()+" Registers : " +context.getRegisters()+" Message :  "+context.getStrings().get(meta.memory));
		return true;
	}
	
}
