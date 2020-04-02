package cl.puntogestion.dogapi.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cl.puntogestion.dogapi.MainActivity;
import cl.puntogestion.dogapi.model.IFirebaseModel;
import cl.puntogestion.dogapi.model.IPresenterDB;

public class PresenterFav implements IPresenterFav, IPresenterDB {

    private List<String> favoritas = new ArrayList<String>();
    private static final String TAG = "AAA";
    private IFirebaseModel iFirebaseModel;
    private IPresenterFavView iPresenterFavView;

    public PresenterFav(IPresenterFavView iPresenterFavView) {
        this.iPresenterFavView = iPresenterFavView;
    }

    public void setiFirebaseModel(IFirebaseModel iFirebaseModel) {
        this.iFirebaseModel = iFirebaseModel;
    }

    @Override
    public void showFavBreedImages() {
        Log.d(TAG, "En PresenterFav, showFavBreedImages()");
        iFirebaseModel.getFavImagenes();
    }

    @Override
    public void addFavBreedImagen(String url) {
        Log.d(TAG, "En PresenterFav, addFavBreedImagen() " + url);
        iFirebaseModel.addFavImagenes(url);
    }

    @Override
    public void notificarFavImagenes(Map<String, Object> imagenesFav) {

        for (String key : imagenesFav.keySet()){
            favoritas.add(imagenesFav.get(key).toString());
        }
        Log.d(TAG, "En PresenterFav, notificarFavImagenes() " + favoritas);
        iPresenterFavView.notificarFav(favoritas);
    }

    public interface IPresenterFavView{
        void notificarFav(List<String> urls);
    }
}
