public class StringOps {
    ////////////////////////////////////////////////////////////
    ////// ///////
    ////// Reminder: ///////
    ////// allowed methods ///////
    ////// ///////
    ////// 1.charAt(int index) ///////
    ////// 2.length() ///////
    ////// 3.substring(int start) ///////
    ////// 4.substring(int start,int ends) ///////
    ////// 5.indexOf(String str) ///////
    ////// ///////
    ////// The rest are not allowed ! ///////
    ////// if you want to use a different ///////
    ////// method, and you can implement ///////
    ////// it using material from the course ///////
    ////// you need to implement a version of ///////
    ////// the function by yourself. ///////
    ////// ///////
    ////// see example for substring ///////
    ////// in Recitation 3 question 5 ///////
    ////// ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {

        String string = args[0];
        char chr = 'l';
        int[] arr = allIndexOf(string, chr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static String capVowelsLowRest(String string) {
        String str = "";

        for (int i = 0; i < string.length(); i++) {
            char current = string.charAt(i);

            if (current == 97 || current == 105 || current == 101 || current == 111 || current == 117) {
                str = str + (char) (string.charAt(i) - 32);
            } else if (string.charAt(i) >= 65 && string.charAt(i) <= 90 && current != 'A' && current != 'I'
                    && current != 'E' && current != 'O') {
                str = str + (char) (string.charAt(i) + 32);
            } else {
                str = str + current;
            }

        }
        return str;
    }

    public static String camelCase(String string) {

        String str = "";
        if (string.charAt(0) >= 65 && string.charAt(0) <= 90) { // אם התו הראשון הוא אות גדולה תשתנה
            str = str + (char) (string.charAt(0) + 32);
        } else {
            str = str + string.charAt(0);
        }

        int n = 1;
        while (string.charAt(n) == 32) { // רץ על רווחים
            n++;

        }
        if (string.charAt(n) >= 65 && string.charAt(n) <= 90) { // אם אתה אות גדולה בתחילת משפט לאחר רווחים תשתנה
            str = str + (char) (string.charAt(n) + 32);
            n++;
        } else {
            str = str + string.charAt(n);
            n++;
        }

        for (int i = n; i < string.length(); i++) { // מתחיל לרוץ מהמקום הN
            char current = string.charAt(i);
            if (string.charAt(i - 1) == 32 && current != 32) { // אם לפניך היה רווח וכרגע התו אינו רווח
                if (current >= 65 && current <= 90) { // אות גדולה? תישאר כי שאר המילים שהן לא מילים ראשונות מתחילות
                                                      // באות גדולה
                    str = str + current;
                } else {
                    str = str + (char) (string.charAt(i) - 32); // הפוך לאות גדולה
                }
            }

            if (current != 32 && string.charAt(i - 1) != 32) {
                if (current >= 65 && current <= 90) {
                    str = str + (char) (string.charAt(i) + 32);
                } else {
                    str = str + current;
                }
            }

        }

        return str;

    }

    public static int[] allIndexOf(String string, char chr) {

        int n = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != 32 && string.charAt(i) == chr) {
                n++;

            }
        }
        int[] arr = new int[n];
        int index = 0;
        for (int i = 0; i < string.length(); i++) {
            if (chr == string.charAt(i)) {
                arr[index] = i;
                index++;

            }
        }

        return arr;
    }
}
