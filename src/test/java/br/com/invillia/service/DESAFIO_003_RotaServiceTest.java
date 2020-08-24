package br.com.invillia.service;

import br.com.invillia.model.Combustivel;
import br.com.invillia.model.MotorQuantico;
import br.com.invillia.model.Nave;
import br.com.invillia.model.PilotoAuto;
import br.com.invillia.model.Rota;
import br.com.invillia.model.Patente;
import br.com.invillia.model.Piloto;
import br.com.invillia.model.TipoCombustivel;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class DESAFIO_003_RotaServiceTest {

    private PilotoAutoService pilotoAutoService;

    @Before
    public void setUp() {
        pilotoAutoService = new PilotoAutoService();
    }

    @Test
    public void deveCalcularMenorDistancia() throws Exception {
        final Rota rota = new Rota();
        rota.setDestinos(Arrays.asList("A3", "D5", "F4", "Z4", "D3"));
        rota.setPontoDeOrigem(null);

        Assert.assertThat(pilotoAutoService.calcularMenorDistancia(rota), IsEqual.equalTo(Arrays.asList("A3", "D3", "D5" , "F4", "Z4")));
    }

    @Test
    public void deveCalcularMenorDistanciaAPartirDoPontoDeOrigem() throws Exception {
        final Rota rota = new Rota();
        rota.setDestinos(Arrays.asList("A3", "D5", "F4", "Z4", "D3"));
        rota.setPontoDeOrigem("D2");

        Assert.assertThat(pilotoAutoService.calcularMenorDistancia(rota), IsEqual.equalTo(Arrays.asList("D3", "D5" , "A3", "F4", "Z4")));
    }

    @Test
    public void deveCalcularSeExisteCombustivelNecessarioParaViajar() throws Exception {
        final Rota rota = new Rota();
        rota.setDestinos(Arrays.asList("A3", "D5", "F4", "Z4", "D3"));
        rota.setPontoDeOrigem("D2");

        final Combustivel combustivel = new Combustivel();
        combustivel.setQuantidadeEmLitros(450);
        combustivel.setTipoCombustivel(TipoCombustivel.CRISTAL_DE_ENERGIA_LIQUIDO);

        Assert.assertThat(pilotoAutoService.calcularSeExisteCombustivelNecessario(combustivel, rota),  Is.is(false));
    }

}
