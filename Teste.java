import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Teste {
    public static void main(String[] args) {
        String texto = "def abre_navegador(url):";

        String comparacao = "def";
        boolean equals = true;
        int comparacao_length = comparacao.length();
        int ctrl = 0;
        
        String[] temp_text1  = texto.split("");
        ArrayList<String> temp_arrayList1 = new ArrayList<>(Arrays.asList(temp_text1));

        String[] temp_text2 = comparacao.split("");
        ArrayList<String> temp_arrayList2 = new ArrayList<>(Arrays.asList(temp_text2));

        Iterator<String> iterator1 = temp_arrayList1.iterator();
        Iterator<String> iterator2 = temp_arrayList2.iterator();

        

        
    }
    
}
