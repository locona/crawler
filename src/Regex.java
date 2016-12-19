import java.util.regex.*;
public class Regex {
    public static void main(String[] args) {
      String str = "http://hogehoge.com/img/index.html";           // 文字列(URL)
      String regex = "^((.+?)://)?(.*?)?(?::([0-9]+))?(/.*)?$";   // 正規表現(URLを分解するための)

      Pattern pat = Pattern.compile(regex);   // 指定された正規表現をパターンにコンパイル
      Matcher mat = pat.matcher(str);         // 文字列とパターンをマッチする正規表現エンジンを作成

      if (mat.find()) {
        System.out.println("protocol : " + mat.group(2));
        System.out.println("host : " + mat.group(3));
        System.out.println("port : " + mat.group(4));
        System.out.println("path : " + mat.group(5));
      }
    }
}
