package instruction;

import java.util.Map;


import data.Context;

public class Process implements Runnable {
	
private Context context;
private Map<Integer,MetaInstruction> sequence;

public Process(Context context,Map<Integer,MetaInstruction> sequence) {
	this.context = context;
	this.sequence = sequence;
}

public Context getContext() {
	return context;
}
public void run() {
	while (sequence.containsKey(context.ordinal)) {
		sequence.get(context.ordinal).compile(context, context.ordinal);
		sequence.get(context.ordinal).instruction.compile(sequence.get(context.ordinal));
		sequence.get(context.ordinal).instruction.run(context);
		context.ordinal++;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	System.out.println("######End of Thread (PID = "+context.getPid()+")######\n");
}
@Override
public String toString() {
	String code = new String();
	int i = 0;
	while (sequence.containsKey(i)) {
		code +=""+i+" -> "+ sequence.get(i).line+"\n";
		i++;
	}
	return code;
	
}
}
