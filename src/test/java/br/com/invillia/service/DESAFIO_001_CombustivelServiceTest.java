package br.com.invillia.service;

import br.com.invillia.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;

public class DESAFIO_001_CombustivelServiceTest {

    private PilotoAutoService pilotoAutoService;

    @Before
    public void setUp() {
        pilotoAutoService = new PilotoAutoService();
    }

    @Test
    public void calibragemDoPesoDaTripulacaoComCombustivel() {
        final Nave nossaNave = new Nave();

        final Tripulacao tripulacao = new Tripulacao();
        tripulacao.setPeso(80);

        final Combustivel combustivel = new Combustivel();
        combustivel.setQuantidadeEmLitros(10000);
        combustivel.setTipoCombustivel(TipoCombustivel.CRISTAL_DE_ENERGIA_LIQUIDO);

        final Double maximoDeCombustivel = pilotoAutoService.vericficarPesoMaximoCombustivel(tripulacao.getPeso(),
                combustivel.getQuantidadeEmLitros(), combustivel.getTipoCombustivel());

        Assert.assertTrue(nossaNave.PESO_MAXIMO_EM_KG == maximoDeCombustivel);
    }

    @Test
    public void verificaAutonomiaCombustivel() {
        final MotorQuantico motorQuantico = new MotorQuantico();

        final Combustivel combustivel = new Combustivel();
        combustivel.setQuantidadeEmLitros(4500);
        combustivel.setTamanhoMaximoDoTanqueDeCombustivel(5000);
        combustivel.setTipoCombustivel(TipoCombustivel.CRISTAL_DE_ENERGIA_LIQUIDO);

        motorQuantico.setCombustiveisDisponiveis(Collections.singletonList(combustivel));
        motorQuantico.setInformacaoDoMotor(null);
        motorQuantico.setQuantidadeSaltosQuanticosTotal(100L);

        final Integer autonomia = pilotoAutoService.verificarCombustivel(motorQuantico);

        Assert.assertThat(autonomia, equalTo(45));
    }

    @Test
    public void verificaAutonomiaCombustivelEArmazenarValorDaAutonomiaNoMotor() {
        final MotorQuantico motorQuantico = new MotorQuantico();

        final Combustivel combustivel = new Combustivel();
        combustivel.setQuantidadeEmLitros(450);
        combustivel.setTamanhoMaximoDoTanqueDeCombustivel(5000);
        combustivel.setTipoCombustivel(TipoCombustivel.CRISTAL_DE_ENERGIA_LIQUIDO);

        motorQuantico.setCombustiveisDisponiveis(Collections.singletonList(combustivel));
        motorQuantico.setQuantidadeSaltosQuanticosTotal(100L);

        pilotoAutoService.verificarCombustivel(motorQuantico);

        Assert.assertThat(motorQuantico.getAutonomia(), equalTo(4));
    }

    @Test
    public void verificarAutonomiaDeVariosCombustiveis() {
        final MotorQuantico motorQuantico = new MotorQuantico();

        final Combustivel combustivel1 = new Combustivel();
        combustivel1.setQuantidadeEmLitros(4500);
        combustivel1.setTamanhoMaximoDoTanqueDeCombustivel(5000);
        combustivel1.setTipoCombustivel(TipoCombustivel.CRISTAL_DE_ENERGIA_LIQUIDO);

        final Combustivel combustivel2 = new Combustivel();
        combustivel2.setQuantidadeEmLitros(500);
        combustivel2.setTamanhoMaximoDoTanqueDeCombustivel(2000);
        combustivel2.setTipoCombustivel(TipoCombustivel.COMBUSTIVEL_FOGUETE);

        motorQuantico.setCombustiveisDisponiveis(Arrays.asList(combustivel1, combustivel2));
        motorQuantico.setInformacaoDoMotor(null);
        motorQuantico.setQuantidadeSaltosQuanticosTotal(100L);

        final Integer autonomia = pilotoAutoService.verificarCombustivel(motorQuantico);

        Assert.assertThat(autonomia, equalTo(48));
        Assert.assertThat(motorQuantico.getAutonomia(), equalTo(48));
    }

}
