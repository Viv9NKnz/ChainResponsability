// Clase abstracta para manejar el dispensador
abstract class Dispensador {
    protected Dispensador siguienteDispensador;

    public void setSiguiente(Dispensador siguienteDispensador) {
        this.siguienteDispensador = siguienteDispensador;
    }

    public abstract void dispensar(int monto);
}

// Clases concreta para cada denominación de billetes
class Dispensador100000 extends Dispensador {
    @Override
    public void dispensar(int monto) {
        if (monto >= 100000) {
            int numBilletes = monto / 100000;
            int montoRestante = monto % 100000;
            System.out.println("Dispensando " + numBilletes + " billetes de 100.000$");
            if (montoRestante != 0 && siguienteDispensador != null) {
                siguienteDispensador.dispensar(montoRestante);
            }
        } else if (siguienteDispensador != null) {
            siguienteDispensador.dispensar(monto);
        }
    }
}

class Dispensador50000 extends Dispensador {
    @Override
    public void dispensar(int monto) {
        if (monto >= 50000) {
            int numBilletes = monto / 50000;
            int montoRestante = monto % 50000;
            System.out.println("Dispensando " + numBilletes + " billetes de 50.000$");
            if (montoRestante != 0 && siguienteDispensador != null) {
                siguienteDispensador.dispensar(montoRestante);
            }
        } else if (siguienteDispensador != null) {
            siguienteDispensador.dispensar(monto);
        }
    }
}

class Dispensador20000 extends Dispensador {
    @Override
    public void dispensar(int monto) {
        if (monto >= 20000) {
            int numBilletes = monto / 20000;
            int montoRestante = monto % 20000;
            System.out.println("Dispensando " + numBilletes + " billetes de 20.000$");
            if (montoRestante != 0 && siguienteDispensador != null) {
                siguienteDispensador.dispensar(montoRestante);
            }
        } else if (siguienteDispensador != null) {
            siguienteDispensador.dispensar(monto);
        }
    }
}

class Dispensador10000 extends Dispensador {
    @Override
    public void dispensar(int monto) {
        if (monto >= 10000) {
            int numBilletes = monto / 10000;
            int montoRestante = monto % 10000;
            System.out.println("Dispensando " + numBilletes + " billetes de 10.000$");
            if (montoRestante != 0 && siguienteDispensador != null) {
                siguienteDispensador.dispensar(montoRestante);
            }
        } else if (siguienteDispensador != null) {
            siguienteDispensador.dispensar(monto);
        }
    }
}

// Clase principal para el Cajero Automático
class CajeroAutomatico {
    private final Dispensador dispensador;

    public CajeroAutomatico() {
        // Crear dispensadores para cada denominación
        this.dispensador = new Dispensador100000();
        Dispensador dispensador50 = new Dispensador50000();
        Dispensador dispensador20 = new Dispensador20000();
        Dispensador dispensador10 = new Dispensador10000();

        // Configurar la cadena de responsabilidad
        dispensador.setSiguiente(dispensador50);
        dispensador50.setSiguiente(dispensador20);
        dispensador20.setSiguiente(dispensador10);
    }

    public void dispensarDinero(int monto) {
        if (monto % 5000 != 0) {
            System.out.println("Error: El monto debe ser un múltiplo de 5000.");
        } else {
            dispensador.dispensar(monto);
        }
    }
}

// Clase de ejecución
public class ChainResponsability {
    public static void main(String[] args) {
        CajeroAutomatico cajero = new CajeroAutomatico();
        cajero.dispensarDinero(580000);
    }
}
