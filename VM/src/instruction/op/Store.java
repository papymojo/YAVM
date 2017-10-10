package instruction.op;

import data.Context;
import instruction.Instruction;
import instruction.MetaInstruction;

public class Store implements Instruction {
	MetaInstruction meta;
	@Override
	public boolean compile(MetaInstruction meta) {
		this.meta = meta;
		return true;
	}

	@Override
	public boolean run(Context context) {
		if (context.getRegisters().isRegister(meta.in2))
			context.getMemory().set(meta.memory, context.getRegisters().get(meta.in2));
		else
			context.getMemory().set(meta.memory, Byte.parseByte(meta.in2));
		return true;
	}

}
