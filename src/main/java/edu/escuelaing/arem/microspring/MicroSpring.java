package edu.escuelaing.arem.microspring;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MicroSpring implements UriProcessor {

    private static final Logger LOGGER = Logger
            .getLogger(MicroSpring.class.getName());
    private Map<String, Method> methods = new HashMap<>();

    @Override
    public void start(String component) throws Exception {
        for (Method m : Class.forName(component).getMethods()) {
            if (m.isAnnotationPresent(RequestMapping.class)) {
                try {
                    RequestMapping rm = m.getAnnotation(RequestMapping.class);
                    methods.put(rm.value(), m);
                    m.invoke(null);
                } catch (Throwable ex) {
                    // Nothing to do
                }
            }
        }
    }

    @Override
    public String invoke(String path) {
        path = path.replace("/webapp", "");
        try {
            return methods.get(path).invoke(null).toString();
        } catch (InvocationTargetException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return "Error!";
    }

}
