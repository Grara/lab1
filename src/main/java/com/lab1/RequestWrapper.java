package com.lab1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class RequestWrapper extends HttpServletRequestWrapper {
    private Map<String, String[]> modifiableParameters;
    private Map<String, String[]> allParameters;

    public RequestWrapper(HttpServletRequest request) {
        super(request);
        this.modifiableParameters = new HashMap<>();
        this.allParameters = new HashMap<>();
        this.allParameters.putAll(request.getParameterMap());
        this.allParameters.put("dd", new String[]{"커스텀밸류"});
    }

    public void setParameter(String name, String value) {
        modifiableParameters.put(name, new String[]{value});
        allParameters.put(name, new String[]{value});
    }

    public void setParameter(String name, String[] values) {
        modifiableParameters.put(name, values);
        allParameters.put(name, values);
    }

    @Override
    public String getParameter(String name) {
        if(name.equals("dd")){
            return "커스텀밸류";
        }
        String[] values = getParameterValues(name);
        return (values != null && values.length > 0) ? values[0] : null;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return Collections.unmodifiableMap(allParameters);
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(allParameters.keySet());
    }

    @Override
    public String[] getParameterValues(String name) {
        return allParameters.get(name);
    }
}
