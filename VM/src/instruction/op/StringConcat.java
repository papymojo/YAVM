package instruction.op;

import data.Context;
import instruction.Instruction;
import instruction.MetaInstruction;

public class StringConcat implements Instruction {
	MetaInstruction meta;
	@Override
	public boolean compile(MetaInstruction meta) {
		this.meta = meta;
		return true;
	}

	@Override
	public boolean run(Context context) {
		context.getStrings().allocate(meta.out);
		context.getStrings().set(meta.out, new String(context.getStrings().get(meta.in1)+context.getStrings().get(meta.in2)));
		return true;
	}

}
