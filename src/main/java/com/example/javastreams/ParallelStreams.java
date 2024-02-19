package com.example.javastreams;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Stream;

import static com.example.javastreams.ParallelStreams.DataObject.createMap;

public class ParallelStreams {

    public static void main(String[] args) {
        System.setProperty("http.agent", "Chrome");
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
            try {
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();

                Stream<DataObject> lines = new BufferedReader(new InputStreamReader(inputStream)).lines()
                        .map(e -> createMap(e)).filter(e -> e.getAge() >= 50 );

                lines.forEach(s -> System.out.println(s));



            } catch (IOException ioEx) {
                System.out.println(ioEx);
            }
        } catch (MalformedURLException malEx) {
            System.out.println(malEx);
        }


    }
    static class DataObject {
        private String key;
        private Integer age;

        static public DataObject createMap(String toString) {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(toString);
            try {
                return mapper.readValue(toString, DataObject.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}

