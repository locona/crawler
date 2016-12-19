import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.SourceFormatter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URI {
  public String url;
  public String host;
  public String path;
  public List<String> pathWithArray;
  private final String REGEX = "^((.+?)://)?(.*?)?(?::([0-9]+))?(/.*)?$";
  public URI(String url) {
    this.url = url;
    Pattern pat = Pattern.compile(REGEX);
    Matcher mat = pat.matcher(url);

    if(mat.find()) {
      this.host = mat.group(3);
      if(mat.group(5) == null || mat.group(5).equals("/")) {
        this.path = "index.html";
      } else {
        this.path = mat.group(5);
      }
    }
    this.splitPath();
  };

  public void splitPath() {
    List<String> list = new ArrayList<String>(Arrays.asList(path.split("/")));
    for(int i=0; i < list.size(); i++) {
      if (list.get(i).length() == 0) list.remove(i);
    }
    this.pathWithArray = list;
  }

  public void createFile(Source src) throws IOException {
    SourceFormatter sf = src.getSourceFormatter();

    if(this.pathWithArray.size() == 1) {
      File f = new File(this.pathWithArray.get(0));
      FileUtils.writeStringToFile(f, sf.toString(), "utf-8");
    } else {
      String dirs = null;
      for(int i=0; i<this.pathWithArray.size() - 1; i++) {
        dirs += this.pathWithArray.get(i);
      }
      File f_dirs = new File(dirs);
      f_dirs.mkdirs();
      File f = new File(dirs, this.pathWithArray.get(pathWithArray.size() - 1));
      FileUtils.writeStringToFile(f, sf.toString(), "utf-8");
    }



  }

}
