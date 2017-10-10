package instruction.op;

import java.util.Scanner;

import data.Context;
import instruction.Instruction;
import instruction.MetaInstruction;

public class Scan implements Instruction{
	MetaInstruction meta;
	@Override
	public boolean compile(MetaInstruction meta) {
		this.meta = meta;
		return true;
	}

	@Override
	public boolean run(Context context) {
		Scanner scan = new Scanner(System.in);
		context.getStrings().allocate(meta.memory);
		context.getStrings().set(meta.memory, scan.nextLine());
		scan.close();
		return true;
	}
	
}
