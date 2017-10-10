package instruction.op;

import data.Context;
import instruction.Instruction;
import instruction.MetaInstruction;

public class Print implements Instruction{
	MetaInstruction meta;
	@Override
	public boolean compile(MetaInstruction meta) {
		this.meta = meta;
		return true;
	}

	@Override
	public boolean run(Context context) {
		System.out.println(context.getStrings().get(meta.memory));
		return true;
	}
	
}
