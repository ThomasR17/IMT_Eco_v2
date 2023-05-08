package fr.imt_atlantique.imt_eco_v2;

public class LandscapeModel {
    // Lien vers la base de données contenant l'url des images:
    // https://console.firebase.google.com/project/imt-eco-v2-369b5/database/imt-eco-v2-369b5-default-rtdb/data
    public String imageUrl;

    public LandscapeModel() {
        // Required empty constructor for Firebase
    }

    public LandscapeModel(String url){
        this.imageUrl=url;
    }
}
