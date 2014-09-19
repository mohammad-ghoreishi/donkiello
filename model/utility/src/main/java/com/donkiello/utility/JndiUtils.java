package com.donkiello.utility;


import com.donkiello.utility.beans.JndiBrowser;
import java.util.logging.Logger;
import javax.naming.InitialContext;

/**
 * Created by reza on 1/7/14.
 */
public class JndiUtils {

    private static Logger logger = Logger.getLogger(JndiUtils.class.getName());

    public static synchronized Object getModelEjb(String ejbName) {
        if (ejbName == null || "".equals(ejbName.trim())) {
            return null;
        }
        try {
            InitialContext ctx = new InitialContext();
            JndiBrowser b = null;
            try {
                b = (JndiBrowser) JSFUtils.getManagedBeanValue("jndiBrowser");
            } catch (Exception ex) {
                b = new JndiBrowser();
            }
            Object ejb = ctx.lookup(b.getRootJndi() + ejbName.trim());
            return ejb;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

   

}
