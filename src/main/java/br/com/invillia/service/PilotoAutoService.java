package br.com.invillia.service;

import br.com.invillia.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public static final int QTD_NECESSARIA_PARA_UM_SALTO_EM_CRISTAL = 98;
    public static final int QTD_NECESSARIA_PARA_UM_SALTO_EM_COMBUSTIVEL = 158;

    /**
     * Colocar o máximo de combustível possível
     *
     * - Deve levar em consideração as seguintes informações:
     * -> Peso da tripulação, cada tripulante pesando 80kg
     * -> São 7 tripulantes
     *
     */
    public Double vericficarPesoMaximoCombustivel(final int pesoTripulacao, final int pesoCombustivel, final TipoCombustivel tipoCombustivel) {

        Integer pesoTotalTripulacao = pesoTripulacao * 7;
        Double pesoTotalCombustivel = pesoCombustivel * tipoCombustivel.getPeso();

        return pesoTotalTripulacao + pesoTotalCombustivel;
    }

    /**
     * Verifica a quantidade de combustível que há no motor e qual a sua autonomia
     *
     * - Deve levar em consideração as seguintes informações:
     * -> Para efetuar 1 salto quântico é necessário 98 Litros em cristal liquido
     * -> Para efetuar 1 salto quântico é necessário 158 Litros em combustível de foguete
     * @return Integer quantidade de saltos que o motor conseguirá fazer com a quantidade de combustível atual
     */
    public Integer verificarCombustivel(final MotorQuantico motorQuantico) {

        int autonomia = 0;
        List<Combustivel> combustiveis = motorQuantico.getCombustiveisDisponiveis();

        for(Combustivel combustivel : combustiveis){
            TipoCombustivel tipoCombustivel = combustivel.getTipoCombustivel();
            if(tipoCombustivel == TipoCombustivel.CRISTAL_DE_ENERGIA_LIQUIDO){
                autonomia += combustivel.getQuantidadeEmLitros() / QTD_NECESSARIA_PARA_UM_SALTO_EM_CRISTAL;
            } else if(tipoCombustivel == TipoCombustivel.COMBUSTIVEL_FOGUETE){
                autonomia += combustivel.getQuantidadeEmLitros() / QTD_NECESSARIA_PARA_UM_SALTO_EM_COMBUSTIVEL;
            }
        }

        motorQuantico.setAutonomia(autonomia);

        return autonomia;
    }

    /**
     *  Calcula a quantidade de combustivel que será necessário para viajar ao destino
     *
     * @return true se houver combustivel o suficiente para efetuar a viagem
     */
    public Boolean calcularSeExisteCombustivelNecessario(final Combustivel combustivel, final Rota destino) {

        final MotorQuantico motorQuantico = new MotorQuantico();

        motorQuantico.setCombustiveisDisponiveis(Collections.singletonList(combustivel));
        motorQuantico.setInformacaoDoMotor(null);
        motorQuantico.setQuantidadeSaltosQuanticosTotal(100L);

        final Integer autonomia = verificarCombustivel(motorQuantico);

        return destino.getDestinos().size() < autonomia;
    }

    /**
     * Verifica se há problemas no motor e se é possivel corrigi-los
     *
     * @return String retorna o codigo do erro do motor
     */
    public String verificarProblemasNoMotor(final MotorQuantico motorQuantico) {

        String erros = "";

        for (String erro : motorQuantico.getInformacaoDoMotor()) {
            if (erro.equals("SEM NOVIDADES")) {
                erros += 200;
            } else {
                erros += erro.split("'")[1] + ", ";
            }
        }
        if(erros.contains(",")){
            erros = erros.substring(0, erros.length() - 2);
        }

        return erros;
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
     * @param rota com os destinos que serão necessários para efetuar a rota com sucesso
     * @return retorna os destinos que foi ordenada para poupar combustivel
     */
    public List<String> calcularMenorDistancia(final Rota rota) {

        List<String> rotas = new ArrayList<>();

        if(Objects.isNull(rota.getPontoDeOrigem())){
            rotas = rota.getDestinos().stream().sorted().collect(Collectors.toList());
        } else {
            List<String> origens = new ArrayList<>();
            List<String> demais = new ArrayList<>();
            String letraOrigem = rota.getPontoDeOrigem().substring(0, 1);
            for(String caminho : rota.getDestinos()){
                if(caminho.contains(letraOrigem)){
                    origens.add(caminho);
                }else{
                    demais.add(caminho);
                }
            }
            origens = origens.stream().sorted().collect(Collectors.toList());
            demais = demais.stream().sorted().collect(Collectors.toList());
            rotas.addAll(origens);
            rotas.addAll(demais);
        }

        return rotas;
    }

    /**
     * Uma piloto pode ligar o piloto automatico se e somente se:
     *  - For um piloto com patente de capitão ou de navegador.
     *  - Só poderá ligar se houver combustivel para o destino desejado.
     *  - Não haver problemas no motor
     *
     * @return true se a o piloto automatico for ligado com sucesso
     * @exception Exception é retornada que caso não seja possivel ligar o piloto automatico
     */
    public Boolean ligarPilotoAutomatico(final Piloto piloto, final Nave nave, final Rota rota) throws Exception{

        Boolean ret = true;

        if(piloto.getPatente() != Patente.CAPITAO && piloto.getPatente() != Patente.NAVEGADOR){
            ret = false;
        }

        String informacoes = verificarProblemasNoMotor(nave.getMotorQuantico());
        if(informacoes.length() > 0 && informacoes.split(",").length > 0){
            ret = false;
        }

        Integer saltos = verificarCombustivel(nave.getMotorQuantico());
        if(saltos < rota.getDestinos().size()){
            ret = false;
        }

        if(!ret){
            throw new Exception();
        }else{
            PilotoAuto.getInstancia().setLigar(true);
        }

        return true;
    }

}
