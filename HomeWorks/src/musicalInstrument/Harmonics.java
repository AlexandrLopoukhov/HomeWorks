package musicalInstrument;

public abstract class Harmonics extends Reed {

    protected void colibrateReeds() {
        System.out.println("Colybrate reeds " + this);
    }

    @Override
    protected void checkSound() {
        checkReeds();
        super.checkSound();
    }

    private void checkReeds() {
        System.out.println("Check reeds" + this);
    }
}
