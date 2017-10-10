package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgramReader {

	BufferedReader br = null;
	
	public ProgramReader(File f) {
	try {
		FileInputStream fis = new FileInputStream(f);
		br = new BufferedReader(new InputStreamReader(fis));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	public boolean hasNext() {
		try {
			return br.ready();
		} catch (IOException e) {
			return false;
		}
	}
	public String next() {
		try {
			return (String) br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void finalize() {
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

