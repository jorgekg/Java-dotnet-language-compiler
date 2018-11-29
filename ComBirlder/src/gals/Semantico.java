package gals;

import java.util.ArrayList;

public class Semantico implements Constants
{
    
    private ArrayList<String> script = storage.Storage.getInstance().script;
    private ArrayList<String> pilha = storage.Storage.getInstance().pilha;
    private ArrayList<String> tipovar = storage.Storage.getInstance().tipovar;
    private ArrayList<String> listaid = storage.Storage.getInstance().listaid;
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
            case 20:
                this.action20(token);
                break;
            case 101:
                
                break;
        }
    }	
    
    private void action1() {
        String tipo1 = this.pop();
        String tipo2 = this.pop();
        if (tipo1 != "float64" || tipo2 != "float64") {
            System.out.println("tipo incompativel ");
        }
        this.script.add("add");
        this.pilha.add("float64");
    }
    
    private void action2() {
        String tipo1 = this.pop();
        String tipo2 = this.pop();
        if (tipo1 != "float64" || tipo2 != "float64") {
            System.out.println("tipo incompativel ");
        }
        this.script.add("sub");
        this.pilha.add("float64");
    }
    
    private void action3() {
        String tipo1 = this.pop();
        String tipo2 = this.pop();
        if (tipo1 != "float64" || tipo2 != "float64") {
            System.out.println("tipo incompativel ");
        }
        this.script.add("mul");
        this.pilha.add("float64");
    }
    
    private void action4() {
        String tipo1 = this.pop();
        String tipo2 = this.pop();
        if (tipo1 != "float64" || tipo2 != "float64") {
            System.out.println("tipo incompativel ");
        }
        this.script.add("div");
        this.pilha.add("float64");
    }
    
    private void action6(Token token) {
        this.script.add("ldc.r8 " + token.getLexeme());
        this.pilha.add("float64");
    }
    
    private void action7() {
        String tipo1 = this.pop();
        String tipo2 = this.pop();
        if (tipo1 != "float64" || tipo2 != "float64") {
            System.out.println("tipo incompativel ");
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
    
    private void action10() {
        String tipo1 = this.pop();
        String tipo2 = this.pop();
        if (tipo1 != "float64") {
            System.out.println("tipo incompativel ");
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
                this.tipovar.add("float64");
                break;
            case "literal":
                this.tipovar.add("string");
                break;
            case "logical":
                this.tipovar.add("bool");
                break;
        }
    }
    
    private void action102(Token token) {
        this.listaid.add(token.getLexeme());
    }
    
    private String pop() {
        String valor = this.pilha.get(this.pilha.size() - 1);
        this.pilha.remove(this.pilha.size() - 1);
        return valor;
    }
}
