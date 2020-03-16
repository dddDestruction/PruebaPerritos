package cl.puntogestion.dogapi.presenter;

public interface IPresenterDetail {
    void loadBreedImages(String breed);
    void loadSubBreedImages(String breed, String subBreed);
    //  TODO void saveFavorite (favorite : Favorite);
}
