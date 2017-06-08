package sixteen.december.sixteenth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2016/12/16
 * Time: 16:19
 */
public class InitLog4JServlet extends HttpServlet {

    private static final long serialVersionUID = 2134126566724296970L;

    @Override
    public void init() throws ServletException {
        super.init();
        //org.apache.ibatis.logging.LogFactory.useLog4JLogging();
    }
}
