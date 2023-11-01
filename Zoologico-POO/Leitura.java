//Nome: Gabriel Kenji Inoue
//RA: 2504170

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Leitura{

	public String entDados(String rotulo){

		System.out.println(rotulo);
		String retStr = "";

		InputStreamReader tec = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(tec);

		try {
			retStr = buff.readLine(); }

		catch(IOException ioe) {
			System.out.println("\nERRO"); }

		return retStr;
	}

}