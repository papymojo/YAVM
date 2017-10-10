package utils;

import java.util.HashMap;
import java.util.Map;

import data.Context;
import instruction.MetaInstruction;
import instruction.Parser;
import instruction.Process;

public class ProgramBuilder {
	private static Map<Integer,MetaInstruction> sequence = new HashMap<Integer, MetaInstruction>();
	public static Process build(ProgramReader pr) {
		Context context = new Context();
		int address = 0;
		while(pr.hasNext()) {
			String line = pr.next();
			MetaInstruction meta = new Parser(address, line).getMeta();
			sequence.put(new Integer(address), meta);
			if (meta.label != null) {
				context.getLabels().allocate(meta.label);
				context.getLabels().set(meta.label, address);
			}	
			address++;
		}
		Process p = new Process(context,sequence);
		System.out.println("######String Memory######");
		System.out.println(context.getStrings());
		System.out.println("######Label Table#######");
		System.out.println(context.getLabels());
		System.out.println("######Program Memory######");
		System.out.println(p);
		System.out.println("######Main Thread Created (PID = "+p.getContext().getPid()+") ######\n");
		return p;
		
	}
	public static Process thread(Context context) {
		Process p = new Process(new Context(context),sequence);
		System.out.println("######New Thread Created (PID = "+p.getContext().getPid()+") ######\n");
		return p;
	}
}
