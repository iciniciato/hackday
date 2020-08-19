# Desafio hack-day 2020

1. Como contribuir ?
2. Quais tipos de testes ?
3. Baby steps sempre


## Como contribuir ?

É simples, basta criar um teste unitário na **Master** que esteja em **Português** e **o mais descritivo possivel**, para que fique fácil o entendimento para os candidatos. 
Se quiser e achar interessante, pode adicionar um javadoc acima do método a ser implementado, descrevendo as regras de negócio necessárias para que o método atenda seu propósito. 
Feito isso, basta implementar a solução destes testes na branch **solutions** para ter certeza que aquilo que foi requisitado seja factível e condiga com o que se espera dos candidatos.

```JAVA
public void permitirRetiradaDeLivroDeAssociadoQueNaoTemLivrosEmAtraso()

public void retiradaDeLivroDisponivelEmAcervo()
```
Está grande ? feio ? fora da realidade? concordamos, mas é a forma que encontramos para que fique o mais perto possível da realidade dos nossos candidatos.

* Errei !!! E agora, o que eu faço ?
  * Relaxa, a vida é assim mesmo, agora é aprender pra não errar novamente, a ideia é que a gente repasse os testes e soluções alguns dias antes do hack-day, para evitar ao máximo que esse tipo de situação aconteça.

***
## Quais tipos de testes ?

Na verdade não delimitamos um padrão, claro que é bom ter em mente que os candidatos ainda estão na faculdade, então qualquer coisa que cobre algum conhecimento especifico de JAVA, não é recomendado. Portanto conceitos de orientação a objeto, algoritmos e lógica são muito bem vindas. Claro que, pensando em tornar o desafio mais lúdico e dificultar a busca pos algoritmos simples no google, vamos tentar dar uma temática para o desafio. O tema será **uma blibioteca interna para colaboradores**. Portanto qualquer problema que teste os conhecimentos citados e consiga se encaixar nessa temática será muito bem vindo.

## Baby steps sempre
Vamos tentar mantes os testes o mais simples possível, caso tenhamos alguma situação que exija um teste complexo com vários cenários, o ideal é estes cenários sejam quebrados em vários outros testes.

**ERRADO**
```JAVA
@Test
    public void permitirLocacaoDeFuncionariosForaDaInvillia() {
        Pessoa joaquimItBox = new Colaborador.ColaboradorBuilder().nome("Joaquim").empresa(Empresa.IT_BOX).experiencia(8).build();
        Pessoa marcosItBox = new Colaborador.ColaboradorBuilder().nome("Marcos").empresa(Empresa.INVILLIA).experiencia(2).build();
        Assert.assertTrue( gameService.podeAlugar(joaquimItBox));
        Assert.assertTrue( gameService.podeAlugar(marcosItBox));
    }
```
**CORRETO**
```JAVA
@Test
    public void permitirLocacaoDeFuncionariosForaDaInvillia() {
        Pessoa joaquimItBox = new Colaborador.ColaboradorBuilder().nome("Joaquim").empresa(Empresa.IT_BOX).build();

        Assert.assertTrue( gameService.podeAlugar(joaquimItBox));
    }

    @Test
    public void permitirLocacaoDeFuncionariosForaDaInvilliaComMaisDe6DeMesesExp() {
        Pessoa joaoItBox8Meses = new Colaborador.ColaboradorBuilder().nome("Joao").empresa(Empresa.INVILLIA).experiencia(8).build();

        Assert.assertTrue(gameService.podeAlugar(joaoItBox8Meses));
    }
```
### Críticas ? Sugestões ?
Forka aí e ajuda nozes !
