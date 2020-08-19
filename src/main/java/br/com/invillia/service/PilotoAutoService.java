package br.com.invillia.service;

import br.com.invillia.model.Destino;
import br.com.invillia.model.MotorQuantico;
import br.com.invillia.model.Nave;
import br.com.invillia.model.Piloto;

import java.util.List;

/**
 ;;;;;;;;;;;;;;;;coxxxxxdl;;;;;;;;;;;;;;;;
 ;;;;;;;;;;;;:okK0kxdodxOKKOdc;;;;;;;;;;;;
 ;;;;;;;;;;ckKk:..........'cOXOl;;;;;;;;;;
 ;;;;;;;;;dN0;...          ..lXXk:;;;;;;;;
 ;;;;;;;;oN0'':cc;.    .,cc:,.:NXx;;;;;;;;
 ;;;;;;;;0W:..;llc;.  .;cll;...xNK:;;;;;;;
 ;;;;;;;;KXc...              ..kXXc;;;;;;;
 ;;;;;;;;xXKOl,.          .':d0KKk;;;;;;;;
 ;;;;;;;;;okO0KK0kdollodxOKKK0Okd:;;;;;;;;
 ;;;;;;;:O00KKXXXXKKKKKKKKXXKK000Ol;;;;;;;
 ;;;;ox:dXXXXKKXXXXNNNNXXXXXKKKXKKx;cd;;;;
 ;;;c0KdxKKKKKKKKK0000000KKKKKKKKKk;OKl;;;
 ;;;dKKkxKKKKKKKKKKKKKKKKKKKKKKKKKx:0Kx;;;
 ;;;xKKxdKKKKKKKKKKKKKKKKKKKKKKKKKd;OKk;;;
 ;;;kKKdlKKKKKKKKKKKKKKKKKKKKKKKKKl;OKO;;;
 ;;;xKXo:0KKKKKKKKKKKKKKKKKKKKKKK0:;kKO;;;
 ;;;xKXo;xKKKKKKKKKKKKKKKKKKKKKKKx;;kKO;;;
 ;;;dKKd;c0KKKKKKKKKKKKKKKKKKKKKKc;;OKk;;;
 ;;;lKKd;;xKKKKKKKKKKKKKKKKKKKKKx;;;OKd;;;
 ;;;:0Kx;;:0KKKKKKKKKKKKKKKKKKK0c;;;0Kl;;;
 ;;;;kKk;;;oKKKKKKKKKKKKKKKKKKKd;;;cK0:;;;
 ;;;;lK0;;;;xKKKKKKKKKKKKKKKKKk:;;;oKx;;;;
 ;;;;;kKc;;;:kKKKKKKKKKKKKKKKO:;;;;xKc;;;;
 ;;;;;:x:;;;;:kKKKKKKKKKKKKKO:;;;;;do;;;;;
 ;;;;;;;;;;;;;;dKKKKKKKKKKKk:;;;;;;;;;;;;;
 ;;;;;;;;;;;;;;;cOKKKKKKKOo;;;;;;;;;;;;;;;
 ;;;;;;;;;;;;;;;;;lkO0Oko:;;;;;;;;;;;;;;;;
 **/
public class PilotoAutoService {

    /**
     * Verifica a quantidade de combustível que há no motor e qual a sua autonomia
     *
     * @return Double quantidade de saltos que o motor consiguirá fazer com a quantidade de combustivel atual
     */
    public Double verificarCombustivel(final MotorQuantico nave) {
        return null;
    }

    /**
     *  Calcula a quantidade de combustivel que será necessário para viajar ao destino
     *
     * @return true se houver combustivel o suficiente para efetuar a viagem
     */
    public Boolean calcularCombustivelNecessario(final MotorQuantico nave, final Destino destino) {
        return null;
    }

    /**
     * Verifica se há problemas no motor e se é possivel corrigi-los
     *
     * @return String informando se há ou não problema no motor
     */
    public String verificarProblemasNoMotor(final MotorQuantico motorQuantico) {
        return null;
    }

    /**
     * Deve calcular a menor distancia entre os destinos para priorizar a economia de combustivel
     *
     * - Deve levar em consideração que a galaxia é dividida como uma linear:
     *    a. Onde as galaxias estão em ordem alfabetica de A~Z
     *    b. E há divisões de setores das Galáxias (A~Z) da mais proxima a mais distante todas divididas em 10 partes(Ex: A0~A9)
     *
     *    EX:
     *    Menor                          Maior
     *    A0 ----D4---------------------- Z10
     *
     * @param destinos lista de destinos que serão necessários para efetuar a rota com sucesso
     * @return retorna a rota que foi ordenada para poupar combustivel
     */
    public List<Destino> calcularMenorDistancia(final List<Destino> destinos) {
        return null;
    }

    /**
     * Uma piloto pode ligar o piloto automatico se e somente se:
     *  - For um piloto com patente de capitão ou de navegador.
     *  - Só poderá ligar se houver combustivel para o destino desejado.
     *  - Não haver problemas no motor
     *
     * @return true se a o piloto automatico for ligado com sucesso
     * @exception Exception é retornada que caso não seja possivel ligar o piloto automatico

     OI DENIS

     Não sou guia técnico, não vou compilar
     vai sim
     */
    public Boolean ligarPilotoAutomatico(final Piloto piloto, final Nave nave, final List<Destino> destinos) throws Exception{
        return true;
    }

}
