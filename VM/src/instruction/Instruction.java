package instruction;

import data.Context;

public interface Instruction {
	MetaInstruction meta = null;
	public boolean compile(MetaInstruction meta);
	public boolean run(Context context);
}
