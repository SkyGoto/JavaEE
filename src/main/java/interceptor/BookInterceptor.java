package interceptor;

import action.BookAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.io.File;

public class BookInterceptor extends AbstractInterceptor {
    String pattern = "\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa |asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b";
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        BookAction action = (BookAction) actionInvocation.getAction();
        if (action.getBook().getPrice()<10){
            System.out.println("------------------");
            action.setMessage("价格大于10!!!!");
            return "input";
        }


//        boolean matches = action.getAuthor().getEmail().matches(pattern);
//        if (!matches) {
//            action.setMessage("邮箱格式不正确 !");
//            return "input";
//        }

        if ( action.getBookIntroFileName() == null || action.getBookIntroFileName().equals("")){
            action.setBookIntroFileName("_default.txt");
            action.setBookIntro(new File("/home/misaki/IdeaProjects/webTest9/out/artifacts/Test4_war_exploded/upLoadFile/_default.txt"));
        }else if(!action.getBookIntroContentType().equals("text/plain")) {
            action.setMessage("文件类型不对 !");
            return "input";
        }
//        else if (!action.getBookIntroFileName().equals("")){
//            action.setMessage("文件名不对 !");
//            return "input";
//        }
        System.out.println("------------------");
        return actionInvocation.invoke();
    }
}
