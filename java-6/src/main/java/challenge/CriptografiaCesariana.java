package challenge;

import com.sun.org.apache.regexp.internal.CharacterIterator;

public class CriptografiaCesariana implements Criptografia {

    String alp= new String("abcdefghijklmnopqrstuvwxyz");
    @Override
    public String criptografar(String texto) {
        String texto_crip="";
        if(texto.isEmpty()){
            throw new IllegalArgumentException();
        }
        String texto_minusculo=texto.toLowerCase();
        for(int i=0;i<texto_minusculo.length();i++){
            if(alp.contains(Character.toString(texto_minusculo.charAt(i))))
                texto_crip+=(findCh(texto_minusculo.charAt(i),"criptografar"));
            else
                texto_crip+=texto_minusculo.charAt(i);
        }
        return texto_crip;
    }
    private char findCh(char ch,String operacao){
        int position=alp.indexOf(ch);
        int index;
        if(operacao.equals("criptografar")){
             index= position>22 ? position+3-25-1:position+3 ;
        }
        else{
             index= position<3 ? position-3+25+1:position-3 ;
        }
        return alp.charAt(index);
    }

    @Override
    public String descriptografar(String texto) {
        String texto_crip="";
            if(texto.isEmpty()){
                throw new IllegalArgumentException();
            }
        String texto_minusculo=texto.toLowerCase();
        for(int i=0;i<texto_minusculo.length();i++){
            if(alp.contains(Character.toString(texto_minusculo.charAt(i))))
                texto_crip+=(findCh(texto_minusculo.charAt(i),"decriptografar"));
            else
                texto_crip+=texto_minusculo.charAt(i);
        }
        return texto_crip;
    }
}
