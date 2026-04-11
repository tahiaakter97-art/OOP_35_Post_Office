package com.example.postofficesystem.Mahfuz;

import com.example.postofficesystem.Mahfuz.model.ParcelTrack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParcelTrackFileUtil {

    private static final String FILE_NAME = "parcels.dat";

    // ================= SAVE (BINARY WRITE) =================
    public static void saveAll(List<ParcelTrack> list) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(list);

        } catch (Exception e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }

    // ================= LOAD (BINARY READ) =================
    public static List<ParcelTrack> loadParcels() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (List<ParcelTrack>) ois.readObject();

        } catch (Exception e) {
            System.out.println("Load error: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}