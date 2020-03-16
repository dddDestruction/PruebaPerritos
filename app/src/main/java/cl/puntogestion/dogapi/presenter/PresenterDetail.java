package cl.puntogestion.dogapi.presenter;

import cl.puntogestion.dogapi.model.IModel;

public class PresenterDetail implements IPresenterDetail, IPresenterViewDetail  {

    IPresenterViewDetail iPresenterViewDetail;
    IModel imodel;

    public PresenterDetail(IPresenterViewDetail iPresenterViewDetail) {
        this.iPresenterViewDetail = iPresenterViewDetail;
    }

    public void setImodel(IModel imodel) {
        this.imodel = imodel;
    }

    @Override
    public void loadBreedImages(String breed) {

    }

    @Override
    public void loadSubBreedImages(String breed, String subBreed) {

    }

    @Override
    public void showBreedImages(String breed) {
        iPresenterViewDetail.showBreedImages(breed);
    }
}
