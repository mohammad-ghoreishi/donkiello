package com.donkiello.utility.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

/**
 * Created by Mohammad Ghoreishi on 9/5/2014.
 */

@ManagedBean(name = "jndiBrowser")
@ApplicationScoped
public class JndiBrowser {

    private static final String prefix = "java:global";
    private String productJndi;
    private String modelJndi;

    public JndiBrowser() {
        initial();
    }

    public String getProductJndi() {
        return productJndi;
    }

    public void setProductJndi(String productJndi) {
        this.productJndi = productJndi;
    }

    public String getModelJndi() {
        return modelJndi;
    }

    public void setModelJndi(String modelJndi) {
        this.modelJndi = modelJndi;
    }

    public String getRootJndi() {
        return prefix + "/" + getProductJndi() + "/" + getModelJndi() + "/";
    }

    public void initial() {
        InitialContext ctx = null;
        try {
            ctx = new InitialContext();
            NamingEnumeration<NameClassPair> tmp = ctx.list("java:global");
            while (tmp.hasMore())   {
                NameClassPair t =tmp.next();
                if ( t.getName().startsWith("model-product")) {
                    productJndi = t.getName() ;
                    NamingEnumeration<NameClassPair> tmp1 = ctx.list("java:global/" + productJndi);
                    while (tmp1.hasMore()) {
                        NameClassPair t1 = tmp1.next();
                        if ( t1.getName().startsWith("model-impl")) {
                            modelJndi = t1.getName();
                            break;
                        }
                    }
                    break;
                }
            }
        } catch (NamingException e) {
            productJndi = null;
            modelJndi = null;
            e.printStackTrace();
        }
    }


}
