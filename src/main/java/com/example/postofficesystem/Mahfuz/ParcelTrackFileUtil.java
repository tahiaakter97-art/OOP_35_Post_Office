package com.example.postofficesystem.Mahfuz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParcelTrackFileUtil {

    private static final String FILE_NAME = "parcels.txt";

    // LOAD DATA FROM FILE
    public static List<com.example.postofficesystem.Mahfuz.model.ParcelTrack> loadParcels() {

        List<com.example.postofficesystem.Mahfuz.model.ParcelTrack> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                // minimum required fields
                if (data.length >= 5) {

                    com.example.postofficesystem.Mahfuz.model.ParcelTrack p = new com.example.postofficesystem.Mahfuz.model.ParcelTrack(
                            data[0], // trackingId
                            data[1], // senderName
                            data[2], // receiverName
                            data[3], // address
                            data[4]  // status
                    );

                    // optional fields (safe handling)
                    if (data.length > 5) {
                        p.setFailureReason(data[5]);
                    } else {
                        p.setFailureReason("");
                    }

                    if (data.length > 6) {
                        p.setRescheduleDate(data[6]);
                    } else {
                        p.setRescheduleDate("");
                    }

                    list.add(p);
                }
            }

        } catch (Exception e) {
            System.out.println("File read error: " + e.getMessage());
        }

        return list;
    }

    // SAVE ALL DATA BACK TO FILE
    public static void saveAll(List<com.example.postofficesystem.Mahfuz.model.ParcelTrack> list) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (com.example.postofficesystem.Mahfuz.model.ParcelTrack p : list) {
                bw.write(p.toFileString());
                bw.newLine();
            }

        } catch (Exception e) {
            System.out.println("File write error: " + e.getMessage());
        }
    }
}