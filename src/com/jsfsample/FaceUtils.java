package com.jsfsample;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

@Named
@ApplicationScoped
public class FaceUtils implements Serializable {
    public String valid(String id) {
        FacesContext context = FacesContext.getCurrentInstance();
        UIInput ui = (UIInput) context.getViewRoot().findComponent(id);
        return ui.isValid() ? "" : "background-color:lightpink";
    }


    public static void flash(String key, Object value) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().getFlash().put(key, value);
    }

    public static Object requestMap(String key) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        Map<String, Object> requestMap = ctx.getExternalContext().getRequestMap();
        return requestMap.get(key);
    }

    public static void requestMap(String key, Object value) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        Map<String, Object> requestMap = ctx.getExternalContext().getRequestMap();
        requestMap.put(key, value);
    }

    public static Object viewMap(String key) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        Map<String, Object> viewMap = ctx.getViewRoot().getViewMap();
        return viewMap.get(key);
    }

    public static void viewMap(String key, Object value) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        Map<String, Object> viewMap = ctx.getViewRoot().getViewMap();
        viewMap.put(key, value);
    }

    public static void message(UIComponent item, String msg) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        String id = item.getClientId(ctx);
        ctx.addMessage(id, new FacesMessage(msg));
    }
}
