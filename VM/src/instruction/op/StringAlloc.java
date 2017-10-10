package instruction.op;

import data.Context;
import instruction.Instruction;
import instruction.MetaInstruction;

public class StringAlloc implements Instruction {
	MetaInstruction meta;
	@Override
	public boolean compile(MetaInstruction meta) {
		this.meta = meta;
		return true;
	}

	@Override
	public boolean run(Context context) {
		context.getStrings().allocate(meta.memory);
		context.getStrings().set(meta.memory, meta.in2);
		return true;
	}

}
