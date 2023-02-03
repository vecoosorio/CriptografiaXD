
package util;


public class Encriptar {
    public static String cifrar (String texto){
        String nuevoTexto="";
        int len=texto.length();
        for(int i=0;i<len;i++){
            char c=texto.charAt(i);
            int code=(int)c;
            code+=3;
            char nc=(char)code;
            nuevoTexto+=nc;
            
        }
        return nuevoTexto;
    }
    public static String descifrar (String texto){
        String nuevoTexto="";
        int len=texto.length();
        for(int i=0;i<len;i++){
            char c=texto.charAt(i);
            int code=(int)c;
            code-=3;
            char nc=(char)code;
            nuevoTexto+=nc;
            
        }
        return nuevoTexto;
    }
    public static void main(String[] args) {
       String texto="mama";
       System.out.println(Encriptar.cifrar(texto));
       System.out.println(Encriptar.descifrar(cifrar(texto)));
    }
}
