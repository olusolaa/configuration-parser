public class Main{

	public static void main(String[] args) {

		String paths = Environment.selectEnvironment(args);
		ConfigParser config = new ConfigParser(paths);
		System.out.println(config.get("theme"));
	}
}
