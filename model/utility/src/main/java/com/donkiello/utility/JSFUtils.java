package com.donkiello.utility;

import java.io.IOException;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Mohammad Ghoreishi on 9/5/2014.
 */
public class JSFUtils {
    
    public static Object resolveExpression(String expression) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);
        
        return valueExp.getValue(elContext);
    }
    
    public static Object resloveMethodExpression(String expression, Class returnType, Class[] argTypes, Object[] argValues) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        MethodExpression methodExpression = elFactory.createMethodExpression(elContext, expression, returnType, argTypes);
        
        return methodExpression.invoke(elContext, argValues);
    }
    
    public static Boolean resolveExpressionAsBoolean(String expression) {
        return (Boolean) resolveExpression(expression);
    }
    
    public static String resolveExpressionAsString(String expression) {
        return (String) resolveExpression(expression);
    }
    
    public static Object getManagedBeanValue(String beanName) {
        StringBuffer buff = new StringBuffer("#{");
        buff.append(beanName);
        buff.append("}");
        return resolveExpression(buff.toString());
    }
    
    public static void setExpressionValue(String expression, Object newValue) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);
        
        Class bindClass = valueExp.getType(elContext);
        if ((bindClass.isPrimitive()) || (bindClass.isInstance(newValue))) {
            valueExp.setValue(elContext, newValue);
        }
    }
    
    public static void setManagedBeanValue(String beanName, Object newValue) {
        StringBuffer buff = new StringBuffer("#{");
        buff.append(beanName);
        buff.append("}");
        setExpressionValue(buff.toString(), newValue);
    }
    
    public static void storeOnSession(String key, Object object) {
        FacesContext ctx = getFacesContext();
        Map sessionState = ctx.getExternalContext().getSessionMap();
        sessionState.put(key, object);
    }
    
    public static void removeFromSession(Object key) {
        FacesContext ctx = getFacesContext();
        Map sessionState = ctx.getExternalContext().getSessionMap();
        sessionState.remove(key);
    }
    
    public static Object getFromSession(String key) {
        FacesContext ctx = getFacesContext();
        Map sessionState = ctx.getExternalContext().getSessionMap();
        return sessionState.get(key);
    }
    
    public static void addFacesErrorMessage(String msg) {
        FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "");
        ctx.addMessage(null, fm);
    }
    
    public static void addFacesWarningMessage(String msg) {
        FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, "");
        ctx.addMessage(null, fm);
    }
    
    public static void addFacesInfoMessage(String msg) {
        FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "");
        ctx.addMessage(null, fm);
    }
    
    public static void addFacesErrorMessage(String attrName, String msg) {
        FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, attrName, msg);
        
        ctx.addMessage(getRootViewComponentId(), fm);
    }
    
    public static String getRootViewId() {
        return getFacesContext().getViewRoot().getViewId();
    }
    
    public static String getRootViewComponentId() {
        return getFacesContext().getViewRoot().getId();
    }
    
    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
    
    public static ExternalContext getExternalContext() {
        FacesContext ctx = getFacesContext();
        return ctx.getExternalContext();
    }
    
    public static String getReferer() {
        HttpServletRequest origRequest
                = (HttpServletRequest) getExternalContext().getRequest();
        return (origRequest.getHeader("referer"));
    }
    
    public static void sendRedirect(String url) throws IOException {
        HttpServletResponse response = (HttpServletResponse) getFacesContext().getExternalContext().getResponse();
        response.sendRedirect(url);
    }
    
    public static Object getRequestAttribute(String name) {
        return getFacesContext().getExternalContext().getRequestMap().get(name);
    }
    
    public static void setRequestAttribute(String name, Object value) {
        getFacesContext().getExternalContext().getRequestMap().put(name, value);
    }
    
    public static String getFromHeader(String key) {
        FacesContext ctx = getFacesContext();
        ExternalContext ectx = ctx.getExternalContext();
        return (String) ectx.getRequestHeaderMap().get(key);
    }
    
    public static Object getFromRequest(String key) {
        FacesContext ctx = getFacesContext();
        Map sessionState = ctx.getExternalContext().getRequestMap();
        return sessionState.get(key);
        //Map request = (Map) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        //request.get("Your Key");
    }
    
    public static Object getFromResponse(String key) {
        FacesContext ctx = getFacesContext();
        Map sessionState = (Map) ctx.getExternalContext().getResponse();
        return sessionState.get(key);
    }
    
    public static String getFromRequestParameter(String key) {
        FacesContext ctx = getFacesContext();
        Map<String, String> sessionState = ctx.getExternalContext().getRequestParameterMap();
        return sessionState.get(key);
    }
    
    public static UIComponent findComponentInRoot(String id) {
        UIComponent component = null;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext != null) {
            UIComponent root = facesContext.getViewRoot();
            component = findComponent(root, id);
        }
        return component;
    }
    
    public static UIComponent findComponent(UIComponent base, String id) {
        if (id.equals(base.getId())) {
            return base;
        }
        UIComponent children = null;
        UIComponent result = null;
        Iterator childrens = base.getFacetsAndChildren();
        while ((childrens.hasNext()) && (result == null)) {
            children = (UIComponent) childrens.next();
            if (id.equals(children.getId())) {
                result = children;
            } else {
                result = findComponent(children, id);
                if (result != null) {
                    break;
                }
            }
        }
        return result;
    }
    
    public static Object getExpressionObjectReference(String expression) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elctx = fc.getELContext();
        ExpressionFactory elFactory = fc.getApplication().getExpressionFactory();
        return elFactory.createValueExpression(elctx, expression, Object.class).getValue(elctx);
    }
    
    public static Object invokeMethodExpression(String expr, Class returnType, Class[] argTypes, Object[] args) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elctx = fc.getELContext();
        ExpressionFactory elFactory = fc.getApplication().getExpressionFactory();
        MethodExpression methodExpr = elFactory.createMethodExpression(elctx, expr, returnType, argTypes);
        return methodExpr.invoke(elctx, args);
    }
    
    public static Map flash() {
        return FacesContext.getCurrentInstance().getExternalContext().getFlash();
    }
    
    
    private static Logger logger = Logger.getLogger(JSFUtils.class.getName());
}
