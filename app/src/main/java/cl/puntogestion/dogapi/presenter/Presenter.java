package cl.puntogestion.dogapi.presenter;

import android.util.Log;

import java.util.List;

import cl.puntogestion.dogapi.model.IModel;
import cl.puntogestion.dogapi.model.IPresenterModel;

public class Presenter implements IPresenter, IPresenterModel {

    private static final String TAG = "Presenter";
    IModel imodel;
    IPresenterViewList iPresenterViewList;


    public Presenter(IPresenterViewList iPresenterViewList) {
        this.iPresenterViewList = iPresenterViewList;

    }

    public void setImodel(IModel imodel) {
        this.imodel = imodel;
    }

    @Override
    public void loadBreeds() {
        imodel.loadBreeds();
    }

    @Override
    public void loadBreedImages(String raza) {

    }

    @Override
    public void loadSubBreedImages(String raza, String subraza) {

    }

    @Override
    public void notificar(List<String> breeds) {
        Log.d(TAG, breeds.toString());
        iPresenterViewList.notificar(breeds);
    }

    public interface IPresenterViewList {
        void notificar(List<String> lista);
    }
}
