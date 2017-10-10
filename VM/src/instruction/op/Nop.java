package instruction.op;

import data.Context;
import instruction.Instruction;
import instruction.MetaInstruction;

public class Nop implements Instruction {
	MetaInstruction meta;
	@Override
	public boolean compile(MetaInstruction meta) {
		this.meta = meta;
		return true;
	}

	@Override
	public boolean run(Context context) {
		// TODO Auto-generated method stub
		return true;
	}

}
