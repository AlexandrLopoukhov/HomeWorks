package musicalInstrument;

public class Bell extends DefinedTone implements MetallFullBody {

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
