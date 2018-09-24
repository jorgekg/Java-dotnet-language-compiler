package controller;

public class ValidationController {
    
    private int line;
    private String lexema;
    private String identificador;

    public ValidationController() {
        line = 1;
        lexema = "";
    }
    
    public void proccess(String text, int position) {
        char[] textChat = text.toCharArray();
        for(int i = 0; i < textChat.length; i++) {
            if (i <= position && textChat[i] == '\n') {
                line++;
            }
            if (validateToken(textChat[i])) {
                lexema = "";
            } else if (i <= position){
                lexema += textChat[i];
            } else {
                break;
            }
        }
    }
    
    private boolean validateToken(char token) {
        switch (token) {
            case '\n':
                return true;
            case ' ':
                return true;
            case '\t':
                return true;
            default:
                return false;
        }
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
}
