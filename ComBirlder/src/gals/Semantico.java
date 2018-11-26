package gals;

import java.util.ArrayList;

public class Semantico implements Constants
{
    
    private ArrayList<String> script = storage.Storage.getInstance().script;
    private ArrayList<String> pilha = storage.Storage.getInstance().pilha;
    
    public void executeAction(int action, Token token)	throws SemanticError
    {
        System.out.println("Ação #"+action+", Token: "+token);
        switch(action) {
            case 1:
                this.action1();;
                break;
            case 6:
                this.action6(token);
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
    
    private void action6(Token token) {
        this.script.add("ldc.r8 " + token.getLexeme());
        this.pilha.add("float64");
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
    
    private String pop() {
        String valor = this.pilha.get(this.pilha.size() - 1);
        this.pilha.remove(this.pilha.size() - 1);
        return valor;
    }
}
