package BartlomiejFraczak.ListaLekowFrontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Lek> lekiList = new Lek().getLeki();

        JFrame frame = new JFrame();
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {
                "id",
                "Nazwa leku",
                "Data ważności",
                "Ilość opakowań w magazynie"
        };

        List<String[]> data = new ArrayList<>();

        for (Lek lek : lekiList) {
            data.add(new String[]{
                    String.valueOf(lek.getId()),
                    lek.getNazwa_leku(),
                    lek.getData_waznosci().toString(),
                    String.valueOf(lek.getIlosc_opakowan_w_magazynie())
            });
        }

        TableModel tableModel = new DefaultTableModel(data.toArray(new Object[][]{}), columnNames);
        JTable table = new JTable(tableModel);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
