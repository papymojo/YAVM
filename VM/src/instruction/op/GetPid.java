package instruction.op;

import data.Context;
import instruction.Instruction;
import instruction.MetaInstruction;

public class GetPid implements Instruction {
	MetaInstruction meta;
	@Override
	public boolean compile(MetaInstruction meta) {
		this.meta = meta;
		return true;
	}

	@Override
	public boolean run(Context context) {
		context.getRegisters().set(meta.in1, context.getPid());
		return true;
	}

}
