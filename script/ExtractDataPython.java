package script;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDataPython{
    //  Expressão regular com grupos de captura
    private String texto;
    private ArrayList<String> pattern_methods;
    private ArrayList<String> pattern_class;
    private ArrayList<String> methods;

    public ExtractDataPython(String texto){
        this.texto = texto;
        this.pattern_methods = this.loadMethodsPattern();
        this.pattern_class = loadClassPattern();
        this.methods = ExtractMetodos();
    }

    private ArrayList<String> loadMethodsPattern() {
        ArrayList<String> method1 = new ArrayList<>(); 
        method1.add("s");
        return method1;
    }

    private ArrayList<String> loadClassPattern() {
        ArrayList<String> method1 = new ArrayList<>();
        method1.add("s");
        return method1;
    }
    
    private ArrayList<String> ExtractMetodos() {
        ArrayList<String> matchedMethods = new ArrayList<>();
        
        for (String pttrn : pattern_methods) {
            Pattern pattern = Pattern.compile(pttrn);
            Matcher matcher = pattern.matcher(texto);

            while (matcher.find()) {
                matchedMethods.add(matcher.group());
            }
        }
        
        return matchedMethods;
    }

    public ArrayList<String> getMetodos(){
        return methods;
    }
}
