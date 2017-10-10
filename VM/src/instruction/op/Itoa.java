package instruction.op;

import data.Context;
import instruction.Instruction;
import instruction.MetaInstruction;

public class Itoa implements Instruction {
	MetaInstruction meta;
	@Override
	public boolean compile(MetaInstruction meta) {
		this.meta = meta;
		return true;
	}

	@Override
	public boolean run(Context context) {
		context.getStrings().allocate(meta.memory);
		context.getStrings().set(meta.memory,context.getRegisters().get(meta.in2).toString());
		return true;
	}

}
