public class Atributo extends Carta{


    protected int atribA;
    protected int atribB;
    protected int atribC;
    protected int atribD;

    public Atributo( int atribA, int atribB, int atribC, int atribD){
        super(name,code, infoA, infoB, infoC, null);
        this.atribA = atribA;
        this.atribB = atribB;
        this.atribC = atribC;
        this.atribD = atribD;
    }


    public int getAtribA() {
        return atribA;
    }

    public void setAtribA(int atribA) {
        this.atribA = atribA;
    }

    public int getAtribB() {
        return atribB;
    }

    public void setAtribB(int atribB) {
        this.atribB = atribB;
    }

    public int getAtribC() {
        return atribC;
    }

    public void setAtribC(int atribC) {
        this.atribC = atribC;
    }

    public int getAtribD() {
        return atribD;
    }

    public void setAtribD(int atribD) {
        this.atribD = atribD;
    }


    @Override
    public String toString() {
        return "Atributo [atribA=" + atribA + ", atribB=" + atribB + ", atribC=" + atribC + ", atribD=" + atribD + "]";
    }
}
