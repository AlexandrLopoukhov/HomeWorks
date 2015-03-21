package musicalInstrument;

public class Triangles extends SelfSounding implements MetallFullBody {

	@Override
	public void service() {
		checkSound();
		clean();
		polysh();
	}

	@Override
	public void polysh() {
		System.out.println("Polysh " + this);
	}

}
