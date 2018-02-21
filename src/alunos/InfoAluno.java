package alunos;

public enum InfoAluno {
	
	EMAIL {
		public String setEmail(String email) {
			if (!email.contains("@")) {
				throw new NullPointerException();
			} else {
				return email;
			}
		}
	};
	

	private InfoAluno() {
		
	}
}
