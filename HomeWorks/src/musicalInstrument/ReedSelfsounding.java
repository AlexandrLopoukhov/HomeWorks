package musicalInstrument;

public abstract class ReedSelfsounding extends Reed implements MetallFullBody {
    @Override
    protected void clean() {
        polysh();
        super.clean();
    }

    public void polysh() {
        System.out.println("Polysh " + this);
    }
}
