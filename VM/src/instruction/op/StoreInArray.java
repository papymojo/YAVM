package instruction.op;

import data.Context;
import instruction.Instruction;
import instruction.MetaInstruction;

public class StoreInArray implements Instruction {
	MetaInstruction meta;
	@Override
	public boolean compile(MetaInstruction meta) {
		this.meta = meta;
		return true;
	}

	@Override
	public boolean run(Context context) {
			context.getMemory().set(meta.in1, meta.decode(meta.in2,context),meta.decode(meta.out, context));
		return true;
	}

}
