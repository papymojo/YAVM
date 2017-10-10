package data;

public class Context {
public Integer ordinal = new Integer(0);
private RegisterBanch registers;
private Memory memory;
private StringMemory strings;
private Labels labels;
private Byte pid;
private static Byte pidcounter = new Byte((byte) 0);
public static String[] registerNames = {"R0","R1","R2","R3","R4","R5","R6","R7","R8","R9","R10","R11","R12","R13","R14","R15"};

public Context() {
	registers = new RegisterBanch(16,registerNames);
	memory = new Memory();
	strings = new StringMemory();
	labels = new Labels();
	pid = new Byte(pidcounter);
	pidcounter++;
}
public Context(Context context) {
	registers = new RegisterBanch(16,registerNames);
	memory = context.memory;
	strings = context.strings;
	labels = context.labels;
	pid = new Byte(pidcounter);
	pidcounter++;
}
public RegisterBanch getRegisters() {
	return registers;
}
public Memory getMemory() {
	return memory;
}
public Labels getLabels() {
	return labels;
}
public StringMemory getStrings() {
	return strings;
}
public Byte getPid() {
	return pid;
}
}
