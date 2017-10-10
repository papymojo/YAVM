package instruction;

public class Parser {
	private MetaInstruction meta = new MetaInstruction();
	public Parser(int adress, String line) {
		meta.line = line;
		String[] label = line.split(":");
		if (label.length == 2) {
			meta.label = label[0].trim();
			line = label[1].trim();
		}
		String[] op = line.trim().split(" ");
		meta.op = op[0];
		if (meta.op.isEmpty() || meta.op.equals("#")) {
			meta.op = "Nop";
			return;
		}
		line = line.substring(meta.op.length(), line.length());
		String[] data = line.split(",");
		if (data.length == 1) {
			meta.memory = data[0].trim();
			meta.in1 = data[0].trim();
			meta.in2 = data[0].trim();
			meta.out = data[0].trim();	
		} else if (data.length == 2) {
			meta.memory = data[0].trim();
			meta.in1 = data[0].trim();
			meta.in2 = data[1].trim();
			meta.out = data[1].trim();
		} else if (data.length == 3) {
			meta.memory = data[2].trim();
			meta.in1 = data[0].trim();
			meta.in2 = data[1].trim();
			meta.out = data[2].trim();		
		}
		return;
	}

	public MetaInstruction getMeta() {
		return meta;
	}
	
}
