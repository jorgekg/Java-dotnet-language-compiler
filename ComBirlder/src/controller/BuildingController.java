package controller;

import gals.Token;
import gals.Lexico;
import gals.LexicalError;
import gals.ScannerConstants;



public class BuildingController {
    
    private String error;
    private String log;

    public BuildingController() {
        log = "";
    }
    
    public boolean lexama(String code) {
        Lexico lexico = new Lexico(code);
        Token tken = null;
        try {
            while ((tken = lexico.nextToken()) != null) {
                if (tken.getId() == 2) {
                    throw new LexicalError(ScannerConstants.SCANNER_ERROR[1], tken.getPosition());
                }
                log += tken.getLexeme() + '\n';
            }
        } catch (LexicalError e) {
            ValidationController scannerController = new ValidationController();
            scannerController.proccess(code, e.getPosition());
            error = "Erro na linha: " + scannerController.getLine() 
                    + " - " + scannerController.getLexema() + " " + e.getLocalizedMessage();
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
