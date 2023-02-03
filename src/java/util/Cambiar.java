
package util;

public class Cambiar {
        public static String cifrar (String texto){
        String textoCambiado="";
        
        for(int i=texto.length()-1;i>=0;i--){
            
            textoCambiado+=texto.charAt(i);
            
        }
        return textoCambiado;
    }
    public static String descifrar (String texto){
        String textoCambiado="";
        
        for(int i=texto.length()-1;i>=0;i--){
            
            textoCambiado+=texto.charAt(i);
            
        }
        return textoCambiado;
    }
    public static void main(String[] args) {
       String texto="veco";
       System.out.println(Cambiar.cifrar(texto));
       System.out.println(Cambiar.descifrar(cifrar(texto)));
    }
    
}
