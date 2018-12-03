package gals;

import java.util.ArrayList;
import model.TabelaSimbolo;

public class Semantico implements Constants
{
    
    private ArrayList<String> script = storage.Storage.getInstance().script;
    private ArrayList<String> pilha = storage.Storage.getInstance().pilha;
    private ArrayList<String> listaid = storage.Storage.getInstance().listaid;
    private ArrayList<TabelaSimbolo> ts = storage.Storage.getInstance().ts;
    private ArrayList<Integer> index = storage.Storage.getInstance().index;
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
                this.action17();
                break;
            case 18:
                this.action18();
                break;
            case 19:
                this.action19(token);
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
            case 104:
                this.action104();
                break;
            case 105:
                this.action105(token);
                break;
            case 106:
                this.action106();
                break;
            case 107:
                this.action107();
                break;
            case 108:
                this.action108();
                break;
            case 109:
                this.action109();
                break;
            case 110:
                this.action110();
                break;
            case 111:
                this.action111();
                break;
            case 112:
                this.action112();
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
        this.script.add(".assembly _codigo_objeto{}");
        this.script.add(".module _codigo_objeto.exe");
        this.script.add(".class public _UNICA{");
        this.script.add(".method static public void _PRINCIPAL() {");
        this.script.add(".entrypoint");
    }
    
    private void action16() {
        this.script.add("ret");
        this.script.add("}");
        this.script.add("}");
    }
    
    private void action17() throws SemanticError {
        String tipo1 = this.pop();
        String tipo2 = this.pop();
        if (tipo1 != "bool" || tipo2 != "bool") {
            throw new SemanticError("Tipos incompativeis");
        }
        this.script.add("and");
        this.pilha.add("bool");
    }
    
    private void action18() throws SemanticError {
        String tipo1 = this.pop();
        String tipo2 = this.pop();
        if (tipo1 != "bool" || tipo2 != "bool") {
            throw new SemanticError("Tipos incompativeis");
        }
        this.script.add("or");
        this.pilha.add("bool");
    }
    
    private void action19(Token token) {
        this.pilha.add("string");
        switch (token.getLexeme()) {
            case "'\\s'":
                this.script.add("ldstr \" \"");
                break;
            case "\\t":
                this.script.add("ldstr \"\\t\"");
                break;
            case "\\n":
                this.script.add("ldstr \"\\n\"");
                break;
        }
    }
    
    private void action20(Token token) {
        this.pilha.add("string");
        this.script.add("ldstr " + token.getLexeme() );
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
            for (TabelaSimbolo tbs : this.ts) {
                if (tbs.getId() == id) {
                    throw new SemanticError("Tipo incompatível em operação lógica unária");
                }
            }
            TabelaSimbolo tbs = new TabelaSimbolo();
            tbs.setId(id);
            tbs.setTipovar(this.tipovar);
            this.ts.add(tbs);
            this.script.add(".locals(" + this.tipovar + ", " + id + ")");
        }
        this.listaid.clear();
    }
    
    private void action104() throws SemanticError {
        boolean isExistTs = false;
        for (String id : this.listaid) {
            for (TabelaSimbolo tbs : this.ts) {
                if (tbs.getId().equalsIgnoreCase(id)) {
                    isExistTs = true;
                }
            }
            if (!isExistTs) {
                throw new SemanticError("Tipo incompatível em operação lógica binária");
            }
            String tipoId = this.getTipovar(id);
            String classe = tipoId;
            switch (tipoId) {
                case "int64": 
                    classe = "Int64";
                    break;
                case "float64": 
                    classe = "Double";
                    break;
                case "bool":
                    classe = "Boolean";
                    break;
            }
            this.script.add("call string [mscorlib]System.Console::ReadLine()");
            if (tipoId != "string") {
                this.script.add("call " + tipoId +
                        " [mscorlib]System." + classe + "::Parse(string)");
            }
            this.script.add("stloc " + id);
        }
    }
    
    private void action105(Token token) throws SemanticError {
        String id = null;
        for (TabelaSimbolo tbs : this.ts) {
            if (tbs.getId().equalsIgnoreCase(token.getLexeme())) {
                id = token.getLexeme();
            }
        }
        if (id == null) {
            throw new SemanticError("identificador não declarado");
        }
        String tipoid = this.getTipovar(id);
        this.pilha.add(tipoid);
        this.script.add("ldloc " + id);
        if (tipoid == "int64") {
            this.script.add("conv.r8");
        }
    }
    
    private void action106() throws SemanticError {
        String id = this.listaid.remove(this.listaid.size() - 1);
        String tsId = null;
        for (TabelaSimbolo tbs : this.ts) {
            if (tbs.getId().equalsIgnoreCase(id)) {
                tsId = id;
            }
        }
        if (tsId == null) {
            throw new SemanticError("identificador não declarado");
        }
        String tipoid = this.getTipovar(id);
        String tipoexp = this.pop();
        if (tipoexp != tipoid) {
            throw new SemanticError("tipo incompatível em comando de atribuição");
        }
        if (tipoid == "int64") {
            this.script.add("conv.r8");
        }
        this.script.add("ldloc " + id);
    }
    
    private void action107() {
        this.index.add(this.index.size() + 1);
        this.script.add("brfalse label" + this.index.get(this.index.size() - 1));
    }
    
    private void action108() {
        this.script.add("label" + this.index.get(this.index.size() - 1) + ":");
    }
    
    private void action109() {
        this.index.add(this.index.size() + 1);
        this.script.add("br label" + this.index.get(this.index.size() - 1));
        this.script.add("label" + this.index.get(this.index.size() - 2) + ":");
    }
    
    private void action110() {
        this.index.add(this.index.size() + 1);
        this.script.add("label" + this.index.get(this.index.size() - 1));
    }
    
    private void action111() {
        this.index.add(this.index.size() + 1);
        this.script.add("brtrue label" + this.index.get(this.index.size() - 1) + ":");
    }
    
    private void action112() {
        this.script.add("br label" + this.index.get(this.index.size() - 2));
        this.script.add("label" + this.index.get(this.index.size() - 1) + ":");
    }
    
    private String getTipovar(String id) {
        for (TabelaSimbolo tbs : this.ts) {
            if (tbs.getId().equalsIgnoreCase(id)) {
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
