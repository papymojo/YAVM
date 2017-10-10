package instruction.op;

import data.Context;
import instruction.Instruction;
import instruction.MetaInstruction;

public class Atoi implements Instruction {
	MetaInstruction meta;
	@Override
	public boolean compile(MetaInstruction meta) {
		this.meta = meta;
		return true;
	}

	@Override
	public boolean run(Context context) {
		context.getRegisters().set(meta.in2,Byte.parseByte(context.getStrings().get(meta.memory)));
		return true;
	}

}
