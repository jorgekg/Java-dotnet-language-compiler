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
        log += "linha     classe               lexema \n";
        ValidationController scannerController = new ValidationController();
        try {
            while ((tken = lexico.nextToken()) != null) {
                if (tken.getId() == 2) {
                    throw new LexicalError(ScannerConstants.SCANNER_ERROR[1], tken.getPosition());
                }
                scannerController.proccess(code, tken.getPosition());
                log += "" + scannerController.getLine() + "         " 
                        + getClassLexema(tken.getLexeme()) 
                        + "    " +tken.getLexeme() + "\n";
                scannerController.setLine(1);
            }
        } catch (LexicalError e) {
            scannerController.proccess(code, e.getPosition());
            error = "Erro na linha: " + scannerController.getLine() 
                    + " - " + scannerController.getLexema() + " " + e.getLocalizedMessage();
            return false;
        }
        log += "programa compilado com sucesso \n";
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
        } catch(NumberFormatException e) {}
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
    
}
