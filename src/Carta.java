//package supertrunfo;

public class Carta {
    protected static String name;
    protected static String code;
    protected static String infoA;
    public String getInfoA() {
        return infoA;
    }


    public void setInfoA(String infoA) {
        Carta.infoA = infoA;
    }

    protected static String infoB;
    public String getInfoB() {
        return infoB;
    }


    public void setInfoB(String infoB) {
        Carta.infoB = infoB;
    }

    protected static String infoC;
    public Carta(String name, String code, String infoA, String infoB, String infoC, String[] elementos) {
        Carta.name = name;
        Carta.code = code;
        Carta.infoA = infoA;
        Carta.infoB = infoB;
        Carta.infoC = infoC;
    }


    public String getInfoC() {
        return infoC;
    }


    public void setInfoC(String infoC) {
        Carta.infoC = infoC;
    }

    

//================================================================================//


    public String getName() {
        return name;
    }
    public void setName(String name) {
        Carta.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        Carta.code = code;
    }
/*-------------------------------------------------------------------------------------//
    @Override
	public String toString() {
		return "Imóvel [código=" + getCode() + ", proprietário=" + proprietário + ", tipo=" + tipo + ", tamanho=" + tamanho
				+ ", valor=" + valor + ", situação=" + situação + ", reservadoPara=" + reservadoPara + "]";
	}*/

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

	public String[] getElementos() {
		return null;
	}
   

}
