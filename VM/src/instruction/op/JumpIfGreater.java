package instruction.op;

import data.Context;
import instruction.Instruction;
import instruction.MetaInstruction;

public class JumpIfGreater implements Instruction{
	MetaInstruction meta;
	@Override
	public boolean compile(MetaInstruction meta) {
		this.meta = meta;
		return true;
	}

	@Override
	public boolean run(Context context) {
		if(meta.decode(meta.in1, context).compareTo(meta.decode(meta.in2, context))>0)
			context.ordinal = jump(context)-1;
		return true;
	}
	
	private Integer jump(Context context) {
		if (context.getLabels().isLabel(meta.out))
			return new Integer(context.getLabels().get(meta.out));
		else if (context.getRegisters().isRegister(meta.out))
			return new Integer(context.getRegisters().get(meta.out));
		else
			return Integer.parseInt(meta.out);
	}

}
