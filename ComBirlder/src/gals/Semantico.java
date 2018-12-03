package gals;

import java.util.ArrayList;
import model.TabelaSimbolo;

public class Semantico implements Constants
{
    
    private ArrayList<String> script = storage.Storage.getInstance().script;
    private ArrayList<String> pilha = storage.Storage.getInstance().pilha;
    private ArrayList<String> listaid = storage.Storage.getInstance().listaid;
    private ArrayList<TabelaSimbolo> ts = storage.Storage.getInstance().ts;
    private String tipovar = storage.Storage.getInstance().tipovar;
    private String operador = storage.Storage.getInstance().operador;
    
    public void executeAction(int action, Token token)	throws SemanticError
    {
        System.out.println("Ação #"+action+", Token: "+token);
        switch(action) {
            case 1:
                this.action1();
                break;
            case 2:
                this.action2();
                break;
            case 3:
                this.action3();
                break;
            case 4:
                this.action4();
                break;
            case 6:
                this.action6(token);
                break;
            case 7: 
                this.action7();
                break;
            case 8:
                this.action8();
                break;
            case 9:
                this.action9(token);
                break;
            case 10:
                this.action10();
                break;
            case 11:
                this.action11();
                break;
            case 12:
                this.action12();
                break;
            case 13:
                this.action13();
                break;
            case 14:
                this.action14();
                break;
            case 15: 
                this.action15();
                break;
            case 16:
                this.action16();
                break;
            case 17:
                
                break;
            case 20:
                this.action20(token);
                break;
            case 101:
                this.action101(token);
                break;
            case 102:
                this.action102(token);
                break;
            case 103:
                this.action103();
                break;
        }
    }	
    
    private void action1() throws SemanticError {
        String tipo1 = this.pop();
        String tipo2 = this.pop();
        if (tipo1 != "float64" || tipo2 != "float64") {
            throw new SemanticError("Tipos incompativeis");
        }
        this.script.add("add");
        this.pilha.add("float64");
    }
    
    private void action2() throws SemanticError {
        String tipo1 = this.pop();
        String tipo2 = this.pop();
        if (tipo1 != "float64" || tipo2 != "float64") {
            throw new SemanticError("Tipos incompativeis");
        }
        this.script.add("sub");
        this.pilha.add("float64");
    }
    
    private void action3() throws SemanticError {
        String tipo1 = this.pop();
        String tipo2 = this.pop();
        if (tipo1 != "float64" || tipo2 != "float64") {
            throw new SemanticError("Tipos incompativeis");
        }
        this.script.add("mul");
        this.pilha.add("float64");
    }
    
    private void action4() throws SemanticError {
        String tipo1 = this.pop();
        String tipo2 = this.pop();
        if (tipo1 != "float64" || tipo2 != "float64") {
            throw new SemanticError("Tipos incompativeis");
        }
        this.script.add("div");
        this.pilha.add("float64");
    }
    
    private void action6(Token token) {
        this.script.add("ldc.r8 " + token.getLexeme());
        this.pilha.add("float64");
    }
    
    private void action7() throws SemanticError {
        String tipo1 = this.pop();
        String tipo2 = this.pop();
        if (tipo1 != "float64" || tipo2 != "float64") {
            throw new SemanticError("Tipos incompativeis");
        }
        this.pilha.add("float64");
    }
    
    private void action8() {
        String tipo1 = this.pop();
        if (tipo1 != "float64") {
            
        }
        this.script.add("ldc.r8 -1");
        this.script.add("mul");
        this.pilha.add("float64");
    }
    
    private void action9(Token operador) {
        this.operador += operador.getLexeme();
    }
    
    private void action10() throws SemanticError {
        String tipo1 = this.pop();
        String tipo2 = this.pop();
        if (tipo1 != "float64") {
            throw new SemanticError("Tipos incompativeis");
        }
        this.pilha.add("bool");
        switch(this.operador) {
            case ">":
                this.script.add("ctg");
                break;
            case "<":
                this.script.add("clt");
                break;
            case "=":
                this.script.add("ceq");
                break;
        }
        this.operador = "";
    }
    
    private void action11() {
        this.pilha.add("bool");
        this.script.add("ldc.i4.1");
    }
    
    private void action12() {
        this.pilha.add("bool");
        this.script.add("ldc.i4.0");
    }
    
    private void action13() {
        String tipo1 = this.pop();
        if (tipo1 != "bool") {
            
        }
        this.pilha.add("bool");
        this.script.add("ldc.i4.1");
        this.script.add("xor");
    }
    
    private void action14() {
        String tipo = this.pop();
        if (tipo == "int64") {
            this.script.add("conv.i8");
        }
        this.script.add("call void [mscorlib]System.Console::Write(" + tipo +")");
    }
    
    private void action15() {
        this.script.add(".assembly extern mscorlib {}");
        this.script.add(".assembly _codigo_aberto{}");
        this.script.add(".module _codigo_onjeto.exe");
        this.script.add(".class public _UNICA{");
        this.script.add(".method static public void _PRINCIPAL() {");
        this.script.add(".entrypoint");
    }
    
    private void action16() {
        this.script.add("ret");
        this.script.add("}");
        this.script.add("}");
    }
    
    private void action20(Token token) {
        this.pilha.add("string");
        this.script.add("ldstr \"" + token.getLexeme() + "\"" );
    }
    
    private void action101(Token token) {
        switch(token.getLexeme()) {
            case "number":
                this.tipovar = ("float64");
                break;
            case "literal":
                this.tipovar = ("string");
                break;
            case "logical":
                this.tipovar = ("bool");
                break;
        }
    }
    
    private void action102(Token token) {
        this.listaid.add(token.getLexeme());
    }
    
    private void action103() throws SemanticError {
        for (String id : this.listaid) {
            if (this.ts.contains(id)) {
                throw new SemanticError("Erro semantico");
            }
            TabelaSimbolo tbs = new TabelaSimbolo();
            tbs.setId(id);
            tbs.setTipovar(this.tipovar);
            this.ts.add(tbs);
            this.script.add(".locals(" + this.tipovar + ", " + id + ")");
        }
    }
    
    private void action104() throws SemanticError {
        for (String id : this.listaid) {
            if (!this.ts.contains(id)) {
                throw new SemanticError("Erro semantico");
            }
            String tipoId = this.getTipovar(id);
        }
    }
    
    private String getTipovar(String id) {
        for (TabelaSimbolo tbs : this.ts) {
            if (tbs.getId() == id) {
                return tbs.getTipovar();
            }
        }
        return null;
    }
    
    private String pop() {
        String valor = this.pilha.get(this.pilha.size() - 1);
        this.pilha.remove(this.pilha.size() - 1);
        return valor;
    }
}
