package br.com.invillia.service;

import br.com.invillia.model.Patente;
import br.com.invillia.model.Piloto;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DESAFIO_003_PilotoServiceTest {

    private PilotoAutoService pilotoAutoService;

    @Before
    public void setUp() {
        pilotoAutoService = new PilotoAutoService();
    }


    @Test
    public void devePermitirLigarPilotoAuto() throws Exception {
        final Piloto piloto = new Piloto();
        piloto.setNome("Piloto Feliz");
        piloto.setEmail("piloto.feliz@invillia.com.br");
        piloto.setId(321L);
        piloto.setPatente(Patente.CAPITAO);

        Assert.assertThat(pilotoAutoService.ligarPilotoAutomatico(piloto, null, null), Is.is(true));
    }

}
