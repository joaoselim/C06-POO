//ESSA CLASSE FOI CRIADA PARA GERAR TODOS OS PCs A SEREM VENDIDOS EM UM ESPAÇO SEPARADO
//                  E CARREGAR A LOJA PARA VISUALIZAÇÃO DO CLIENTE
package Loja.Computadores;

public class GeradorDePCs {

    //OS 3 PCs A SEREM VENDIDOS
    public Computador pc1;
    public Computador pc2;
    public Computador pc3;

    //GERA AS INSTANCIAS
    public GeradorDePCs() {
        //PC1
        pc1 = new Computador();
        pc1.setMarca("Apple");
        pc1.setPreco(631);
        pc1.getHardware()[0] = new HardwareBasico("Pentium Core i3", 2200);
        pc1.getHardware()[1] = new HardwareBasico("Memória RAM", 8);
        pc1.getHardware()[2] = new HardwareBasico("HD", 500);
        pc1.getSistema().setNome("macOS Sequoia");
        pc1.getSistema().setTipo(64);
        pc1.setMemoriaUSB(new MemoriaUSB());
        pc1.getMemoriaUSB().setNome("Pen-drive");
        pc1.getMemoriaUSB().setCapacidade(16);

        //PC2
        pc2 = new Computador();
        pc2.setMarca("Samsung");
        pc2.setPreco(1865);
        pc2.getHardware()[0] = new HardwareBasico("Pentium Core i5", 3370);
        pc2.getHardware()[1] = new HardwareBasico("Memória RAM", 16);
        pc2.getHardware()[2] = new HardwareBasico("HD", 1000);
        pc2.getSistema().setNome("Windows 8");
        pc2.getSistema().setTipo(64);
        pc2.setMemoriaUSB(new MemoriaUSB());
        pc2.getMemoriaUSB().setNome("Pen-drive");
        pc2.getMemoriaUSB().setCapacidade(32);

        //PC3
        pc3 = new Computador();
        pc3.setMarca("Dell");
        pc3.setPreco(6309);
        pc3.getHardware()[0] = new HardwareBasico("Pentium Core i7", 4500);
        pc3.getHardware()[1] = new HardwareBasico("Memória RAM", 32);
        pc3.getHardware()[2] = new HardwareBasico("HD", 2000);
        pc3.getSistema().setNome("Windows 10");
        pc3.getSistema().setTipo(64);
        pc3.setMemoriaUSB(new MemoriaUSB());
        pc3.getMemoriaUSB().setNome("HD Externo");
        pc3.getMemoriaUSB().setCapacidade(1000);
    }

    //CARREGA AS INFORMAÇÕES DOS COMPUTADORS
    public void CarregamentoDosPCs(){
        System.out.println("========== Computador 1 ==========");
        pc1.mostraPCConfigs();
        System.out.println("========== Computador 2 ==========");
        pc2.mostraPCConfigs();
        System.out.println("========== Computador 3 ==========");
        pc3.mostraPCConfigs();
    }
}
