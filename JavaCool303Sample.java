package JavaCool303;
import javax.naming.LimitExceededException;

public class JavaCool303Sample {
	public static void main(String[] args) {
		Cool303Theme stheme = new Cool303SummerTheme();
		Cool303Root root = new Cool303Root(stheme,300,300);
		Cool303Container container = new Cool303Container(7,3);
		try {
			for(int i = 0; i < 20; i++) {
				container.add(new Cool303Button(i+1));
			}
		}
		catch(LimitExceededException e) {
			System.out.println("Added too many components");
		}
		container.setName("Example!");
		root.addContainer(container);
		root.launch();
	}
}
