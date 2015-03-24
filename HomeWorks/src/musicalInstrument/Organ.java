package musicalInstrument;

public class Organ extends WindKeyboards {
    @Override
    protected void checkSound() {
        checkPult();
        super.checkSound();
    }

    private void checkPult() {
        System.out.println("Check pult " + this);
    }

    @Override
    public void service() {
        checkSound();
        clean();
    }

}
