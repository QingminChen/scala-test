import java.util.*;

/**
 * Created by qingmin.chen on 6/4/2016.
 */
public class ContinueBreakTest {//我们这里的需求是，只要开头不为-，结果是scala的字符串
    public static void main( String[] args )
    {
        String [] abc = {"-a.scala","b.scala","c.scala","d.txt","e.scala","-f.scala"};
        boolean findStatus = false;
        int i = 0;
        List<String> resultStr = new java.util.ArrayList<String>();

        while(i<abc.length){
            if(abc[i].startsWith("-")){
                findStatus = false;
                i++;
                continue;     //这里的continue就是退出当前的这个对象的值得循环，后面的if也不执行了，直接执行下一个对象的循环
            }
            if(abc[i].endsWith(".scala")){
                findStatus = true;
                resultStr.add(abc[i]);
//                break;       //这个直接退出整个while循环，后面管是否符合条件都不执行了，所以要达到找到所有的符合条件的字符串，应该写成continue,并且要在每一种情况下都要保证递增的正确性
                  i++;
                  continue;
            }
            findStatus = false;
            i++;          //这里是因为前两种情况都不符合情况之下(d.txt)，要保证递增的正确性
            continue;
        }
        System.out.println(resultStr.toString());
    }
}
