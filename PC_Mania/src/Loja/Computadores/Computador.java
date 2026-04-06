package Loja.Computadores;

public class Computador {
    private String marca;
    private float preco;
    private MemoriaUSB memoriaUSB;
    private HardwareBasico[] hardware;
    private SistemaOperacional sistema;

    public Computador(){
        hardware = new HardwareBasico[10];
        sistema = new SistemaOperacional();
    }

    public void mostraPCConfigs(){
        System.out.println("Marca: " + this.marca);
        System.out.println("Hardware: ");
        for(int i = 0; i < hardware.length; i++){
            if (hardware[i] != null) {
                System.out.println("          " + hardware[i].getNome() + " | " + hardware[i].getCapacidade());
            }
        }
        System.out.println("");
        System.out.println("Sistema Operacional: " + this.sistema.getNome() + " | " + this.sistema.getTipo() + " bits");
        if (memoriaUSB != null){
            System.out.println("Possui memoria USB: " + this.memoriaUSB.getNome() + " de " + this.memoriaUSB.getCapacidade() + "Gb");
        } else { System.out.println("Não possui memoria USB"); }

        System.out.println("");
        System.out.println("");
    }

    void addMemoriaUSB(MemoriaUSB musb){
        memoriaUSB = musb;
    }


    //GETTERS E SETTERS
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public MemoriaUSB getMemoriaUSB() {
        return memoriaUSB;
    }

    public void setMemoriaUSB(MemoriaUSB memoriaUSB) {
        this.memoriaUSB = memoriaUSB;
    }


    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public HardwareBasico[] getHardware() {
        return hardware;
    }

    public SistemaOperacional getSistema() {
        return sistema;
    }
}
