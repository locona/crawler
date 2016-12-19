import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Crawler {

  public static void main(String[] args) throws MalformedURLException, IOException {
    String urlStr = "http://www.ise.shibaura-it.ac.jp/";
//    String urlStr = "http://www.shibaura-it.ac.jp/request_brochure/index.html";
    URL url = new URL(urlStr);
    URI uri = new URI(urlStr);

    Source src = new Source(url);
    uri.createFile(src);
//    SourceFormatter sf = src.getSourceFormatter();
//    FileUtils.writeStringToFile(new File("index.html"), sf.toString(), "utf-8");

    // aタグを取得
    List<Element> aList = src.getAllElements("a");
    List<Element> targetList = new ArrayList<Element>();

    for (Element element : aList){
//        System.out.println("===============");
//        System.out.println(element.getAttributeValue("href"));

        targetList.add(element);
    }

    for (Element e : targetList) {
      /* System.out.println(e); */


    }

//    Source targetPage = null;
//    for (Element element : targetList){
//      targetPage = new Source(new URL(element.getAttributeValue("href")));
//      System.out.println(targetPage.getElementById("body").getTextExtractor());
//    }
  }

//  public static boolean isTarget(Element element){
//    if (element.getParentElement().getName() == "li" &&
//          element.getParentElement().getParentElement().getName() == "ul" &&
//          element.getParentElement().getParentElement().getParentElement().getName() == "li" &&
//          element.getParentElement().getParentElement().getParentElement().getParentElement().getName() == "ul"
//      ){
//      return true;
//    }
//    return false;
//  }
}
