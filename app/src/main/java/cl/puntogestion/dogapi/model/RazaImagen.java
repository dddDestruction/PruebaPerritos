package cl.puntogestion.dogapi.model;

import java.util.Map;

public class RazaImagen {
    private String status;
    private Map<Integer,String>message;

    public String getStatus() {
        return status;
    }

    public Map<Integer, String> getMessage() {
        return message;

    }

    @Override
    public String toString() {
        return "RazaImagen{" +
                "status='" + status + '\'' +
                ", message=" + message +
                '}';
    }
}
