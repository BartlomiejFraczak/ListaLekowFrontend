package BartlomiejFraczak.ListaLekowFrontend;

import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LekiTableModel extends AbstractTableModel {

    private final String[] columnNames = {
            "id",
            "Nazwa leku",
            "Data ważności",
            "Ilość opakowań w magazynie"
    };
    private ArrayList<Lek> lekList;

    public LekiTableModel() throws IOException {
        this.lekList = new Lek().getLeki();

        List<String[]> data = new ArrayList<>();

        for (Lek lek : lekList) {
            data.add(new String[]{
                    String.valueOf(lek.getId()),
                    lek.getNazwa_leku(),
                    lek.getData_waznosci().toString(),
                    String.valueOf(lek.getIlosc_opakowan_w_magazynie())
            });
        }

    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public ArrayList<Lek> getLekList() {
        return lekList;
    }

    public void setLekList(ArrayList<Lek> lekList) {
        this.lekList = lekList;
    }

    @Override
    public int getRowCount() {
        return lekList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int column, int row) {
        switch (row) {
            case 0:
                return lekList.get(column).getId();
            case 1:
                return lekList.get(column).getNazwa_leku();
            case 2:
                return lekList.get(column).getData_waznosci();
            case 3:
                return lekList.get(column).getIlosc_opakowan_w_magazynie();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
