package com.apiAutomation.utilities;

import com.google.common.collect.HashBasedTable;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Payload {
    // add constrctor
    public Payload() {
    }

    public String constructPayload(String payload, Hashtable<String, String> dataTable) {
        Pattern patterns=Pattern.compile("\\[[a-zA-Z0-9_]+\\]");
        Matcher matcher=patterns.matcher(payload.trim());
        List<String> variableList=new ArrayList<>();
        while (matcher.find()){
            variableList.add(matcher.group());
        }
        for (String pattern:variableList) {
            try {
                if (dataTable.get(pattern.substring(1, pattern.length() - 1)).equalsIgnoreCase("emptyValue")) {
                    payload = payload.replace(pattern, "");
                } else if (dataTable.get(pattern.substring(1, pattern.length() - 1)).equalsIgnoreCase("nullValue")) {
                    payload = payload.replace(pattern, "null");
                } else {
                    payload = payload.replace(pattern, dataTable.get(pattern.substring(1, pattern.length() - 1)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return payload;


}

public static String getResourceContent(String resourcePath) {
    StringBuilder res = new StringBuilder();
    InputStream inputStream;
    BufferedReader bufferedReader;
    String lineInFile;
    try {
        inputStream = Payload.class.getResourceAsStream(resourcePath);
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while ((lineInFile = bufferedReader.readLine()) != null)
            res.append(lineInFile.trim());
        inputStream.close();
        bufferedReader.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return  res.toString();
}

}
