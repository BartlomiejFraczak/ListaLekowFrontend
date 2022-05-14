package BartlomiejFraczak.ListaLekowFrontend;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lek {

    private long id;
    private String nazwa_leku;
    private LocalDate data_waznosci;
    private int ilosc_opakowan_w_magazynie;

//    public Lek() {
//    }
//
//    public Lek(long id, String nazwa_leku, String data_waznosci, int ilosc_opakowan_w_magazynie) {
//        this.id = id;
//        this.nazwa_leku = nazwa_leku;
//        this.data_waznosci = data_waznosci;
//        this.ilosc_opakowan_w_magazynie = ilosc_opakowan_w_magazynie;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNazwa_leku() {
        return nazwa_leku;
    }

    public void setNazwa_leku(String nazwa_leku) {
        this.nazwa_leku = nazwa_leku;
    }

    public LocalDate getData_waznosci() {
        return data_waznosci;
    }

    public void setData_waznosci(LocalDate data_waznosci) {
        this.data_waznosci = data_waznosci;
    }

    public void setData_waznosci(String data_waznosci) { // Jackson nie dawał rady z datami
        this.data_waznosci = LocalDate.parse(data_waznosci);
    }

    public int getIlosc_opakowan_w_magazynie() {
        return ilosc_opakowan_w_magazynie;
    }

    public void setIlosc_opakowan_w_magazynie(int ilosc_opakowan_w_magazynie) {
        this.ilosc_opakowan_w_magazynie = ilosc_opakowan_w_magazynie;
    }

    public List<Lek> getLeki() throws IOException {

        // Połączenie z backendem:
        URL url = new URL("http://localhost:8090/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Zczytanie odpowiedzi:
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        // JSON -> List<Lek>:
        ObjectMapper objectMapper = new ObjectMapper();
        Lek[] leki = objectMapper.readValue(content.toString(), Lek[].class);
        List<Lek> lekiList = new ArrayList(Arrays.asList(leki));

        return lekiList;

    }

}
