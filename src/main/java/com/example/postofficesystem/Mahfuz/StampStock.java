package com.example.postofficesystem.Mahfuz;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StampStock {

    private static final String STOCK_FILE = "stamp_stock.csv";
    private static final String SALES_FILE = "stamp_sales.csv";

    // Default stock quantities
    private static final Map<String, Integer> DEFAULT_STOCK = new HashMap<>();
    static {
        DEFAULT_STOCK.put("Stamp (Domestic) - 5৳", 100);
        DEFAULT_STOCK.put("Stamp (International) - 15৳", 100);
        DEFAULT_STOCK.put("Envelope (A4) - 10৳", 100);
        DEFAULT_STOCK.put("Postcard - 20৳", 100);
        DEFAULT_STOCK.put("Packing Box (Small) - 50৳", 100);
    }

    // Price map
    public static final Map<String, Integer> PRICES = new HashMap<>();
    static {
        PRICES.put("Stamp (Domestic) - 5৳", 5);
        PRICES.put("Stamp (International) - 15৳", 15);
        PRICES.put("Envelope (A4) - 10৳", 10);
        PRICES.put("Postcard - 20৳", 20);
        PRICES.put("Packing Box (Small) - 50৳", 50);
    }

    // Load stock from CSV; if file missing, return defaults
    public static Map<String, Integer> loadStock() {
        Map<String, Integer> stock = new HashMap<>(DEFAULT_STOCK);
        File file = new File(STOCK_FILE);
        if (!file.exists()) return stock;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    try {
                        stock.put(parts[0].trim(), Integer.parseInt(parts[1].trim()));
                    } catch (NumberFormatException ignored) {}
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stock;
    }

    // Save stock map to CSV
    public static void saveStock(Map<String, Integer> stock) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(STOCK_FILE))) {
            for (Map.Entry<String, Integer> entry : stock.entrySet()) {
                pw.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Append a sale record to sales CSV
    public static void saveSaleRecord(String stampType, int quantity, int totalPrice) {
        boolean fileExists = new File(SALES_FILE).exists();
        try (PrintWriter pw = new PrintWriter(new FileWriter(SALES_FILE, true))) {
            if (!fileExists) {
                pw.println("Date,StampType,Quantity,TotalPrice");
            }
            String date = java.time.LocalDate.now().toString();
            pw.println(date + "," + stampType + "," + quantity + "," + totalPrice);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}