package instruction.op;

import data.Context;
import instruction.Instruction;
import instruction.MetaInstruction;

public class Jump implements Instruction{
	MetaInstruction meta;
	@Override
	public boolean compile(MetaInstruction meta) {
		this.meta = meta;
		return true;
	}

	@Override
	public boolean run(Context context) {
		if (context.getLabels().isLabel(meta.in1))
			context.ordinal = new Integer(context.getLabels().get(meta.memory)-1);
		else if (context.getRegisters().isRegister(meta.in1))
			context.ordinal = new Integer(context.getRegisters().get(meta.in1)-1);
		else
			context.ordinal = Integer.parseInt(meta.in1)-1;
		return true;
	}

}
