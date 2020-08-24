package br.com.invillia.service;

import br.com.invillia.model.MotorQuantico;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;

public class DESAFIO_002_MotorServiceTest {

    private PilotoAutoService pilotoAutoService;

    @Before
    public void setUp() {
        pilotoAutoService = new PilotoAutoService();
    }

    @Test
    public void verificarProblemaNoMotorERetornaCodigoDoErro() {

        final MotorQuantico motorQuantico = new MotorQuantico();
        motorQuantico.setInformacaoDoMotor(Collections.singletonList("Erro B405Y no Motor Quantico"));

        final String codigo = pilotoAutoService.verificarProblemasNoMotor(motorQuantico);

        Assert.assertThat(codigo, equalTo("B405Y"));
    }

    @Test
    public void verificarProblemaNoMotorSemProblemas() {

        final MotorQuantico motorQuantico = new MotorQuantico();
        motorQuantico.setInformacaoDoMotor(Collections.singletonList("SEM NOVIDADES"));

        final String codigo = pilotoAutoService.verificarProblemasNoMotor(motorQuantico);

        Assert.assertThat(codigo, equalTo("200"));
    }

    @Test
    public void verificarMultiplosProblemaNoMotorERetornaOsCodigosDosErros() {

        final MotorQuantico motorQuantico = new MotorQuantico();
        final String msg1 = "Erro 'B405Y' no Motor Quantico";
        final String msg2 = "Erro 'C405Y' no Motor Quantico";
        final String msg3 = "Erro 'D405' no Motor Quantico";
        motorQuantico.setInformacaoDoMotor(Arrays.asList(msg1, msg2, msg3));

        final String codigo = pilotoAutoService.verificarProblemasNoMotor(motorQuantico);

        Assert.assertThat(codigo, equalTo("D405, C405Y, B405Y"));
    }

}
