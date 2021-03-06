package t1;

import java.util.ArrayList;
import java.util.List;

public class TabelaDeSimbolos {
    private String escopo;
    private List<EntradaTabelaDeSimbolos> simbolos;

    public TabelaDeSimbolos(String escopo) {
        simbolos = new ArrayList<>();
        this.escopo = escopo;
    }

    public void adicionarSimbolo(String nome, String tipo, LAEnums.TipoDeDado simbolo) {
        simbolos.add(new EntradaTabelaDeSimbolos(nome,tipo, simbolo));
    }

    public void adicionarSimbolos(List<String> nomes, String tipo, LAEnums.TipoDeDado simbolo) {
        for(String s:nomes) {
            simbolos.add(new EntradaTabelaDeSimbolos(s, tipo, simbolo));
        }
    }

    public boolean existeSimbolo(String nome) {
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            if(etds.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public String getNome() {
      return escopo;
    }

    @Override
    public String toString() {
        String ret = "Escopo: "+escopo;
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            ret += "\n   "+etds;
        }
        return ret;
    }

    public String getTipoSimbolo(String nome){
        for(EntradaTabelaDeSimbolos etds : simbolos) {
            if(etds.getNome().equals(nome)) return etds.getTipo();
        }
        return null;
    }

    public LAEnums.TipoDeDado getTipoDeDado(String nome) {
        for(EntradaTabelaDeSimbolos etds : simbolos) {
            if(etds.getNome().equals(nome)) return etds.getTipoDeDado();
        }
        return null;
    }
}
