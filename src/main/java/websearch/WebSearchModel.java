package websearch;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Perform "web search" (from a  file), notify the interested observers of each query.
 */
public class WebSearchModel {
    //variaveis que já estavam presentes no arquivo
    private final File sourceFile;
    private final List<QueryObserver> observers = new ArrayList<>();

    //variável criada
    private final List<Filtro> filtro = new ArrayList<>();

    public interface Filtro {
        boolean notificacaoEnviada(String info);
    }

    public interface QueryObserver {
        void onQuery(String query);
    }

    public WebSearchModel(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    //get reunidos
    public List<Filtro> getFiltro() {
        return filtro;
    }

    public File getSourceFile() {
        return sourceFile;
    }

    public List<QueryObserver> getObservers() {
        return observers;
    }


    public void addQueryObserver(QueryObserver queryObserver, Filtro ft) {
        getObservers().add(queryObserver);
        getFiltro().add(ft);

    }

    //notifica tudo de uma vez a cada linha
    private void notifyAllObservers(String line) {
        for (int i = 0; i < observers.size(); i++) {
            if (getFiltro().get(i).notificacaoEnviada(line)) {
                observers.get(i).onQuery(line);
            }
        }
    }

    public void pretendToSearch() {
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                notifyAllObservers(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
