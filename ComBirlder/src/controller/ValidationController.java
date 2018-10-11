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
        boolean isFinish = false;
        for(int i = 0; i < textChat.length; i++) {
            if (i <= position && textChat[i] == '\n') {
                line++;
            }
            if (validateToken(textChat[i]) && i <= position) {
                lexema = "";
            } else if (!isFinish){
                isFinish = validateToken(textChat[i]);
                lexema += textChat[i];
            }
            if (isFinish) {
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
