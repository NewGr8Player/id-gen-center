package com.xavier.center.util;


import com.xavier.center.config.BasicScript;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.codehaus.groovy.control.CompilerConfiguration;

import java.util.Hashtable;
import java.util.Map;

public class ExprUtil {

    private static final Object lock = new Object();
    private static final GroovyShell shell;

    private static Hashtable<String, Script> cache = new Hashtable<>();

    static {
        CompilerConfiguration cfg = new CompilerConfiguration();
        cfg.setScriptBaseClass(BasicScript.class.getName());

        shell = new GroovyShell(cfg);
    }

    public static Object parseExpr(String expr) {
        Script s = getScriptFromCache(expr);
        return s.run();
    }

    public static Object parseExpr(String expr, Map<?, ?> map) {
        Binding binding = new Binding(map);
        Script script = getScriptFromCache(expr);
        script.setBinding(binding);
        return script.run();
    }

    private static Script getScriptFromCache(String expr) {
        if (cache.contains(expr)) {
            return cache.get(expr);
        }
        synchronized (lock) {
            if (cache.contains(expr)) {
                return cache.get(expr);
            }
            Script script = shell.parse(expr);
            cache.put(expr, script);
            return script;
        }
    }

}