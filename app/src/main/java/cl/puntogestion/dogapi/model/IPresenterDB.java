package cl.puntogestion.dogapi.model;

import com.google.firebase.firestore.DocumentSnapshot;

import java.util.List;

public interface IPresenterDB {
    void notificarFavImagenes(List<DocumentSnapshot> imagenesFav);
}
