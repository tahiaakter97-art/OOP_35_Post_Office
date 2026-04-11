package com.example.postofficesystem.Mahfuz;

import com.example.postofficesystem.Mahfuz.model.ParcelTrack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ParcelTrackFileUtil {

    private static final String FILE_NAME = "parcels.txt";

    public static List<ParcelTrack> loadParcels() {

        List<ParcelTrack> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 5) {

                    list.add(new ParcelTrack(
                            data[0],
                            data[1],
                            data[2],
                            data[3],
                            data[4]
                    ));
                }
            }

        } catch (Exception e) {
            System.out.println("File not found or empty: " + e.getMessage());
        }

        return list;
    }
}