package txtProcess;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class wordDivison {
    /*
    利用IK分词器，对一个句子进行分词
     */
    public  static List<String> participle(String artcile)throws IOException{
        StringReader stringReader=new StringReader(artcile);//对article创建字符串输入流
        IKSegmenter ikSegmenter=new IKSegmenter(stringReader,true);//把文本输入IK分词器进行分词
        Lexeme lex;
        List<String> list=new ArrayList<String>();
        while ((lex=ikSegmenter.next())!=null){
            list.add(lex.getLexemeText());//分好的词存入list
        }
        return list;
    }
 /*词库
 收集两篇文章相互对比句子中出现的词
  */
 public static List<String> lexicon(String article1,String article2) throws IOException {
     List<String> particilpe1=participle(article1);
     List<String> particilpe2=participle(article2);
     final HashSet<String> hash=new HashSet<String>();
     particilpe1.forEach(article->hash.add(article));
     particilpe2.forEach(article->hash.add(article));
     return Arrays.asList(hash.toArray(new String[0]));
 }
}
