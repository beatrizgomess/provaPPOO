package telephone;

import java.util.List;

/**
 * Prints things out to the screen, when needed
 * Printing to the screen:
 *  System.out.("hello");
 */
public class Screen {

    public Screen(PhoneModel model) {
        primeiroObservador(model);
        segundoObservador(model);
        
    }
    private void primeiroObservador(PhoneModel phone){
        phone.adicionarEscutador(acao -> {
            int valor = (Integer) acao.getOldValue();
            System.out.println(valor);
        });
    }
    
    private void segundoObservador(PhoneModel phone){
        //criando uma constante
        final int percorrerLista = phone.getTamanhoListaNum() - 1;


        phone.adicionarEscutador(acao->{
            List<Integer> numerosDigitados = (List<Integer>) acao.getNewValue();

            if(numerosDigitados.size() > percorrerLista){
                String formatar = "";
                
               for(int i = 0; i < numerosDigitados.size(); i++){
                   formatar += String.valueOf(i);
                   
               }
               
                System.out.println("Ligando para: " + formatar + "...");
            }
            
        });
    }
}
