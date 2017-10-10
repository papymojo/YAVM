package instruction.op;

import data.Context;
import instruction.Instruction;
import instruction.MetaInstruction;

public class AllocateArray implements Instruction {
	MetaInstruction meta;
	@Override
	public boolean compile(MetaInstruction meta) {
		this.meta = meta;
		return true;
	}

	@Override
	public boolean run(Context context) {
		context.getMemory().allocate(meta.memory,meta.decode(meta.in2, context));
		return true;
	}

}
