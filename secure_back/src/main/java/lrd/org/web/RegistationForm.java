package lrd.org.web;

public class RegistationForm {
	 private String username;
	    private String password;
	    private String repassword;
	    
		public RegistationForm() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		@Override
		public String toString() {
			return "RegistationForm [username=" + username + ", password=" + password + ", repassword=" + repassword + "]";
		}


		public RegistationForm(String username, String password, String repassword) {
			super();
			this.username = username;
			this.password = password;
			this.repassword = repassword;
		}


		public String getUsername() {
			return username;
		}
		public void setUsername(String userame) {
			this.username = userame;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRepassword() {
			return repassword;
		}
		public void setRepassword(String repassword) {
			this.repassword = repassword;
		}
}
