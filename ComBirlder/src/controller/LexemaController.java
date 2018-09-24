package controller;

import gals.Token;
import gals.Lexico;
import gals.LexicalError;



public class LexemaController {
    
    private String error;
    private String log;

    public LexemaController() {
        log = "";
    }
    
    public boolean lexama(String code) {
        Lexico lexico = new Lexico(code);
        Token tken = null;
        try {
            while ((tken = lexico.nextToken()) != null) {
                log += tken.getLexeme() + '\n';
            }
        } catch (LexicalError e) {
            ValidationController scannerController = new ValidationController();
            scannerController.proccess(code, e.getPosition() + 2);
            error = "Erro: linha: " + scannerController.getLine() +
                    ", id.: " + " token: " + tken.getLexeme();
            return false;
        }
        return true;
    }

    public String getError() {
        return error;
    }

    public String getLog() {
        return log;
    }
    
}
