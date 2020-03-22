package cl.puntogestion.dogapi.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class PresenterFav {

    private List<String> favoritas = new ArrayList<String>();
    private static final String TAG = "AAA";

    public List<String> notificarFav(){
        favoritas.add("http://1.bp.blogspot.com/_eYl3G1EYGr0/SVTgYNf-ABI/AAAAAAAAAuo/aydTAstjncU/s400/razas-perros-akita-americano.jpg");
        favoritas.add("http://3.bp.blogspot.com/_eYl3G1EYGr0/Sa7AQCIWkkI/AAAAAAAAAzY/voHBmLfthik/s320/razas-perros-broholmer.jpg");
        favoritas.add("http://4.bp.blogspot.com/_n_Odiv2B52M/SSoWwAaLZeI/AAAAAAAAABM/bmCsLLwgFmg/S269/razas-perros-collie.jpg");
        favoritas.add("https://www.hillspet.co.uk/content/dam/cp-sites/hills/hills-pet/global/articles/dog-care/dog-breeds/img_DogBreed-Beagle.jpg");
        favoritas.add("https://thenypost.files.wordpress.com/2013/11/corgi.jpg?quality=90&strip=all&w=1200");
        favoritas.add("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Berger_blanc_suisse3.jpg/220px-Berger_blanc_suisse3.jpg");
        favoritas.add("https://www.mundoanimalia.com/images/animal/f3/b3/ea/1a3f528a7f59019679c74f693310a5e1/thumbm_image__5697.jpeg");
        favoritas.add("https://vignette.wikia.nocookie.net/perros/images/5/5d/Belgagro.jpg/revision/latest?cb=20071206030759");
        favoritas.add("https://t2.ea.ltmcdn.com/es/razas/9/1/1/img_119_pastor-belga-groenendael_3_150_square.jpg");
        favoritas.add("https://lalupa3.webcindario.com/mascotas/imagenes/pastor%20belga1.jpg");
        Log.d(TAG, "En notificarFav en PresenterFav listasize" +favoritas.size());
        return favoritas;
    }

}
