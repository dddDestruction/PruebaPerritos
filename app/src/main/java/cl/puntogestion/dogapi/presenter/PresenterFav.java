package cl.puntogestion.dogapi.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cl.puntogestion.dogapi.MainActivity;

public class PresenterFav implements IPresenterFav{

    private List<String> favoritas = new ArrayList<String>();
    private static final String TAG = "AAA";

    public List<String> notificarFav(){
        favoritas = getList();
        return favoritas;
    }

    private List<String> getList() {
        return MainActivity.getImagenes();
    }

    @Override
    public void showFavBreedImages(Map<String, String> breed) {

    }
}
