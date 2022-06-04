package websearch;

import java.io.File;

/**
 * Watches the search queries
 */
public class Snooper {

    
    final int caracterLength = 35; // tamanho de caracteres

    public int getCaracterLength() {
        return caracterLength;
    }

    public Snooper(WebSearchModel model) {

        // PRIMEIRO OBSERVADOR E CONDIÇÃO DE FILTRO


        //Implementação da primeira condição do primeiro Observer
        model.addQueryObserver(new WebSearchModel.QueryObserver() {
            @Override
            public void onQuery(String query) {
                System.out.println("[Gallon Found]: " + query);
            }
        },
            //Implementação da segunda condição do primeiro Observer
            //classe anônima, implementando a interface Filtro
            new WebSearchModel.Filtro() {
            @Override
            public boolean notificacaoEnviada(String info) {
                if(info.contains("gallon")){
                    return true;
                }
                return false;
            }

        });


        // SEGUNDO OBSERVADOR E CONDIÇÃO DE FILTRO

        //Implementação da primeira condição do segundo Observer
        model.addQueryObserver(new WebSearchModel.QueryObserver() {
            @Override
            public void onQuery(String query) {
                System.out.println("[Long Query..]: " + query);
            }
        },
            //Implementação da segunda condição do segundo Observer
            new WebSearchModel.Filtro() {
            @Override
            public boolean notificacaoEnviada(String info) {
                if(info.length() > getCaracterLength()){
                    return true;
                }
                return false;
            }


        });
    }  }
