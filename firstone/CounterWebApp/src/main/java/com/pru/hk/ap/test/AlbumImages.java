package com.pru.hk.ap.test;

import java.lang.reflect.Field;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class AlbumImages {
    public String image_id;
    public String user_id;
    public String albumId;

public static void main(String[] args) {
        Albums albums = new Albums();
        albums.title = "Free Music Archive - Albums";
        albums.message = "";
        albums.total = "11259";
        albums.total_pages = 2252;
        albums.page = 1;
        albums.limit = "5";
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting().serializeNulls();
        builder.setFieldNamingStrategy(new FieldNamingStrategy() {
 
            @Override
            public String translateName(Field f) {
                if (f.getName().equals("albumId"))
                    return "album_id";
                else
                    return f.getName();
            }
        });
        Gson gson = builder.create();
        
 
        AlbumImages image = new AlbumImages();
        image.image_id = "1";
        image.albumId = "10";
 
        System.out.println(gson.toJson(albums));
 
    }
}