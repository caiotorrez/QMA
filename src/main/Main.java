package main;

import easyaccept.EasyAccept;

public class Main {

	public static void main(String[] args) {
		args = new String[] { "controller.Controller", "testesAceitacao/us1_test.txt",
				"testesAceitacao/us2_test.txt" };
		EasyAccept.main(args);
	}

}
