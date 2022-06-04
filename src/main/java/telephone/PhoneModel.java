package telephone;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * Store a phone number, digit-by-digit
 */
public class PhoneModel {
    private List<Integer> digits = new ArrayList<>();
    
    private final PropertyChangeSupport propertyCS = new PropertyChangeSupport(this);
    
    final int tamanhoListaNum; //variável criada para ter acesso
    // ao tamanho da lista, é uma constante;
    
    //construtor
    public PhoneModel(int tamanhoListaNum) {
        this.tamanhoListaNum = tamanhoListaNum;
        this.digits = new ArrayList<>();
    }

    public void addDigit(int newDigit) {
        getDigits().add(newDigit);
        getPropertyCS().firePropertyChange("acao", newDigit, getDigits());
    }

    //gerar métodos get()
    public int getTamanhoListaNum() {
        return tamanhoListaNum;
    }

    public void setDigits(List<Integer> digits) {
        this.digits = digits;
    }

    public List<Integer> getDigits() {
        return digits;
    }

    public PropertyChangeSupport getPropertyCS() {
        return propertyCS;
    }

    public void adicionarEscutador(PropertyChangeListener escutador){
        getPropertyCS().addPropertyChangeListener(escutador);
        getPropertyCS().toString();
    }
    
    
}
