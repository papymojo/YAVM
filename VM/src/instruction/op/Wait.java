package instruction.op;

import data.Context;
import instruction.Instruction;
import instruction.MetaInstruction;

public class Wait implements Instruction {
	MetaInstruction meta;
	@Override
	public boolean compile(MetaInstruction meta) {
		this.meta = meta;
		return true;
	}

	@Override
	public boolean run(Context context) {
		Byte entry = context.getRegisters().get(meta.in1);
		while(!entry.equals(meta.decode(meta.in2,context))) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

}
