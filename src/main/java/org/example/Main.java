package org.example; 
import java.util.regex.*; 
 
public class Main { 
    public static void main(String[] args) { 
        String secretText1 = "<div>\n" + 
                "<p>Символи <> круглих дужок <code>'('</code> та <code>')'</code>. <br />Ці символи\n" + 
                "дозволяють отримати з рядка додаткову інформацію.\n" + 
                "<br/>Зазвичай, якщо парсер регулярних виразів шукає в тексті інформацію\n" + 
                "за заданим виразом і знаходить її - він просто повертає\n" + 
                "знайдений рядок.</p>\n" + 
                "<p align=\"right\">А ось тут <a href=\"google.com\">посилання</a>, щоб життя медом не здавалося.</p>\n" + 
                "</div>"; 
        String phoneNumber1 = "(+380)68-872-15-14"; 
        String phoneNumber2 = "+1-555-12343"; 
        String textToClean = "Я не                хочу    бути         програмістом, а хочу     бути DevOps :)"; 
 
        Pattern phonePattern = Pattern.compile("\\(\\+380\\)\\d{2}-\\d{3}-\\d{2}-\\d{2}"); 
        checkPhoneNumber(phonePattern, phoneNumber1); 
        checkPhoneNumber(phonePattern, phoneNumber2); 
 
        String spacePattern = "\\s{2,}"; 
        String cleanedText = textToClean.replaceAll(spacePattern, " "); 
        System.out.println("\nText cleaned of unnecessary spaces: " + cleanedText); 
 
        String htmlTagPattern = "(<[^>]+>|<+>)"; 
        String cleanedTextWithoutTags = secretText1.replaceAll(htmlTagPattern, ""); 
        System.out.println("\nText cleaned of HTML tags: " + cleanedTextWithoutTags); 
    } 
    public static void checkPhoneNumber(Pattern pattern, String phoneNumber) { 
        Matcher matcher = pattern.matcher(phoneNumber); 
        if (matcher.matches()) { 
            System.out.println("Number is valid, pattern matched: " + phoneNumber); 
        } else { 
            System.out.println("Number is invalid, pattern not matched: " + phoneNumber); 
        } 
    } 
}
