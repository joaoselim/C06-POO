# PC Mania

> João Amback Kovacsik Selim
###### Eng.Software, 631

## Uso de IA no projeto

Foi ultilizada para compreender a comunicação entre classes do usando o setterem um vetor. Para isso enviei as minhas classes existentes naquele momento.

segue o prompt:

```
eu quero add algumas informações no Hardware, que seriam:
Pentium Core i3 (2200 Mhz)
8 Gb de Memória RAM
500Gb de HD
hardware esta como vetor mas como eu uso o setter para colocar apropriadamente em cada posição cada info?
```

Como resposta obtive:
```
public HardwareBasico(String nome, float capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }
```

```
pc1.getHardware()[0] = new HardwareBasico("Pentium Core i3", 2200);

pc1.getHardware()[1] = new HardwareBasico("Memória RAM", 8);

pc1.getHardware()[2] = new HardwareBasico("HD", 500);
```

Foi bem sucedido.
