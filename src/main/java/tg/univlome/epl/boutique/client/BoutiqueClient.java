/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package tg.univlome.epl.boutique.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 *
 * @author steeltitanunbrk
 */
public class BoutiqueClient {

    private static final String URL = "http://localhost:8080/boutique-web/rs/";
    
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();  
        Response response = client.target(URL)
                .path("/produit")
                .request()
                .get();
        if (response.getStatus() >= 300) {
            System.out.println("Erreur, code : " + response.getStatus());
            return;
        }
        String liste = response.readEntity(String.class);
        System.out.println(liste);
    }
}
