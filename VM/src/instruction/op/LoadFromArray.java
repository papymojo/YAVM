package instruction.op;

import data.Context;
import instruction.Instruction;
import instruction.MetaInstruction;

public class LoadFromArray implements Instruction {
	MetaInstruction meta;
	@Override
	public boolean compile(MetaInstruction meta) {
		this.meta = meta;
		return true;
	}

	@Override
	public boolean run(Context context) {
		context.getRegisters().set(meta.out, context.getMemory().get(meta.in1,meta.decode(meta.in2,context)));
		return true;
	}

}
