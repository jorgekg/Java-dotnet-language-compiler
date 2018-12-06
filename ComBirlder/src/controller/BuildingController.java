package controller;

import gals.Lexico;
import gals.LexicalError;
import gals.ScannerConstants;
import gals.SemanticError;
import gals.Semantico;
import gals.Sintatico;
import gals.SyntaticError;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import model.Archive;

public class BuildingController {

    private String error;
    private String log;

    public BuildingController() {
        log = "";
    }

    public boolean lexema(String code, Archive archive) throws IOException {
        Lexico lexico = new Lexico();
        Sintatico sintatico = new Sintatico();
        Semantico semantico = new Semantico();
        lexico.setInput(code);
        ValidationController scannerController = new ValidationController();
        try {
            sintatico.parse(lexico, semantico);
        } catch (LexicalError e) {
            scannerController.proccess(code, e.getPosition());
            error = "Erro na linha: " + scannerController.getLine()
                    + " -" + (isShowToken(e.getLocalizedMessage()) ? scannerController.getLexema() : "")
                    + " " + e.getLocalizedMessage();
            return false;
        } catch (SyntaticError e) {
            scannerController.proccess(code, e.getPosition());
            error = "Erro na linha: " + scannerController.getLine()
                    + " - encontrado " + scannerController.getLexema()
                    + " " + e.getLocalizedMessage();
            return false;
        } catch (SemanticError e) {
            storage.Storage.getInstance().clear();
            error = e.getMessage();
            return false;
        }
        log = "programa compilado com sucesso \n";
        File birldFile = new File(archive.getDir() + ".il");
        try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(birldFile))) {
            for(int i = 0; i < storage.Storage.getInstance().script.size(); i++) {
                bufferWriter.write(storage.Storage.getInstance().script.get(i));
                bufferWriter.newLine();
            }
        }
        
        storage.Storage.getInstance().clear();
        return true;
    }

    private String getClassLexema(String lexema) {
        for (String SPECIAL_CASES_KEYS : ScannerConstants.SPECIAL_CASES_KEYS) {
            if (SPECIAL_CASES_KEYS.equals(lexema)) {
                return "palavra reservada";
            }
        }
        for (int i = 0; i < ScannerConstants.SPECIAL_CARACTER.length; i++) {
            if (ScannerConstants.SPECIAL_CARACTER[i].equals(lexema)) {
                return "símbolo especial";
            }
        }
        try {
            Float.parseFloat(lexema);
            return "constante numérica";
        } catch (NumberFormatException e) {
        }
        if (lexema.contains(("\""))) {
            return "constante literal";
        }
        if (lexema.contains("'")) {
            return "constante caractere";
        }
        return "identificador";
    }

    public String getError() {
        return error;
    }

    public String getLog() {
        return log;
    }
    
    public boolean isShowToken(String localizedMessage) {
        return localizedMessage == "símbolo inválido" || localizedMessage == "Palavra reservada inválida";
    }

}
