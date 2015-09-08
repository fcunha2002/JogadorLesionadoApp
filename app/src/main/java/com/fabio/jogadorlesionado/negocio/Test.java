package com.fabio.jogadorlesionado.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabio on 31/08/2015.
 */
public class Test {

    public List<Pais> montaListaPaises(){
        ArrayList<Pais> paises = new ArrayList<Pais>();

        paises.add(montaArgentina());
        paises.add(montaBrasil());
        paises.add(montaChile());

        return montaListaClubes(paises);
    }

    private List<Pais> montaListaClubes(List<Pais> paises) {
        Clube clube;

        for (Pais pais : paises) {
            if (pais.getId() == 2) {
                clube = new Clube();
                clube.setId(1);
                clube.setNomeCompleto("Sport Club Internacional");
                clube.setNomeReduzido("Internacional");
                clube.setEscudo("internacional");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(2);
                clube.setNomeCompleto("Gremio Foot-Ball Porto Alegrense");
                clube.setNomeReduzido("Gremio");
                clube.setEscudo("gremio");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(3);
                clube.setNomeCompleto("Club de Regatas Vasco da Gama");
                clube.setNomeReduzido("Vasco");
                clube.setEscudo("vasco");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(4);
                clube.setNomeCompleto("Sport Club Corinthians Paulista");
                clube.setNomeReduzido("Corinthians");
                clube.setEscudo("corinthians");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(5);
                clube.setNomeCompleto("Fluminense Football Club");
                clube.setNomeReduzido("Fluminense");
                clube.setEscudo("fluminense");
                clube.setPais(pais);
                pais.getClubes().add(clube);
            } else if (pais.getId() == 1) {
                clube = new Clube();
                clube.setId(6);
                clube.setNomeCompleto("Club Atletico Boca Juniors");
                clube.setNomeReduzido("Boca Juniors");
                clube.setEscudo("boca");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(7);
                clube.setNomeCompleto("Club Atletico Belgrano");
                clube.setNomeReduzido("Belgrano");
                clube.setEscudo("belgrano");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(8);
                clube.setNomeCompleto("Club Atletico Rosario Central");
                clube.setNomeReduzido("Rosario Central");
                clube.setEscudo("rosario");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(9);
                clube.setNomeCompleto("Club Atletico San Lorenzo de Almagro");
                clube.setNomeReduzido("San Lorenzo");
                clube.setEscudo("sanlorenzo");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(10);
                clube.setNomeCompleto("Club Atletico River Plate");
                clube.setNomeReduzido("River Plate");
                clube.setEscudo("riverplate");
                clube.setPais(pais);
                pais.getClubes().add(clube);
            } else if (pais.getId() == 3) {
                clube = new Clube();
                clube.setId(11);
                clube.setNomeCompleto("Club Social y Deportivo Colo-Colo");
                clube.setNomeReduzido("Colo Colo");
                clube.setEscudo("colocolo");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(12);
                clube.setNomeCompleto("Club Deportivo Universidad Catolica");
                clube.setNomeReduzido("Universidad Catolica");
                clube.setEscudo("unicatolica");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(13);
                clube.setNomeCompleto("Club Universidad de Chile");
                clube.setNomeReduzido("Universidad de Chile");
                clube.setEscudo("unichile");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(14);
                clube.setNomeCompleto("Club Deportivo Huachipato");
                clube.setNomeReduzido("Huachipato");
                clube.setEscudo("huachipato");
                clube.setPais(pais);
                pais.getClubes().add(clube);
            }
        }

        return montaListaJogadores(paises);
    }

    private List<Pais> montaListaJogadores(List<Pais> paises) {
        Jogador jogador;
        Contrato contrato;


        for (Pais pais : paises) {
            for (Clube clube : pais.getClubes()){
                if (clube.getId() == 1) { //Internacional
                    jogador = new Jogador();
                    jogador.setId(1);
                    jogador.setNomeCompleto("Andres Nicolas D'Alessandro");
                    try {
                        jogador.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("15/04/1981"));
                    } catch (ParseException e) {
                        jogador.setDataNascimento(null);
                        e.printStackTrace();
                    }
                    jogador.setLesaoAtual(montaLesaoTorcao(jogador));
                    jogador.setNomeGuerra("D'Alessandro");
                    jogador.setFoto("dale");
                    jogador.setPosicao(Posicao.MEIO_CAMPO);
                    jogador.setPais(montaArgentina());
                    jogador.getHistoricoLesoes().add(montaLesaoDistensao(jogador));
                    jogador.getHistoricoLesoes().add(montaLesaoLigamento(jogador));
                    jogador.getHistoricoLesoes().add(montaLesaoTorcao(jogador));
                    clube.getLesionados().add(jogador);

                    jogador = new Jogador();
                    jogador.setId(2);
                    jogador.setNomeCompleto("Eduardo Colcenti Antunes");
                    try {
                        jogador.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("24/02/1992"));
                    } catch (ParseException e) {
                        jogador.setDataNascimento(null);
                        e.printStackTrace();
                    }
                    jogador.setLesaoAtual(montaLesaoDistensao(jogador));
                    jogador.setNomeGuerra("Eduardo Sasha");
                    jogador.setFoto("sasha");
                    jogador.setPosicao(Posicao.MEIO_CAMPO);
                    jogador.setPais(montaBrasil());
                    jogador.getHistoricoLesoes().add(montaLesaoDistensao(jogador));
                    jogador.getHistoricoLesoes().add(montaLesaoLigamento(jogador));
                    jogador.getHistoricoLesoes().add(montaLesaoTorcao(jogador));
                    jogador.getHistoricoLesoes().add(montaLesaoDistensao(jogador));
                    jogador.getHistoricoLesoes().add(montaLesaoLigamento(jogador));
                    jogador.getHistoricoLesoes().add(montaLesaoTorcao(jogador));
                    clube.getLesionados().add(jogador);

                    jogador = new Jogador();
                    jogador.setId(3);
                    jogador.setNomeCompleto("Rever Humberto Alves Araujo");
                    try {
                        jogador.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("04/01/1985"));
                    } catch (ParseException e) {
                        jogador.setDataNascimento(null);
                        e.printStackTrace();
                    }
                    jogador.setLesaoAtual(montaLesaoLigamento(jogador));
                    jogador.setNomeGuerra("Rever");
                    jogador.setFoto("rever");
                    jogador.setPosicao(Posicao.DEFENSOR);
                    jogador.setPais(montaBrasil());
                    jogador.getHistoricoLesoes().add(montaLesaoDistensao(jogador));
                    clube.getLesionados().add(jogador);
                } else if (clube.getId() == 2) {//Gremio
                    jogador = new Jogador();
                    jogador.setId(4);
                    jogador.setNomeCompleto("Ramiro Moschen Benetti");
                    try {
                        jogador.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("22/05/1993"));
                    } catch (ParseException e) {
                        jogador.setDataNascimento(null);
                        e.printStackTrace();
                    }
                    jogador.setLesaoAtual(montaLesaoTorcao(jogador));
                    jogador.setNomeGuerra("Ramiro");
                    jogador.setFoto("ramiro");
                    jogador.setPosicao(Posicao.MEIO_CAMPO);
                    jogador.setPais(montaBrasil());
                    jogador.getHistoricoLesoes().add(montaLesaoDistensao(jogador));
                    jogador.getHistoricoLesoes().add(montaLesaoLigamento(jogador));
                    clube.getLesionados().add(jogador);
                } else if (clube.getId() == 3) {//Vasco
                    jogador = new Jogador();
                    jogador.setId(5);
                    jogador.setNomeCompleto("Claudinei Cardoso Felix da Silva");
                    try {
                        jogador.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("06/12/1985"));
                    } catch (ParseException e) {
                        jogador.setDataNascimento(null);
                        e.printStackTrace();
                    }
                    jogador.setLesaoAtual(montaLesaoDistensao(jogador));
                    jogador.setNomeGuerra("Nei");
                    jogador.setFoto("nei");
                    jogador.setPosicao(Posicao.DEFENSOR);
                    jogador.setPais(montaBrasil());
                    jogador.getHistoricoLesoes().add(montaLesaoDistensao(jogador));
                    jogador.getHistoricoLesoes().add(montaLesaoLigamento(jogador));
                    jogador.getHistoricoLesoes().add(montaLesaoTorcao(jogador));
                    clube.getLesionados().add(jogador);
                } else if (clube.getId() == 4) {//Corinthians
                    jogador = new Jogador();
                    jogador.setId(6);
                    jogador.setNomeCompleto("Eduardo Luis Abonizio Souza");
                    try {
                        jogador.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("18/05/1981"));
                    } catch (ParseException e) {
                        jogador.setDataNascimento(null);
                        e.printStackTrace();
                    }
                    jogador.setLesaoAtual(montaLesaoLigamento(jogador));
                    jogador.setNomeGuerra("Edu Dracena");
                    jogador.setFoto("dracena");
                    jogador.setPosicao(Posicao.DEFENSOR);
                    jogador.setPais(montaBrasil());
                    jogador.getHistoricoLesoes().add(montaLesaoDistensao(jogador));
                    jogador.getHistoricoLesoes().add(montaLesaoLigamento(jogador));
                    jogador.getHistoricoLesoes().add(montaLesaoTorcao(jogador));
                    jogador.getHistoricoLesoes().add(montaLesaoLigamento(jogador));
                    jogador.getHistoricoLesoes().add(montaLesaoTorcao(jogador));
                    clube.getLesionados().add(jogador);
                }
            }
        }

        return paises;
    }

    private Pais montaArgentina(){
        Pais pais = new Pais();
        pais.setId(1);
        pais.setNome("Argentina");
        pais.setBandeira("argentina");

        return pais;
    }

    private Pais montaBrasil(){
        Pais pais = new Pais();
        pais.setId(2);
        pais.setNome("Brasil");
        pais.setBandeira("brasil");

        return pais;
    }

    private Pais montaChile(){
        Pais pais = new Pais();
        pais.setId(3);
        pais.setNome("Chile");
        pais.setBandeira("chile");

        return pais;
    }

    private Lesao montaLesaoDistensao(Jogador jogador){
        Lesao lesao = new Lesao();

        lesao.setId(0l);
        lesao.setJogador(jogador);
        try {
            lesao.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2015"));
            lesao.setDataFim(new SimpleDateFormat("dd/MM/yyyy").parse("18/07/2015"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lesao.setTipo("Distensão Muscular");
        lesao.setDescricao("Posterior Coxa Direita");

        return lesao;
    }

    private Lesao montaLesaoLigamento(Jogador jogador){
        Lesao lesao = new Lesao();

        lesao.setId(0l);
        lesao.setJogador(jogador);
        try {
            lesao.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse("05/03/2015"));
            lesao.setDataFim(new SimpleDateFormat("dd/MM/yyyy").parse("31/08/2015"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lesao.setTipo("Lesão no Ligamento");
        lesao.setDescricao("Cruzado Joelho Esquerdo");

        return lesao;
    }

    private Lesao montaLesaoTorcao(Jogador jogador){
        Lesao lesao = new Lesao();

        lesao.setId(0l);
        lesao.setJogador(jogador);
        try {
            lesao.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse("15/07/2015"));
            lesao.setDataFim(new SimpleDateFormat("dd/MM/yyyy").parse("21/07/2015"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lesao.setTipo("Torção");
        lesao.setDescricao("Tornozelo Direito");

        return lesao;
    }


}
