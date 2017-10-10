package runtime;

import java.io.File;

import instruction.Process;
import utils.ProgramBuilder;
import utils.ProgramReader;

public class Main {

	public static void main(String[] args) {
		Process prog = ProgramBuilder.build(new ProgramReader(new File("./test.txt")));
		prog.run();
	}

}
