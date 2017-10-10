package instruction.op;

import data.Context;
import instruction.Instruction;
import instruction.MetaInstruction;
import instruction.Process;
import utils.ProgramBuilder;

public class Fork implements Instruction {

	@Override
	public boolean compile(MetaInstruction meta) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean run(Context context) {
		Process newprocess = ProgramBuilder.thread(context);
		newprocess.getContext().ordinal = context.ordinal +1;
		new Thread(newprocess).start();
		return true;
	}

}
